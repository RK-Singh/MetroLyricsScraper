package event;

import java.util.EventObject;

/**
 * Event when user clicks clear menu
 * 
 * @author RK Sanayaima Singh
 *
 */
public class ClearEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public ClearEvent(Object source) {
		super(source);
	}

}
