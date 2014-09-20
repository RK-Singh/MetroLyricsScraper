package event;

import java.io.File;
import java.util.EventObject;

/**
 * Event for save as menu item
 * 
 * @author RK Sanayaima Singh
 *
 */
public class SaveAsEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private File file;

	public SaveAsEvent(Object source) {
		super(source);
	}

	/**
	 * return the file to be saved
	 * 
	 * @return
	 */
	public File getFile() {
		return file;
	}

	/**
	 * set the file to be saved
	 * 
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

}
