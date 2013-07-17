/**
 * A class to deal with nodes 
 * @author David Aghassi
 *
 */
public class BubbleNode
{
	//Variables
	private String answer;
	private int place = 0;

	/**
	 * Creates a new node
	 * @param answer The string of the answer chosen
	 * @param number A number assigned based on what was chosen
	 * This number will be chained together with others to find the choices later on
	 */
	public BubbleNode(String answer, int number)
	{
		this.answer = answer;
		setPlace(number);
	}

	/**
	 * Gets the answer stored in the node
	 * @return The string stored in the node
	 */
	public String getElement()
	{
		return this.answer;
	}

	/**
	 * Gets the number stored in the node
	 * @return The number stored in the node
	 */
	public int getPlace()
	{
		return this.place;
	}

	/**
	 * Sets the number stored in the node
	 * @param place The number to be stored in the node
	 */
	private void setPlace(int place)
	{
		this.place = place;
	}
}
