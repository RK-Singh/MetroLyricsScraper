package event;

import java.util.EventListener;

/**
 * Event Listener for <code>CopyEvent</code>
 * 
 * @author RK Sanayaima Singh
 *
 */
public interface CopyEventListener extends EventListener {
	/**
	 * method to be called when <code>CopyEvent</code> occurs
	 * 
	 * @param ce
	 */
	public void copyEventOccured(CopyEvent ce);

}
