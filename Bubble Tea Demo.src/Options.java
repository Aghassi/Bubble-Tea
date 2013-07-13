/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Hashtable;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class Options extends Window
/*     */ {
/*  18 */   private static String[] mainOptions = { "Earthy", "Fruity", "Tangy" };
/*  19 */   private static String[] secondaryOptions = { "Less Sweet", "More Sweet" };
/*     */ 
/*  24 */   private static String[] _11 = { "1. Kumquat-Lemon \n", 
/*  25 */     "2. Green Apple \n", 
/*  26 */     "3. Kiwi \n", 
/*  27 */     "4. Grapefruite \n", 
/*  28 */     "5. Lemon \n" };
/*     */ 
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
/*     */ 
/*  41 */   private static String[] _100 = { "1. Peach \n", 
/*  42 */     "2. Honey \n", 
/*  43 */     "3. Peppermint \n", 
/*  44 */     "4. Honeydew \n" };
/*     */ 
/*  46 */   private static String[] _011 = _101;
/*  47 */   private static String[] _010 = _100;
/*  48 */   private static String[] _001 = { "1. Boba \n", 
/*  49 */     "2. Almond \n", 
/*  50 */     "3. Coconut \n", 
/*  51 */     "4. Coffee \n", 
/*  52 */     "5. Red Bean \n", 
/*  53 */     "6. Green milk \n", 
/*  54 */     "7. Mocha" };
/*     */ 
/*  56 */   private static String[] _000 = { "1. Thai \n", 
/*  57 */     "2. Taro \n", 
/*  58 */     "3. Vanilla \n", 
/*  59 */     "4. Chocolate \n", 
/*  60 */     "5. Vanilla Latte \n", 
/*  61 */     "6. Chai \n", 
/*  62 */     "7. Sesame" };
/*     */ 
/*  65 */   private static Hashtable<String, Object[]> lookUp = new Hashtable(7);
/*  66 */   private static ArrayList<BubbleNode> answers = new ArrayList(9);
/*  67 */   private static int answerCount = 0;
/*     */ 
/*     */   public static void updateUI(String answer)
/*     */   {
/*     */     BubbleNode nodeCurrent;
/*     */     BubbleNode nodeCurrent;
/*  79 */     if (answer.contains(trueButton.getText())) {
/*  80 */       nodeCurrent = new BubbleNode(answer, 0);
/*     */     }
/*     */     else {
/*  83 */       nodeCurrent = new BubbleNode(answer, 1);
/*     */     }
/*  85 */     answers.add(answerCount, nodeCurrent);
/*     */ 
/*  89 */     if (answer.contains("YES")) {
/*  90 */       trueButton.setText(mainOptions[0]);
/*  91 */       falseButton.setText(mainOptions[1]);
/*  92 */       textField.setText("Do you like " + mainOptions[0] + " or " + mainOptions[1] + "?");
/*     */     }
/*  94 */     else if (answer.contains("NO")) {
/*  95 */       trueButton.setText(mainOptions[1]);
/*  96 */       falseButton.setText(mainOptions[2]);
/*  97 */       textField.setText("Do you like " + mainOptions[1] + " or " + mainOptions[2] + "?");
/*     */     }
/* 100 */     else if (answer.contains(mainOptions[2]))
/*     */     {
/* 102 */       grid.remove(trueButton);
/* 103 */       grid.remove(falseButton);
/* 104 */       grid.remove(textField);
/* 105 */       displayAnswer();
/*     */     }
/* 109 */     else if ((answer.contains(secondaryOptions[0])) || (answer.contains(secondaryOptions[1]))) {
/* 110 */       grid.remove(trueButton);
/* 111 */       grid.remove(falseButton);
/* 112 */       grid.remove(textField);
/* 113 */       displayAnswer();
/*     */     }
/*     */     else {
/* 116 */       trueButton.setText(secondaryOptions[0]);
/* 117 */       falseButton.setText(secondaryOptions[1]);
/* 118 */       textField.setText("Do you like " + 
/* 119 */         secondaryOptions[0] + " or " + 
/* 120 */         secondaryOptions[1] + "?");
/*     */     }
/*     */ 
/* 124 */     answerCount += 1;
/*     */   }
/*     */ 
/*     */   private static void displayAnswer()
/*     */   {
/* 132 */     populateHash();
/*     */ 
/* 135 */     String userAnswerList = "";
/* 136 */     StringBuilder builder = new StringBuilder();
/* 137 */     for (int index = 0; index < answers.size(); index++) {
/* 138 */       if (index == answers.size() - 1) {
/* 139 */         builder.append("and " + ((BubbleNode)answers.get(index)).getElement() + ".");
/*     */       }
/*     */       else {
/* 142 */         builder.append(((BubbleNode)answers.get(index)).getElement() + ", ");
/*     */       }
/*     */     }
/* 145 */     userAnswerList = builder.toString();
/* 146 */     builder = new StringBuilder();
/*     */ 
/* 149 */     String treePathNumber = "";
/* 150 */     for (int index = 0; index < answers.size(); index++) {
/* 151 */       builder.append(((BubbleNode)answers.get(index)).getPlace());
/*     */     }
/* 153 */     treePathNumber = builder.toString();
/*     */ 
/* 156 */     String returnOptions = null;
/* 157 */     if (lookUp.containsKey(treePathNumber)) {
/* 158 */       returnOptions = Arrays.toString((Object[])lookUp.get(treePathNumber));
/*     */     }
/*     */ 
/* 163 */     JTextArea answerField = new JTextArea("Since you chose: \n" + userAnswerList.toString() + "\n \n You would probably like: \n" + returnOptions);
/* 164 */     answerField.setEditable(false);
/* 165 */     grid.add(answerField);
/* 166 */     grid.add(resetButton);
/* 167 */     mainWindow.validate();
/* 168 */     mainWindow.repaint();
/*     */   }
/*     */ 
/*     */   private static void populateHash()
/*     */   {
/* 173 */     lookUp.put("11", _11);
/* 174 */     lookUp.put("101", _101);
/* 175 */     lookUp.put("100", _100);
/* 176 */     lookUp.put("011", _011);
/* 177 */     lookUp.put("010", _010);
/* 178 */     lookUp.put("001", _001);
/* 179 */     lookUp.put("000", _000);
/*     */   }
/*     */ 
/*     */   protected static void reset() {
/* 183 */     trueButton.setText("YES");
/* 184 */     falseButton.setText("NO");
/* 185 */     textField.setText("Do you like milk in your tea?");
/*     */ 
/* 187 */     grid.removeAll();
/* 188 */     grid.add(textField);
/* 189 */     grid.add(trueButton);
/* 190 */     grid.add(falseButton);
/* 191 */     mainWindow.validate();
/* 192 */     mainWindow.repaint();
/*     */ 
/* 194 */     answerCount = 0;
/* 195 */     answers = new ArrayList(9);
/*     */   }
/*     */ }

/* Location:           /Volumes/Applications/Dropbox/Personal/Coding/Java/Bubble Tea Demo.jar
 * Qualified Name:     Options
 * JD-Core Version:    0.6.2
 */