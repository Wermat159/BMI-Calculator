package bmi;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Table extends JFrame {

	/*
	 * Size is 500 x 500 pixels
	 * Program opens in the middle of the screen
	 * After BMI is calculated display table of BMI intervals
	 * 
	 */
	
	
	private ImageIcon table = new ImageIcon(getClass().getResource("/BMI-Chart-1.png"));
	JLabel photoTable = new JLabel(table);
	JLabel displayBmi = new JLabel();

	public Table(double bmi) {
		setSize(500, 500);
		setTitle("BMI Table");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		add(displayBmi, BorderLayout.NORTH);
		add(photoTable);
		displayBmi.setText("BMI: " + bmi);
		setVisible(true);
	}

}
