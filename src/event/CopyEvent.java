package event;

import java.util.EventObject;

/**
 * Event when user clicks copy menu
 * 
 * @author RK Sanayaima Singh
 *
 */
public class CopyEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public CopyEvent(Object source) {
		super(source);
	}

}
