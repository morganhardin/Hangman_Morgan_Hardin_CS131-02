import java.io.*;
import java.util.Random;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Dictionary 
{
	/** This instantiates the random class so that
	 * it can be used later to generate a random word 
	 * from the words2.txt file. It also instantiates
	 * other values that can be used in the following
	 * methods.
	 */
	Random r = new Random();
	
	String wordlist[] = new String[200];
	private int currentCard;
	private SecureRandom randomNumbers;
	
	/** This is an empty constructor class.
	 */
	public Dictionary(String filename)
	{
		
	}
	/** This class instantiates a new File d that will
	 * be scanned to read each line of the words2.txt
	 * file so that the words can be used in the next
	 * method.
	 * @param filename
	 * @throws Exception
	 */
	public void readFile(String filename) throws Exception
	{
		try
		{	
			File d = new File(filename);
			Scanner input = new Scanner(d);
			for (int b = 0; b < 200; b++)
			{
				wordlist[b] = input.nextLine();
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
	/** This method chooses a random word (from the 
	 * Random generator from the beginning and
	 * will return a different word from the list
	 * each time the program is run.
	 * @return
	 */
	public String chooseWord()
	{
		int a = r.nextInt(200);
		return wordlist[a];
	}
}

