import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	protected static JButton trueButton = new JButton("Yes");
	protected static JButton falseButton = new JButton("No");
	protected static JTextArea textField = new JTextArea("Do you like milk in your tea?");
	protected static JButton resetButton = new JButton("Reset");

	//Grids
	protected static JPanel grid = new JPanel();

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
		grid.setLayout(new FlowLayout(1, 100, 10));
		trueButton.setPreferredSize(new Dimension(200, 100));
		falseButton.setPreferredSize(new Dimension(200, 100));
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
		
		//Adds proper fields to the grid
		grid.add(textField);
		grid.add(trueButton);
		grid.add(falseButton);
		
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