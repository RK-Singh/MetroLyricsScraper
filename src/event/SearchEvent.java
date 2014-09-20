package event;

import java.util.EventObject;

/**
 * Event when user clicks go button
 * 
 * @author RK Sanayaima Singh
 *
 */

public class SearchEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private String msg;

	public SearchEvent(Object source, String searchText) {
		super(source);
		this.setMsg(searchText);
	}

	/**
	 * get the message passed
	 * 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * set the message to be passed
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
