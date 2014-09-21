package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * About menu display window class
 * 
 * @author RK
 *
 */
public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final String projectTitle = "Metro Lyrics Scraper";
	private final String version = "v 1.0";
	// private final String buildDate = "Sat, Sept 20, 2014";
	private final String authorName = "RK Sanayaima Singh";
	private final String authorEmail = "sanayaima10@yahoo.in";
	private final String description = "This application look up google for "
			+ "user input text and corresponding metrolyrics.com link address "
			+ "is extracted and scrapped for lyrics.";
	// private final String projectHome = "";

	private JButton okBtn = new JButton("OK");

	// private String authorLabel;

	private void addOkbtnActionListener() {

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void createAndLoadComponents() {

		addOkbtnActionListener();
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("About");
		addNorthComponents();
		addSouthComponents();
		addCenterComponents();
		setSize(300, 200);
	}

	private void addCenterComponents() {

		String text = "<html><table>"
				+ "<tr><th align=\"right\">Author:</th><th align=\"left\">"
				+ authorName
				+ "</th> </tr>"
				+ "<tr><td align=\"right\">Email:</td><td><a href=\"mailto:sanayaima10@yahoo.in\">"
				+ authorEmail
				+ "</td></tr><tr><td colspan=\"2\" align=\"center\">"
				+ description + "</td></tr> </table>";
		add(new JLabel(text, SwingConstants.CENTER), BorderLayout.CENTER);
	}

	private void addSouthComponents() {
		// TODO Auto-generated method stub
		JPanel bp = new JPanel(new BorderLayout());
		bp.add(new JLabel("© 2014, " + authorName), BorderLayout.CENTER);
		bp.add(okBtn, BorderLayout.EAST);
		add(bp, BorderLayout.SOUTH);

	}

	private void addNorthComponents() {
		// TODO Auto-generated method stub
		add(new JLabel("<html><u><b>" + projectTitle + " " + version
				+ "</u></b>", SwingConstants.CENTER), BorderLayout.NORTH);

	}

	public AboutDialog() {

		createAndLoadComponents();

	}

}
