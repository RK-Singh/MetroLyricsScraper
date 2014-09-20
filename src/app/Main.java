package app;

import gui.ApplicationFrame;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Creates the application as an instance of <code>ApplicationFrame</code>
 * 
 * @author RK Sanayaima Singh
 *
 */
public class Main {
	public static void main(String[] args) {
		// set system LaF
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Runnable runnable = new Runnable() {

			public void run() {
				new ApplicationFrame("Metro Lyrics Scraper");

			}
		};
		EventQueue.invokeLater(runnable);
	}
}
