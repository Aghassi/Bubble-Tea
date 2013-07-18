import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A class to handle the window displayed on screen
 * @author David Aghassi
 *
 */
public class Window
{
	//Windows
	protected static JFrame mainWindow = new JFrame();

	//Buttons and Text
	protected static JButton trueButton = new JButton("Creamy");
	protected static JButton falseButton = new JButton("No Creamy");
	protected static JButton resetButton = new JButton("Reset");
	protected static JButton backButton = new JButton("Back");
	protected static JTextArea textField = new JTextArea("Do you want creamyy or no creamyy in your tea?");
	protected static JLabel choicesSoFar = new JLabel("So far you have chosen:", JLabel.CENTER);
	
	//Grids
	protected static JPanel grid = new JPanel(new GridBagLayout());
	protected static GridBagConstraints constraint = new GridBagConstraints();

	public static void main(String[] args)
	{
		//Sets the window to obey multiple platforms
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		/*
		 * Creates the main window and gives it settings
		 */
		mainWindow.setSize(500, 500);
		mainWindow.setTitle("Bubble Tea Helper");
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(3);
		
		/*
		 * Creates the grid and buttons
		 * Tells them how to be layed out
		 */
		trueButton.setPreferredSize(new Dimension(100, 100));
		falseButton.setPreferredSize(new Dimension(100, 100));
		textField.setEditable(false);

		//Designates the listener for the true button
		trueButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Options.updateUI(Window.trueButton.getText());
					}
				});
		
		//Designates the listener for the false button
		falseButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Options.updateUI(Window.falseButton.getText());
					}
				});
		
		//Designates the listener for the rest button
		resetButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Options.reset();
					}
				});
		
		//Designates the listener for the back button
		backButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Options.back();
				}
			});
		
		//Adds proper fields to the grid
		
		constraint.insets = new Insets(20,0,0,0);
		constraint.gridx = 1;
		constraint.gridy = 3;
		grid.add(choicesSoFar, constraint);
		
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridwidth = 2;
		constraint.gridx = 1;
		constraint.gridy = 0;
		grid.add(textField, constraint);
		
		constraint.anchor = GridBagConstraints.LAST_LINE_START;
		constraint.gridx = 1;
		constraint.gridy = 1;
		grid.add(trueButton, constraint);
		
		constraint.anchor = GridBagConstraints.LAST_LINE_END;
		constraint.gridx = 2;
		constraint.gridy = 1;
		grid.add(falseButton,constraint);
		
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridx = 1;
		constraint.gridy = 2;
		grid.add(backButton, constraint);
		
		/*
		 * Adds the grid to the window
		 * Sets the window to visible
		 */
		JFrame.setDefaultLookAndFeelDecorated(true);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.add(grid);
		mainWindow.setVisible(true);
	}
}