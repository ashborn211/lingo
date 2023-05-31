package lingo;

import lingotest.Menutest;
import lingotest.Playtest;

public class Lingo
{

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

	while (true)
	{
	    Menu menuhelper = new Menu();
	    Play play = new Play();

	    int Options = menuOption();
	    switch (Options)
	    {
	    case 1:
		menuhelper.rules();
		break;

	    case 2:
		play.game();
		break;

	    case 3:
		System.exit(0);
	    }
	}
    }

    public static int menuOption()
    {
	Menutest mainmenu = new Menutest();

	String title = "main menu";
	String[] options =
	{ "Show game rules", "Play game", "Exit game" };
	return mainmenu.maincheck(title, options);
    }
}