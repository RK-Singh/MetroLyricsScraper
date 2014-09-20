package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class for License Display window
 * 
 * @author RK
 *
 */
public class LicenseDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final String projectTitle = "Metro Lyrics Scraper";
	private String license;

	private JButton okBtn = new JButton("OK");

	// private String authorLabel;
	private void setLicense() {
		this.license = "The MIT License (MIT)\n\n"
				+

				"Copyright (c) 2014 RK Sanayaima Singh <sanayaima10@yahoo.in>\n\n"
				+

				"Permission is hereby granted, free of charge, to any person obtaining a copy\n"
				+ "of this software and associated documentation files (the \"Software\"), to deal\n"
				+ "in the Software without restriction, including without limitation the rights\n"
				+ "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
				+ "copies of the Software, and to permit persons to whom the Software is\n"
				+ "furnished to do so, subject to the following conditions:\n\n"
				+

				"The above copyright notice and this permission notice shall be included in\n"
				+ "all copies or substantial portions of the Software.\n\n"
				+

				"THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
				+ "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
				+ "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
				+ "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
				+ "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
				+ "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n"
				+ "THE SOFTWARE.\n";
	}

	private void addOkbtnActionListener() {

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void createAndLoadComponents() {

		addOkbtnActionListener();
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("License");
		addNorthComponents();
		addSouthComponents();
		addCenterComponents();
		setSize(600, 400);
	}

	private void addCenterComponents() {
		LyricsPane p = new LyricsPane("The MIT License");
		p.setText(license);
		p.setCaretPosition(0);
		add(p, BorderLayout.CENTER);

	}

	private void addSouthComponents() {
		// TODO Auto-generated method stub
		JPanel bp = new JPanel(new BorderLayout());
		bp.add(new JLabel(projectTitle), BorderLayout.CENTER);
		bp.add(okBtn, BorderLayout.EAST);
		add(bp, BorderLayout.SOUTH);

	}

	private void addNorthComponents() {
		// TODO Auto-generated method stub
		add(new JLabel("", SwingConstants.CENTER), BorderLayout.NORTH);

	}

	public LicenseDialog() {
		setLicense();
		createAndLoadComponents();

	}

}
