/*Matt Nicol
 * Hotel Booking
 * 16/11/18
 * Eclipse v4.9.0
 */

package HotelBooking;

import java.util.Scanner;


public class hotel 
{
	//Declare variables, create an array for floors
	private int hotelnumber;
	private String hotelname;
	private floor floors[] = new floor[4];
	
	
	public hotel(int nos, String name)
		{
			//Declare variables, create floors, and add to array
			hotelnumber = nos;
			hotelname = name;
			floor f1 = new floor(1);
			floor f2 = new floor(2);
			floor f3 = new floor(3);
			floor f4 = new floor(4);
			floors[0] = f1;
			floors[1] = f2;
			floors[2] = f3;
			floors[3] = f4;
		
		}
	
	
	public void displayHotel(hotel h)
		{
			//Display hotel details
			System.out.println("Hotel Name: "+hotelname);
			System.out.println("Hotel Number: "+hotelnumber);
			floor.fMenu(h);
		}
	
	
	public void displayFloors(hotel h)
		{
		//For every floor in array, display floor
		for (int counter=0;counter <floors.length; counter++)
			{
			floors[counter].displayFloor();
			}
		floor.fMenu(h);
		}
	
	
	public void display(int floornos)
		{
			System.out.println("Hotel Name: "+hotelname);
			floors[floornos].displayFloor();
		}
	
	
	public void bookARoom(hotel h)
		{
			//Select floor for booking
			int counter=0; boolean found = false;
			Scanner kboard = new Scanner(System.in);
			int floorchoice;
			System.out.println("Which floor would you like to stay on?");
			floorchoice = kboard.nextInt();
			
			for (counter=0; counter < floors.length; counter++) 
			{
				if (floorchoice == floors[counter].returnFloorNos())
				{
					found = true;
					floors[floorchoice-1].findaRoomtoBook(h, floorchoice);
					break;
				}
			}
			
			if (found == false)
			{
				System.out.println("No such floor number");
				room.rMenu(h);
			}
		}

	
	public void cancelARoom(hotel h)
		{
			//Select floor for cancelling
			Scanner kboard = new Scanner(System.in);
			int counter=0; boolean found = false;
			int floorchoice;
			System.out.println("Which floor are you staying stay on?");
			floorchoice = kboard.nextInt();
			
			for (counter=0; counter < floors.length; counter++) 
			{
				if (floorchoice == floors[counter].returnFloorNos())
				{
					found = true;
					floors[floorchoice-1].findaRoomtoCancel(h);
					break;
				}
			}
			
			if (found == false)
			{
				System.out.println("No such floor number");
				room.rMenu(h);
			}
		}
	
		
	public static void hMenu(hotel h) {
		int hValue;
	    // Display Main menu
	    System.out.println("============================");
	    System.out.println("|   Hotel  Booking  Menu   |");
	    System.out.println("============================");
	    System.out.println("| Options:                 |");
	    System.out.println("|        1. Floors         |");
	    System.out.println("|        2. Rooms          |");
	    System.out.println("|        3. Queries        |");   
	    System.out.println("|        0. Exit           |");
	    System.out.println("============================");
	    hValue = keyIn.inInt(" Select option: ");

	    // Switch construct
	    switch (hValue) 
	    {
	    default:
	      System.out.println("Invalid selection");
	      hotel.hMenu(h);
	      break;				//Display error if input is not an int
	    case 1:
	      System.out.println("Floors selected");
	      floor.fMenu(h);		//Go to Floor menu
	      break;
	    case 2:
	      System.out.println("Rooms selected");
	      room.rMenu(h);		//Go to Room menu
	      break;
	    case 3:
	      System.out.println("Queries selected");
	      hotel.query(h);		//Go to Query menu
	      break; 
	    case 0:
	      System.out.println("Exit selected");
	      System.out.println("Goodbye");
	      break;				//Exit program
	    }
	}
	
	public static void query(hotel h) {
		System.out.println("Queries coming soon");
		hotel.hMenu(h);
	}

}
