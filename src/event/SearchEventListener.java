package event;

import java.util.EventListener;

/**
 * <code>EventListener</code> for
 * 
 * @author RK
 *
 */
public interface SearchEventListener extends EventListener {
	/**
	 * method to be called when <ode>SearchEvent</code> occurs
	 * 
	 * @param e
	 */
	public void searchEventOccured(SearchEvent e);
}
