package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import scrapper.GoogleSearchResultScrapper;
import scrapper.MetroLyricsScrapper;
import app.LyricsToFileWriter;
import event.ClearEvent;
import event.ClearEventListener;
import event.CopyEvent;
import event.CopyEventListener;
import event.SaveAsEvent;
import event.SaveAsEventListener;
import event.SearchEvent;
import event.SearchEventListener;

/**
 * Class for creating the Main application GUI
 * 
 * @author RK Sanayaima Singh
 *
 */
public class ApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private TopPanel topPanel = new TopPanel();
	private LyricsPane lyricsPanel = new LyricsPane("Lyrics");
	private JLabel statusLabel = new JLabel("Ready");
	private GoogleSearchResultScrapper scrapper = new GoogleSearchResultScrapper();
	private MetroLyricsScrapper mlScrapper = new MetroLyricsScrapper();

	/**
	 * <code>title</code> is used as the Title of the Application Window
	 * 
	 * @param title
	 */
	public ApplicationFrame(String title) {
		super(title);
		setAllEventListeners();
		setLocationAtCenter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 600));

		add(topPanel, BorderLayout.NORTH);

		add(lyricsPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		scrapper.setCallingFrame(this);
		topPanel.setParentFrame(this);
		getRootPane().setDefaultButton(topPanel.getGoButton());

	}

	private void setLocationAtCenter() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		d.height = (d.height - 600) / 2;
		d.width = (d.width - 400) / 2;
		this.setLocation(d.width, d.height);
	}

	/**
	 * sets the status, at the bottom left corner of the application window
	 * 
	 * @param str
	 */
	public void setStatus(String str) {
		statusLabel.setText(str);
	}

	/*
	 * creates <code>ActionListener</code> for various Gui components contained
	 * in the main application window
	 */
	private void setAllEventListeners() {
		topPanel.setSearchEventListener(new SearchEventListener() {

			public void searchEventOccured(SearchEvent e) {
				scrapper.setSearchKeywords(e.getMsg());
				statusLabel.setText("fetching " + scrapper.getSearchKeywords());

				// statusLabel.setText("Google search \"" + e.getMsg() + "\"");

				lyricsPanel.clearText();
				Runnable doRun = new Runnable() {

					public void run() {
						// TODO Auto-generated method stub
						final String link = scrapper.getLink();
						if (link == "") {
							// this means that google search was unsuccessful
							JOptionPane.showMessageDialog(rootPane,
									"Lyrics not found!", "Error",
									JOptionPane.ERROR_MESSAGE);
							statusLabel.setText("Ready");

						} else {
							// System.out.println("fetching " + link);
							statusLabel.setText("fetching " + link);
							SwingUtilities.invokeLater(new Runnable() {

								public void run() {
									// TODO Auto-generated method stub
									URL url;
									try {
										url = new URL(link);
										mlScrapper.parseUrL(url);
										lyricsPanel.clearText();
										lyricsPanel.setText(mlScrapper
												.scrapLyrics());
										lyricsPanel.setCaretPosition(0);
									} catch (MalformedURLException e1) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(rootPane,
												"Lyrics not found!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}
									statusLabel.setText("Ready");

								}

							});
						}

					}
				};

				SwingUtilities.invokeLater(doRun);

			}

		});

		topPanel.setSaveAsEventListener(new SaveAsEventListener() {

			public void saveAsEventOccured(SaveAsEvent e) {
				// code to write file here
				LyricsToFileWriter writer = new LyricsToFileWriter(e.getFile(),
						lyricsPanel.getLyrics());
				writer.writeLyrics();

			}
		});
		topPanel.setCopyEventListener(new CopyEventListener() {

			public void copyEventOccured(CopyEvent ce) {
				// TODO Auto-generated method stub
				if (ce != null) {
					lyricsPanel.copyAllToClipboard();
				}

			}

		});
		topPanel.setClearEventListener(new ClearEventListener() {

			public void clearEventOccured(ClearEvent ce) {
				// TODO Auto-generated method stub
				if (ce != null) {
					lyricsPanel.setText("");
				}

			}

		});

	}
}
