/*    */ import java.awt.Dimension;
/*    */ import java.awt.FlowLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class Window
/*    */ {
/* 14 */   protected static JFrame mainWindow = new JFrame();
/*    */ 
/* 17 */   protected static JButton trueButton = new JButton("YES");
/* 18 */   protected static JButton falseButton = new JButton("NO");
/* 19 */   protected static JTextArea textField = new JTextArea("Do you like milk in your tea?");
/* 20 */   protected static JButton resetButton = new JButton("Reset");
/*    */ 
/* 23 */   protected static JPanel grid = new JPanel();
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 27 */     JFrame.setDefaultLookAndFeelDecorated(true);
/*    */ 
/* 29 */     mainWindow.setSize(500, 500);
/* 30 */     mainWindow.setTitle("Bubble Tea Helper");
/*    */ 
/* 33 */     grid.setLayout(new FlowLayout(1, 100, 10));
/* 34 */     trueButton.setPreferredSize(new Dimension(200, 100));
/* 35 */     falseButton.setPreferredSize(new Dimension(200, 100));
/* 36 */     textField.setEditable(false);
/*    */ 
/* 39 */     trueButton.addActionListener(
/* 40 */       new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 42 */         Options.updateUI(Window.trueButton.getText());
/*    */       }
/*    */     });
/* 46 */     falseButton.addActionListener(
/* 47 */       new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 49 */         Options.updateUI(Window.falseButton.getText());
/*    */       }
/*    */     });
/* 52 */     resetButton.addActionListener(
/* 53 */       new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 55 */         Options.reset();
/*    */       }
/*    */     });
/* 59 */     grid.add(textField);
/* 60 */     grid.add(trueButton);
/* 61 */     grid.add(falseButton);
/*    */ 
/* 64 */     JFrame.setDefaultLookAndFeelDecorated(true);
/* 65 */     mainWindow.setLocationRelativeTo(null);
/* 66 */     mainWindow.setResizable(false);
/* 67 */     mainWindow.add(grid);
/* 68 */     mainWindow.setDefaultCloseOperation(3);
/* 69 */     mainWindow.setVisible(true);
/*    */   }
/*    */ }

/* Location:           /Volumes/Applications/Dropbox/Personal/Coding/Java/Bubble Tea Demo.jar
 * Qualified Name:     Window
 * JD-Core Version:    0.6.2
 */