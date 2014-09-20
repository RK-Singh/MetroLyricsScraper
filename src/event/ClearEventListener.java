package event;

import java.util.EventListener;

/**
 * Event Listener for <code>ClearEvent</code>
 * 
 * @author RK Sanayaima Singh
 *
 */
public interface ClearEventListener extends EventListener {
	/**
	 * method to be called when <code>ClearEvent</code> occurs
	 * 
	 * @param ce
	 */
	public void clearEventOccured(ClearEvent ce);
}
