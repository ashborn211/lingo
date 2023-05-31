package lingo;

import java.util.Scanner;

public class Menu
{

    public int maincheck(String title, String[] options)
    {
	Scanner invoer = new Scanner(System.in);

	System.out.println(title);
	for (int i = 0; i < options.length; i++)
	{
	    System.out.println((i + 1) + ") " + options[i]);
	}

	int keuze = 0;

	while (keuze == 0)
	{
	    int keuze2 = invoer.nextInt();
	    if (keuze2 >= 1 && keuze2 <= options.length)
	    // dit zorgt ervoor dat je alleen een keuze kan maken die ook iets doet
	    {
		keuze = keuze2;
	    } else
	    {
		System.out.println("select a valid option please");
	    }

	}

	return keuze;

    }

    public void rules()
    {
	System.out.println("je gaat een woord raden");
	System.out.println("als je het woord invoewrd gebruik geen hoofdletters");
	System.out.println("hoofdletter = goede letter en plek");
	System.out.println("kleine letter = goede letter verkeerde plek");
	System.out.println("streepje = fout");
	System.out.println("\r\n");
    }

}
