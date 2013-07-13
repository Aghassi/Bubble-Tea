/*    */ public class BubbleNode
/*    */ {
/*    */   private String answer;
/*  5 */   private int place = 0;
/*    */ 
/*    */   public BubbleNode(String answer, int number)
/*    */   {
/* 13 */     this.answer = answer;
/* 14 */     setPlace(number);
/*    */   }
/*    */ 
/*    */   public String getElement()
/*    */   {
/* 22 */     return this.answer;
/*    */   }
/*    */ 
/*    */   public int getPlace()
/*    */   {
/* 30 */     return this.place;
/*    */   }
/*    */ 
/*    */   public void setPlace(int place)
/*    */   {
/* 37 */     this.place = place;
/*    */   }
/*    */ }

/* Location:           /Volumes/Applications/Dropbox/Personal/Coding/Java/Bubble Tea Demo.jar
 * Qualified Name:     BubbleNode
 * JD-Core Version:    0.6.2
 */