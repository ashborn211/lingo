package lingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play
{
    private ArrayList<String> scoreList = new ArrayList<String>();
    private ArrayList<Integer> scoreListAttempt = new ArrayList<Integer>();

    public String generateword()
    {
	String[] words =
	{ "david", "lucas", "larry", "milan", "bezem" };
	// dit voegt een random woord van een array toe aan een String

	Random rand = new Random();
	int index = rand.nextInt(words.length);

	String word = words[index];
	return word;

    }

    public void game()
    {
	int attempt = 0;
	boolean playStatus = true;
	String code = generateword();
	String raad = "";

	while (playStatus)
	{
	    Scanner input = new Scanner(System.in);

	    System.out.println("Word: " + code);
	    System.out.println("raad de woord");

	    raad = input.next();

	    attempt++;
	    scoreListAttempt.add(attempt);
	    String gamestatus = check(raad, code);
	    System.out.println("\r\n");

	    showscore(gamestatus);
	    System.out.println("\r\n");

	    // dit schrijft welke letter je hebt/niet hebt en of je gewonnen hebt
	    System.out.println("you entered the word: " + raad);
	    System.out.println("these are the Results " + gamestatus);
	    System.out.println("attempt: " + attempt);
	    if (code.equalsIgnoreCase(gamestatus))
	    {
		System.out.println("gefeliciteerd je hebt gewonnen");
		System.out.println("\r\n");
		playStatus = false;
	    } else if (attempt >= 5)
	    {
		System.out.println("je hebt verloren");
		System.out.println("\r\n");

		playStatus = false;
	    }

	}

    }

    public String check(String raad, String code)
    {
	// dit verandert de strings naar char arrays
	char[] raad2 = raad.toCharArray();
	char[] Woord = code.toCharArray();
	char vervang = "!".charAt(0);
	int letters = code.length();

	StringBuilder antwoord = new StringBuilder();

	// hoofdletter = goede letter en plek
	// kleine letter = goede letter verkeerde plek
	// streepje = fout
	try
	{
	    for (int i = 0; i < code.length(); i++)
	    {

		if (raad2[i] == Woord[i])
		{// goede letter en plek
		    antwoord.append(Character.toUpperCase(Woord[i]));

		    // maakt een hoeftletter van de letter en voegt het to aan de String antwoord
		    Woord[i] = vervang;
		    // maakt van een letter een symbool zodat je niet dubbel krijgt
		} else if (includesCHAR(Woord, raad2[i]))
		{// letter = goed plek = fout
		    for (int x = 0; x < Woord.length; x++)
		    {
			if (Woord[x] == raad2[i])
			{// we vervangen het woord zodat we niks dubbel krijgen
			    Woord[x] = vervang;
			    antwoord.append(Character.toLowerCase(raad2[i]));

			    // maakt een kleine letter van de letter en voegt het to aan de String antwoord
			    // we gebruiken de character class hiervoor
			}
		    }
		} else
		{
		    antwoord.append("-");
		    // letter zit niet in het woord
		    // dan word er een "-" neergezet in antwoord
		}

	    }
	} catch (ArrayIndexOutOfBoundsException e)
	{
	    System.out.println("de woord die jij hebt ingevuld is te lang,te kort of heeft nummers");
	    System.out.println("de lengte van de woord die je moet raden is " + letters);
	    System.out.println(
		    "dit kost je wel een 'attempt' maar je krijgt wel te zien welke letters in het woord staan");

	}
	String antwoordString = antwoord.toString();

	return antwoordString;

    }

    public void showscore(String gamestatus)
    {

	scoreList.add(gamestatus);
	System.out.println("hier onder is een lijst met jouw resultaten");
	for (int i = 0; i < scoreList.size(); i++)
	{
	    System.out.println("kans: " + scoreListAttempt.get(i) + " " + scoreList.get(i));
	}

    }

    public static boolean includesCHAR(char[] woord, char raad)
    {
	// hier word er gekeken of de letter die je hebt gekozen in de woord staat
	// als dat zo is returned hij true
	// als dat niet zo is returned hij false
	for (char k : woord)
	{
	    if (k == raad)
	    {
		return true;
	    }
	}

	return false;

    }

}