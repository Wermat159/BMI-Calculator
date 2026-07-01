package bmi;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.math3.util.Precision;

import javax.swing.*;

@SuppressWarnings("serial")
public class BMICalculator extends Window implements ActionListener {

	JLabel lblWeight = new JLabel("Weight (in KG): ");
	JLabel lblheight = new JLabel("Height (in CM): ");
	JTextField txtWeight = new JTextField();
	JTextField txtHeight = new JTextField();
	JButton btnCalculate = new JButton("CALCULATE BMI");
	JPanel pnlWeight = new JPanel(new GridLayout(1, 2));
	JPanel pnlHeight = new JPanel(new GridLayout(1, 2));

	public BMICalculator() {
		
		//Add all neccessary components 
		pnlWeight.add(lblWeight);
		pnlWeight.add(txtWeight);
		pnlHeight.add(lblheight);
		pnlHeight.add(txtHeight);
		add(pnlWeight);
		add(pnlHeight);
		add(btnCalculate);
		btnCalculate.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BMICalculator();
	}

	// check all conditions so we get no errors
	private static boolean checker(JTextField Weight, JTextField Height) {
		try {
			String weightText = Weight.getText().trim();
			String heightText = Height.getText().trim();

			if (weightText.isEmpty() || heightText.isEmpty()) {
				return false;
			}

			double weight = Double.parseDouble(weightText);
			double height = Double.parseDouble(heightText);

			if (weight < 0 || weight > 999 || height <= 0 || height > 250) {
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// calculates BMI if there are all necessary requirements are met
	// show table for BMI defaults
	private static void calculateBMI(JTextField Weight, JTextField Height) {
		if (checker(Weight, Height) == true) {
			double weight = Double.parseDouble(Weight.getText());
			double height = Double.parseDouble(Height.getText()) / 100;
			double bmi = weight / Math.pow(height, 2);
			bmi = Precision.round(bmi, 2);
			JOptionPane.showMessageDialog(null, "Your BMI is: " + bmi);
			new Table(bmi);
		} else {
			JOptionPane.showMessageDialog(null, "Weight must be between 0-999\nHeight must be between 0-250");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * After calculating BMI 
		 * or giving an error resets the text
		 * 
		 * 
		 */
		
		if (e.getSource() == btnCalculate) {
			calculateBMI(txtWeight, txtHeight);
			txtWeight.setText("");
			txtHeight.setText("");
		}

	}
}
