/*Matt Nicol
 * Hotel Booking
 * 16/11/18
 * Eclipse v4.9.0
 */

package HotelBooking;

import java.util.Scanner;

public class floor 
{
	//Declare variables, create array for rooms
	private int floornumber;
	room rooms[] = new room[4];

	public floor(int nos)
	{
		//Assign variable, create and add rooms to array
		floornumber = nos;
		room r1 = new room(1);
		room r2 = new room(2);
		room r3 = new room(3);
		room r4 = new room(4);
		
		rooms[0] = r1; rooms[1] = r2; rooms[2] = r3; 	rooms[3] = r4;
	}
	
	
	public int returnFloorNos() {
		return(this.floornumber);
	}
	
	
	public void displayFloor()
	{
		//For every room in array, display room
		System.out.println("Floor: "+floornumber);
		for(int counter=0;counter<rooms.length;counter++)
			rooms[counter].display();
	}
	
	
	public void findaRoomtoBook(hotel h, int fc)
	{
		//Checks if selected room is valid and not booked 
		Scanner kboard = new Scanner(System.in);
		int nos; int counter=0; boolean found = false;
		System.out.println("Please enter room number: ");
		nos = kboard.nextInt();
		
		//Loop through rooms array to find users room choice
		for (counter=0; counter < rooms.length; counter++)
		{
			if (nos == rooms[counter].returnRoomNos())
			{
				found = true;
				rooms[counter].bookroom(h, fc);
				break;
			}
		}
		if (found == false) System.out.println("No such room number");
		room.rMenu(h);
	}
	
	
	public void findaRoomtoCancel(hotel h)
	{
		Scanner kboard = new Scanner(System.in);
		int nos; int counter=0; boolean found = false;
		System.out.println("Please enter room number: ");
		nos = kboard.nextInt();
		for (counter=0; counter < rooms.length; counter++)
		{
			if (nos == rooms[counter].returnRoomNos())
			{
				found = true;
				rooms[counter].cancelRoom(h);
				break;
			}
		}
		if (found == false) System.out.println("No such room number");
		room.rMenu(h);
	}
	
	public static void fMenu(hotel h) {
	    int fValue;
	
	    // Display Floor menu
	    System.out.println("============================");
	    System.out.println("|   Hotel  Booking  Menu   |");
	    System.out.println("============================");
	    System.out.println("| Options:                 |");
	    System.out.println("|    1. Hotel Details      |");
	    System.out.println("|    2. Display Floors     |");
	    System.out.println("|    0. Exit               |");
	    System.out.println("============================");
	    fValue = keyIn.inInt(" Select option: ");
	
	    // Switch construct
	    switch (fValue) 
	    {
	      default:
	        System.out.println("Invalid selection");
	        floor.fMenu(h);
	        break;					//Display error if input is not an int
	      case 1:
	        System.out.println("Hotel Details selected");
	        h.displayHotel(h);		//Display hotel details
	        break;
	      case 2:
	        System.out.println("Display Floors selected");
	        h.displayFloors(h);		//Display floor details
	        break;
	      case 0:
	        System.out.println("Exit selected");
	        hotel.hMenu(h);;	//Return to Main menu
	        break;
	    }
	}	
}