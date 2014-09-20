package event;

import java.util.EventListener;

/**
 * Event Listener for <code>SaveAsEvent</code>
 * 
 * @author RK Sanayaima Singh
 *
 */
public interface SaveAsEventListener extends EventListener {
	/**
	 * method called when <code>SaveAsEvent</code> occurs
	 * 
	 * @param e
	 */
	public void saveAsEventOccured(SaveAsEvent e);
}
