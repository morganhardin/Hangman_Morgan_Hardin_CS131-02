import java.io.*;
import java.util.Random;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Dictionary 
{
	Random r = new Random();
	
	private String wordlist[] = new String[200];
	private int currentCard;
	private SecureRandom randomNumbers;
	
	public Dictionary(String filename)
	{
		
	}
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
	public String chooseWord()
	{
		int a = r.nextInt(200);
		return wordlist[a];
	}
}

