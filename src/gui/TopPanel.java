package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import event.ClearEventListener;
import event.CopyEventListener;
import event.SaveAsEventListener;
import event.SearchEvent;
import event.SearchEventListener;

/**
 * This class binds the <code>MenuBar</code> along with a
 * <code>JTextField</code> and a <code>JButton</code> and provides search
 * functionality. An instance of this class would act as the top panel for the
 * application
 * 
 * @author RK Sanayaima Singh
 *
 */
public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private MenuBar menuBar = new MenuBar();
	private JTextField searchField = new JTextField("Enter Text to Search");
	private JButton goButton = new JButton("Go!");
	private SearchEventListener searchEventListener;

	/*
	 * Create action listener for Search button
	 */
	private void createGoBtnActionListener() {
		goButton.setMnemonic('g');
		goButton.setFocusPainted(true);
		goButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// write code here to handle user input text
				SearchEvent ev = new SearchEvent(this, searchField.getText());

				if (searchEventListener != null) {
					searchEventListener.searchEventOccured(ev);
				}
			}
		});
	}

	private void addTextFieldFocusListener() {
		searchField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				searchField.selectAll();

			}

			public void focusLost(FocusEvent e) {
				searchField.select(0, 0);

			}

		});
	}

	/**
	 * Constructs and initializes all components of <code>TopPanel</code>
	 */
	public TopPanel() {
		super(new BorderLayout());
		createGoBtnActionListener();
		addTextFieldFocusListener();
		add(menuBar, BorderLayout.NORTH);
		createAndAddBorder();
	}

	private void createAndAddBorder() {
		JPanel innerPanel = new JPanel(new BorderLayout());
		innerPanel.add(searchField, BorderLayout.CENTER);
		innerPanel.add(goButton, BorderLayout.EAST);
		innerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		add(innerPanel, BorderLayout.CENTER);

	}

	/**
	 * Method to set <code>ActionListener</code>
	 * 
	 * @param listener
	 * @see <code>SearchEventListener</code> <code>SearchEvent</code>
	 */
	public void setSearchEventListener(SearchEventListener listener) {
		this.searchEventListener = listener;
	}

	public void setSaveAsEventListener(SaveAsEventListener listener) {
		this.menuBar.setSaveAsEventListener(listener);
	}

	public void setCopyEventListener(CopyEventListener listener) {
		this.menuBar.setCopyEventListener(listener);

	}

	public void setClearEventListener(ClearEventListener clearEventListener) {
		this.menuBar.setClearEventListener(clearEventListener);
	}

	public JButton getGoButton() {
		// TODO Auto-generated method stub
		return this.goButton;
	}

	public void setParentFrame(JFrame frame) {
		// TODO Auto-generated method stub
		this.menuBar.setParentFrame(frame);
	}

}
