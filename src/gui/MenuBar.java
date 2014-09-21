package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import event.ClearEvent;
import event.ClearEventListener;
import event.CopyEvent;
import event.CopyEventListener;
import event.SaveAsEvent;
import event.SaveAsEventListener;

/**
 * This class extends <code>JMenuBar</code> and holds all JMenuItems necessary
 * for the application
 * 
 * @author RK Sanayaima Singh
 *
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	// JMenu
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu helpMenu = new JMenu("Help");
	// entries for fileMenu
	private JMenuItem exitItem = new JMenuItem("Exit");
	private JMenuItem saveItem = new JMenuItem("Save As...");
	// entries for helpMenu
	private JMenuItem helpItem = new JMenuItem("Help Contents");
	private JMenuItem aboutItem = new JMenuItem("About");
	private JMenuItem licenseItem = new JMenuItem("License");

	// entries for helpMenu
	private JMenuItem copyItem = new JMenuItem("Copy");
	private JMenuItem clearItem = new JMenuItem("Clear");

	private SaveAsEventListener saveAsEventListener;
	private CopyEventListener copyEventListener;
	private ClearEventListener clearEventListener;
	private JFrame parentFrame = null;

	public void setParentFrame(JFrame frame) {
		this.parentFrame = frame;
	}

	/**
	 * <code>Menubar()</code> constructor organizes all the components of
	 * Menubar
	 */
	public MenuBar() {

		setMnemonics();
		addFileMenuItems();
		addEditMenuItems();
		addHelpMenuItems();
		setFileMenuActionListener();
		setEditMenuActionListener();
		setHelpMenuActionListener();
		addMenuItems();

	}

	private void addFileMenuItems() {
		// add fileMenu items
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
	}

	private void addEditMenuItems() {
		// add editMenu items
		editMenu.add(copyItem);
		editMenu.add(clearItem);
	}

	private void addHelpMenuItems() {
		// add helpMenu items
		helpMenu.add(helpItem);
		helpMenu.add(licenseItem);
		helpMenu.add(aboutItem);
	}

	private void addMenuItems() {
		// add menuitems into menubar
		add(fileMenu);
		add(editMenu);
		add(helpMenu);

	}

	private void setMnemonics() {
		fileMenu.setMnemonic('f');
		saveItem.setMnemonic('s');
		exitItem.setMnemonic('x');
		editMenu.setMnemonic('e');
		copyItem.setMnemonic('p');
		helpMenu.setMnemonic('h');
		clearItem.setMnemonic('c');
		aboutItem.setMnemonic('a');
		licenseItem.setMnemonic('l');
		helpItem.setMnemonic('h');

	}

	/**
	 * This method sets the <code>ActionListener</code> for File Menu items
	 * 
	 */
	public void setFileMenuActionListener() {
		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(ABORT);
			}
		});
		saveItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SaveAsEvent ev = new SaveAsEvent(this);
				FileFilter filter = new FileNameExtensionFilter("Text File",
						"txt");
				JFileChooser fileChooser = new JFileChooser();
				// fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileFilter(filter);
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (!fileChooser.getSelectedFile().getAbsolutePath()
							.endsWith(".txt")) {
						ev.setFile(new File(fileChooser.getSelectedFile()
								.getAbsolutePath() + ".txt"));
					} else {
						ev.setFile(fileChooser.getSelectedFile());
					}
					if (ev != null) {
						saveAsEventListener.saveAsEventOccured(ev);
					}
				}

			}

		});
	}

	/**
	 * This method sets the <code>ActionListener</code> for Edit Menu items
	 * 
	 */
	public void setEditMenuActionListener() {
		copyItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CopyEvent ce = new CopyEvent(this);
				copyEventListener.copyEventOccured(ce);

			}
		});

		clearItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClearEvent ce = new ClearEvent(this);
				clearEventListener.clearEventOccured(ce);
			}
		});

	}

	/**
	 * This method sets the <code>ActionListener</code> for Help Menu items
	 * 
	 */
	public void setHelpMenuActionListener() {
		helpItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// write code to display help
				JOptionPane.showMessageDialog(parentFrame,
						"Enter a song name in the text field and hit "
								+ "Go to retrieve lyrics.", "Help",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		licenseItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LicenseDialog ld = new LicenseDialog();
				ld.setLocationRelativeTo(parentFrame);
				ld.setVisible(true);
			}
		});
		aboutItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// write code to display About
				AboutDialog ad = new AboutDialog();
				ad.setLocationRelativeTo(parentFrame);
				ad.setVisible(true);
			}
		});
	}

	/**
	 * set <code>SaveAsEventListener</code>
	 * 
	 * @param listener
	 */
	public void setSaveAsEventListener(SaveAsEventListener listener) {
		this.saveAsEventListener = listener;
	}

	/**
	 * set <code>ClearEventListener</code>
	 * 
	 * @param listener
	 */
	public void setClearEventListener(ClearEventListener listener) {
		this.clearEventListener = listener;
	}

	/**
	 * set <code>CopyEventListener</code>
	 * 
	 * @param listener
	 */
	public void setCopyEventListener(CopyEventListener listener) {
		this.copyEventListener = listener;
	}

}
