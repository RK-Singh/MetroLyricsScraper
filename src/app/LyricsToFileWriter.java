package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * This Class writes lyrics to file on disk
 * 
 * @author RK Sanayaima Singh
 *
 */
public class LyricsToFileWriter {
	File destFile = null;
	String data = null;

	/**
	 * Constructor, pass destination <code>file</code> and
	 * <code>content<code> to write
	 * 
	 * @param file
	 * @param content
	 */
	public LyricsToFileWriter(File file, String content) {
		this.destFile = file;
		this.data = content;
	}

	/**
	 * method to write content to file
	 */
	public void writeLyrics() {
		int status = JOptionPane.YES_OPTION;
		if (destFile.exists()) {
			status = JOptionPane.showConfirmDialog(null,
					"File already exists!\nDo You want to overwrite?");
		} else {
			try {
				destFile.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		if (status == JOptionPane.YES_OPTION) {
			if (destFile.canWrite()) {

			} else {
				JOptionPane.showMessageDialog(null, "Could not write to File!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			// write contents to file
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(destFile);
				fos.write(data.getBytes());
				fos.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
