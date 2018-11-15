/*Matt Nicol
 * Hotel Booking
 * 16/11/18
 * Eclipse v4.9.0
 */

package HotelBooking;


public class room 
{
	//Declare variables
	private int roomNos;
	private customer occupier;
	private boolean status;
	
	public room(int rnos)
	{
		//Set room status to free
		roomNos = rnos;
		status = true;
	}
	
	
	public void display()
	{
		//Display if room is free, otherwise display occupant
		System.out.println("Room number: "+roomNos);
		if (status==true)
			System.out.println("Room is free");
		else
			occupier.display();
	}
	
	
	public void bookroom(customer newperson)
	{
		//Fill room with occupant details and set the room as unavailable
		if (status==true)
			{
			status = false;
			occupier = newperson;
			}
		else
			System.out.println("Sorry room booked");
	}
	
	
	public void bookroom(hotel h, int fc)
	{
		System.out.println("Room "+roomNos);
		if (status==true)							// Checks to see if room is free
			{
			customer newperson = new customer();    // Creates an instance of customer
			newperson.getname();					// Get the customer details
			newperson.getemail();
			status = false;							// Makes sure nobody else can book the room
			occupier = newperson;					// Attaches the new customers details to the room
			System.out.println("Your floor: "+fc);
			System.out.println("Your room: "+roomNos);
			System.out.println("Thank you for booking ");
			newperson.display();					//Confirm customer booking 
			hotel.hMenu(h);							//Return to main menu
			}
		else
			System.out.println("Sorry room booked");
			room.rMenu(h);
	}
	
	
	public void cancelRoom(hotel h)
	{
		//Set room as free and clear occupant details
		status = true;
		occupier = null;
		System.out.println("Room cancelled");
		hotel.hMenu(h);
	}
	
	
	public int returnRoomNos() {
		return(roomNos);
	}
	
	
	public static void rMenu(hotel h) {
	    int rValue;
		
	    // Display room menu options
	    System.out.println("============================");
	    System.out.println("|   Hotel  Booking  Menu   |");
	    System.out.println("============================");
	    System.out.println("| Options:                 |");
	    System.out.println("|    1. Book a Room        |");
	    System.out.println("|    2. Cancel a Booking   |");
	    System.out.println("|    0. Exit               |");
	    System.out.println("============================");
	    rValue = keyIn.inInt(" Select option: ");
	
	    // Switch construct
	    switch (rValue) 
	    {
	      default:
	        System.out.println("Invalid selection");
	        room.rMenu(h);
	        break;					//Display error if input is not an int
	      case 1:
	        System.out.println("Book Room selected");
	        h.bookARoom(h);			//Go to booking a room
	        break;
	      case 2:
	        System.out.println("Cancel Booking selected");
	        h.cancelARoom(h);		//Go to cancel a booking
	        break;
	      case 0:
	        System.out.println("Exit selected");
	        hotel.hMenu(h);	//Return to main menu
	        break;
	    }
	}
}
