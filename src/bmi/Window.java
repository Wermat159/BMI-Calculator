package bmi;

import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{

	/*
	 * Size is 800 x 500 pixels
	 * Program will open in the middle of the screen
	 * 
	 */
	
	
	Window(){
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("BMI CALCULATOR");
		setLayout(new GridLayout(3, 1));
		setResizable(false);
	}
	
	
}
