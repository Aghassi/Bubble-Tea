import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.JTextArea;

public class Options extends Window
{
	/*  18 */   private static String[] mainOptions = { "Yes", "No", "Earthy", "Fruity", "Tangy", "Less Sweet", "More Sweet" };
	/*  19 */   private static String[] secondaryOptions = { "Less Sweet", "More Sweet" };

	/*  24 */   private static String[] _11 = { "1. Kumquat-Lemon \n", 
		/*  25 */     "2. Green Apple \n", 
		/*  26 */     "3. Kiwi \n", 
		/*  27 */     "4. Grapefruite \n", 
	/*  28 */     "5. Lemon \n" };

	/*  29 */   private static String[] _101 = { "1.Mango \n", 
		/*  30 */     "2. Strawberry \n", 
		/*  31 */     "3. Blackberry \n", 
		/*  32 */     "4. Rasberry \n", 
		/*  33 */     "5. Grape \n", 
		/*  34 */     "6. PassionFruit \n", 
		/*  35 */     "7. Lychee \n", 
		/*  36 */     "8. Peach (white) \n", 
		/*  37 */     "9. Rose \n", 
		/*  38 */     "10. Rose-Lychee \n", 
	/*  39 */     "11. Pinapple \n" };

	/*  41 */   private static String[] _100 = { "1. Peach \n", 
		/*  42 */     "2. Honey \n", 
		/*  43 */     "3. Peppermint \n", 
	/*  44 */     "4. Honeydew \n" };

	/*  46 */   private static String[] _011 = _101;
	/*  47 */   private static String[] _010 = _100;
	/*  48 */   private static String[] _001 = { "1. Boba \n", 
		/*  49 */     "2. Almond \n", 
		/*  50 */     "3. Coconut \n", 
		/*  51 */     "4. Coffee \n", 
		/*  52 */     "5. Red Bean \n", 
		/*  53 */     "6. Green milk \n", 
	/*  54 */     "7. Mocha" };

	/*  56 */   private static String[] _000 = { "1. Thai \n", 
		/*  57 */     "2. Taro \n", 
		/*  58 */     "3. Vanilla \n", 
		/*  59 */     "4. Chocolate \n", 
		/*  60 */     "5. Vanilla Latte \n", 
		/*  61 */     "6. Chai \n", 
	/*  62 */     "7. Sesame" };

	/*  65 */   private static Hashtable<String, Object[]> lookUp = new Hashtable<String, Object[]>(7);
	/*  66 */   private static ArrayList<BubbleNode> answers = new ArrayList<BubbleNode>(9);
	/*  67 */   private static int answerCount = 0;
	/*	   */	private static int childrenCount = 1;

	public static void updateUI(String answer)
	{
		addAnswer(answer);
		
		if (Arrays.asList(mainOptions).contains(answer)) {
			if (answer.contains(mainOptions[5]))
			{
				grid.remove(trueButton);
				grid.remove(falseButton);
				grid.remove(textField);
				displayAnswer();
			}
			else
			{
				if(answer.contains(mainOptions[1])){
					childrenCount = 2;
				}
				childrenCount = childrenCount*2;
				trueButton.setText(mainOptions[childrenCount]);
				falseButton.setText(mainOptions[childrenCount + 1]);
				textField.setText("Do you like " + mainOptions[childrenCount] + " or " + mainOptions[childrenCount+1] + "?");
				if(childrenCount > mainOptions.length){
					displayAnswer();
				}
				if(answer.contains(falseButton.getText())){
					childrenCount = childrenCount + 1;
				}

			}
		}

	}
	
	/**
	 * @param add Adds the given answer to the answer list
	 */
	private static void addAnswer(String add){
		BubbleNode nodeCurrent;
		if (add.contains(trueButton.getText())) {
			nodeCurrent = new BubbleNode(add, 0);
		}
		else {
			nodeCurrent = new BubbleNode(add, 1);
		}
		answers.add(answerCount, nodeCurrent);
		answerCount++;

	}


	private static void displayAnswer()
	{
		/* 132 */     populateHash();

		/* 135 */     String userAnswerList = "";
		/* 136 */     StringBuilder builder = new StringBuilder();
		/* 137 */     for (int index = 0; index < answers.size(); index++) {
			/* 138 */       if (index == answers.size() - 1) {
				/* 139 */         builder.append("and " + ((BubbleNode)answers.get(index)).getElement() + ".");
			}
			else {
				/* 142 */         builder.append(((BubbleNode)answers.get(index)).getElement() + ", ");
			}
		}
		/* 145 */     userAnswerList = builder.toString();
		/* 146 */     builder = new StringBuilder();

		/* 149 */     String treePathNumber = "";
		/* 150 */     for (int index = 0; index < answers.size(); index++) {
			/* 151 */       builder.append(((BubbleNode)answers.get(index)).getPlace());
		}
		/* 153 */     treePathNumber = builder.toString();

		/* 156 */     String returnOptions = null;
		/* 157 */     if (lookUp.containsKey(treePathNumber)) {
			/* 158 */       returnOptions = Arrays.toString((Object[])lookUp.get(treePathNumber));
		}

		/* 163 */     JTextArea answerField = new JTextArea("Since you chose: \n" + userAnswerList.toString() + "\n \n You would probably like: \n" + returnOptions);
		/* 164 */     answerField.setEditable(false);
		/* 165 */     grid.add(answerField);
		/* 166 */     grid.add(resetButton);
		/* 167 */     mainWindow.validate();
		/* 168 */     mainWindow.repaint();
	}

	private static void populateHash()
	{
		/* 173 */     lookUp.put("11", _11);
		/* 174 */     lookUp.put("101", _101);
		/* 175 */     lookUp.put("100", _100);
		/* 176 */     lookUp.put("011", _011);
		/* 177 */     lookUp.put("010", _010);
		/* 178 */     lookUp.put("001", _001);
		/* 179 */     lookUp.put("000", _000);
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
}

/* Location:           /Volumes/Applications/Dropbox/Personal/Coding/Java/Bubble Tea Demo.jar
 * Qualified Name:     Options
 * JD-Core Version:    0.6.2
 */