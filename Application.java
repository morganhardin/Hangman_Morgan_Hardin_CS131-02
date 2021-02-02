public class Application 
{
	/** This is the main method that will print the 
	 * introduction. It also instantiates a new 
	 * instance of the Hangman class that will then call
	 * the loadWL() method, playGame() method, and 
	 * writeWL() method. This will run these 
	 * methods so that the user will be able to 
	 * interact and play the game.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		Hangman myHangman = new Hangman();
		
		System.out.println("Welcome to Hangman");
		
		myHangman.loadWL();
		myHangman.playGame();
		myHangman.writeWL();
	}
}
