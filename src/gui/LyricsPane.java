package gui;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * <code>LyricsPane</code> creates the area on the application window to display
 * the lyrics
 * 
 * @author RK
 *
 */
public class LyricsPane extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private JTextArea lyricsArea = new JTextArea();

	// private CopyEventListener copyListener;

	public LyricsPane(String title) {

		lyricsArea.setBorder(BorderFactory.createTitledBorder(title));
		setViewportView(lyricsArea);
	}

	/**
	 * Set the display text as <code>str</code>
	 * 
	 * @param str
	 */
	public void setText(String str) {
		lyricsArea.setText(str);
	}

	/**
	 * Clear the display text
	 */
	public void clearText() {
		lyricsArea.setText("");
	}

	public String getLyrics() {
		return lyricsArea.getText();
	}

	/**
	 * copies the contents of Lyrics display area to System Clipboard
	 */
	public void copyAllToClipboard() {
		lyricsArea.selectAll();
		lyricsArea.copy();
		lyricsArea.select(0, 0);
	}

	public void setCaretPosition(int i) {
		// TODO Auto-generated method stub
		lyricsArea.setCaretPosition(i);
	}

}
