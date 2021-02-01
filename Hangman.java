import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Hangman
{
	private int wins;
	private int loses;
	private String currentWord;
	
	public Hangman() throws Exception
	{
		Dictionary myDictionary = new Dictionary("words2.txt");
		myDictionary.readFile("words2.txt");
		currentWord = myDictionary.chooseWord();
		
	}
	public void loadWL()
	{
		try
		{
			File WL = new File("WL.txt");
			Scanner input = new Scanner(WL);
			
			wins = input.nextInt();
			loses = input.nextInt();
			
			input.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public void writeWL() throws Exception
	{
		try
		{
			File WL = new File("WL.txt");
			Writer w = new FileWriter(WL);
			
			w.write(wins + "\n");
			w.write(loses + "\n");
			
			w.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public void playGame() throws Exception
	{
		Dictionary myDictionary = new Dictionary("words2.txt");
		myDictionary.readFile("words2.txt");
		currentWord = myDictionary.chooseWord();
		
		Scanner aScanner = new Scanner(System.in);
		Random r = new Random();
		
		String play = " ";
		
		System.out.print("Would you like to play? Y or N: ");
		play = aScanner.nextLine().toUpperCase();
		
		if (play.equals("Y")) 
		{
			int guesses = 5;
			
			currentWord = currentWord.toUpperCase();
			char[] character = currentWord.toCharArray();
			char[] censoredWord = currentWord.toCharArray();
			
			for (int a = 0; a < currentWord.length(); a++)
			{
				censoredWord[a] = '*';
			}
			
			while (String.valueOf(censoredWord).equals(currentWord) == false && guesses > 0)
			{
				boolean correct = false;
				boolean repeated = false;
			
				for (int b = 0; b < currentWord.length(); b++) 
				{
					System.out.print(censoredWord[b]);
				}
				System.out.println();
			
				System.out.println("Guess a letter: ");
				String letter = aScanner.nextLine();
				
				String guess = letter.toUpperCase().substring(0,1);
				char currentGuess = guess.charAt(0);
			
				if(!repeated)
				{
					for (int a = 0; a < currentWord.length(); a++)
					{
						if (character[a] == currentGuess)
						{
							censoredWord[a] = currentGuess;
							correct = true;
						}
					}
					if (correct)
					{
						System.out.println("The letter " + currentGuess + " is in the word.");
						System.out.println("You have " + guesses + " guesses left.");
					}
					else
					{
						System.out.println("Sorry, there are no " + currentGuess + "'s in the word.");
						guesses--;
						System.out.println("You have " + guesses + " guesses left.");
					}
				}
			}
			if (String.valueOf(censoredWord).equals(currentWord) == false || guesses == 0)
			{
				int thisLoses = 0;
				thisLoses++;
				System.out.println();
				System.out.println("You lost!");
				System.out.println("You have " + 0 + " wins and " + thisLoses + " lose this round.");
				loses++;
				System.out.println("You have a total of " + wins + " wins and " + loses + " loses.");
				System.out.println();
				System.out.println("Would you like to go back to the beginning? Y or N: ");
				thisLoses--;
				String again = aScanner.nextLine().toUpperCase();
			
				if (again.equals("N"))
				{
					System.out.println("See you soon!");
				}
				else
				{
					playGame();
				}
			}
			else
			{
				int thisWin = 0;
				thisWin++;
				System.out.println();
				System.out.println("You won!");
				System.out.println("You have " + thisWin + " win and " + 0 + " loses this round.");
				wins++;
				System.out.println("You have a total of " + wins + " wins and " + loses + " loses.");
				System.out.println("Would you like to go back to the start? Y or N: ");
				thisWin--;
				String game = aScanner.nextLine().toUpperCase();
				if (game.equals("N"))
				{
					System.out.println("See you soon!");
				}
				else
				{
					playGame();
				}
			}
		}
		else
		{
			System.out.println("See you soon!");
		}
	}
}


