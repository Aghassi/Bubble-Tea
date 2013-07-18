import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.JTextArea;

/**
 * A class to deal with the events of the window
 * @author David Aghassi
 *
 */
public class Options extends Window
{
	private static String[] mainOptions = {"Start",
		"Creamy", "No Creamy",
		"Earthy", "Fruity",
		"Fruity", "Tangy",
		"Less Sweet", "More Sweet",
		"Less Sweet", "More Sweet",
		"Less Sweet", "More Sweet"};

	private static String[] _11 = { "1. Kumquat-Lemon \n", 	//Tangy
		"2. Green Apple \n", 
		"3. Kiwi \n", 
		"4. Grapefruite \n", 
	"5. Lemon \n" };

	private static String[] _101 = { "1.Mango \n", 	//Fruity More Sweet Milk
		"2. Strawberry \n", 
		"3. Blackberry \n", 
		"4. Rasberry \n", 
		"5. Grape \n", 
		"6. PassionFruit \n", 
		"7. Lychee \n", 
		"8. Peach (white) \n", 
		"9. Rose \n", 
		"10. Rose-Lychee \n", 
	"11. Pinapple \n" };

	private static String[] _100 = { "1. Peach \n", 	//Fruity Less Sweet Milk
		"2. Honey \n", 
		"3. Peppermint \n", 
	"4. Honeydew \n" };

	private static String[] _011 = _101;	//Fruity More Sweet No Milk
	private static String[] _010 = _100;	//Fruity Less Sweet No Milk
	private static String[] _001 = { "1. Boba \n", 		//Earthy Less Sweet
		"2. Almond \n", 
		"3. Coconut \n", 
		"4. Coffee \n", 
		"5. Red Bean \n", 
		"6. Green milk \n", 
	"7. Mocha" };

	private static String[] _000 = { "1. Thai \n", 	//Earthy More Sweet
		"2. Taro \n", 
		"3. Vanilla \n", 
		"4. Chocolate \n", 
		"5. Vanilla Latte \n", 
		"6. Chai \n", 
	"7. Sesame" };

	private static Hashtable<String, Object[]> lookUp = new Hashtable<String, Object[]>(7);
	private static ArrayList<BubbleNode> answers = new ArrayList<BubbleNode>(9);
	private static int answerCount = 0;
	private static int childrenCount = 1;

	/**
	 * @param answer The option chosen by the button pressed
	 * Updates the UI to match the answer chosen.
	 * Keeps track of the children count
	 */
	public static void updateUI(String answer)
	{
		/*
		 * Add the answer the list of answers
		 */
		addAnswer(answer);

		/*
		 * Updates the count if No is the starting choice
		 */
		if(answer.contains(mainOptions[2])){
			childrenCount = 2;
		}
		childrenCount = childrenCount*2 + 1;

		/*
		 * If Less Sweet or More Sweet, show answers
		 */
		if(answer.contains(mainOptions[7]) || answer.contains(mainOptions[8])){
			grid.remove(trueButton);
			grid.remove(falseButton);
			grid.remove(textField);
			grid.remove(backButton);
			displayAnswer();
		}

		else if(Arrays.asList(mainOptions).contains(answer)) {
			/*
			 * If Tangy, show answers
			 */
			if (answer.contains(mainOptions[6]))
			{
				grid.remove(trueButton);
				grid.remove(falseButton);
				grid.remove(textField);
				grid.remove(backButton);
				displayAnswer();
			}
			/*
			 * Update the UI to show the proper buttons
			 */
			else
			{
				System.out.println(childrenCount);
				trueButton.setText(mainOptions[childrenCount]);
				falseButton.setText(mainOptions[childrenCount+1]);
				textField.setText("Do you like " + mainOptions[childrenCount] + " or " + mainOptions[childrenCount+1] + "?");
			}
		}

	}

	/**
	 * @param add Adds the given answer to the answer list
	 */
	private static void addAnswer(String add){
		/*
		 * Create new node
		 */
		BubbleNode nodeCurrent;

		/*
		 * Populate the node with the answer
		 * Then add it to the array of choices made
		 */
		if (add.contains(trueButton.getText())) {
			nodeCurrent = new BubbleNode(add, 0);
		}
		else {
			nodeCurrent = new BubbleNode(add, 1);
		}
		answers.add(answerCount, nodeCurrent);
		answerCount++;
		choicesSoFar.setText(choicesSoFar.getText() + " " + add);

	}
	
	/**
	 * @param removes the previous answer given from the answer list
	 */
	private static void removeAnswer(){
		answers.remove(answerCount);
		answerCount--;
	}

	/**
	 * A method to organize the information to be displayed
	 * on screen once the final choice is made
	 */
	private static void displayAnswer()
	{
		/*
		 * Creates the hashtable
		 */
		populateHash();

		/*
		 * Creates a string of the answers given
		 */
		String userAnswerList = "";
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < answers.size(); index++) {
			if (index == answers.size() - 1) 
			{
				builder.append("and " + ((BubbleNode)answers.get(index)).getElement() + ".");
			}
			else 
			{
				builder.append(((BubbleNode)answers.get(index)).getElement() + ", ");
			}
		}
		userAnswerList = builder.toString();

		/*
		 * Creates a new builder and creates
		 * a string of numbers to look up the options in the
		 * hashtable based on the user's choices
		 */
		String treePathNumber = "";
		builder = new StringBuilder();
		for (int index = 0; index < answers.size(); index++) {
			builder.append(((BubbleNode)answers.get(index)).getPlace());
		}
		treePathNumber = builder.toString();

		/*
		 * Looks up the options based on the prior string
		 * made
		 */
		String returnOptions = null;
		if (lookUp.containsKey(treePathNumber)) {
			returnOptions = Arrays.toString((Object[])lookUp.get(treePathNumber));
		}

		/*
		 * Updates the UI
		 */
		JTextArea answerField = new JTextArea("Since you chose: \n" + userAnswerList.toString() + "\n \n You would probably like: \n" + returnOptions);
		answerField.setEditable(false);
		
		constraint.gridx = 0;
		constraint.gridy = 0;
		grid.add(answerField,constraint);
		
		constraint.anchor = GridBagConstraints.PAGE_END;
		constraint.gridx = 0;
		constraint.gridy = 1;
		grid.add(resetButton, constraint);
		
		mainWindow.validate();
		mainWindow.repaint();
	}

	/**
	 * Populates the hashtable for use
	 */
	private static void populateHash()
	{
		lookUp.put("11", _11);
		lookUp.put("101", _101);
		lookUp.put("100", _100);
		lookUp.put("011", _011);
		lookUp.put("010", _010);
		lookUp.put("001", _001);
		lookUp.put("000", _000);
	}

	/**
	 * Resets the window
	 */
	protected static void reset() {
		trueButton.setText("Yes");
		falseButton.setText("No");
		textField.setText("Do you like milk in your tea?");

		grid.removeAll();
		grid.add(textField);
		grid.add(trueButton);
		grid.add(falseButton);
		mainWindow.validate();
		mainWindow.repaint();

		answerCount = 0;
		childrenCount = 1;
		answers = new ArrayList<BubbleNode>(9);
	}

	/**
	 * Reverts the items on screen to what they were
	 * before the last option was chosen.
	 * Updates lists by removing previous answer
	 * Shrinks counting numbers accordingly 
	 */
	public static void back() {
		removeAnswer();
		
		
	}
}
