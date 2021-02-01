import java.util.Scanner;

public class Application 
{
	public static void main(String[] args) throws Exception
	{
		Scanner aScanner = new Scanner(System.in);
		
		Hangman myHangman = new Hangman();
		
		System.out.println("Welcome to Hangman");
		
		myHangman.loadWL();
		myHangman.playGame();
		myHangman.writeWL();
	}
}
