/*Matt Nicol
 * Hotel Booking
 * 16/11/18
 * Eclipse v4.9.0
 */

package HotelBooking;

import java.util.Scanner;

public class customer 
{
	//Declare customer variables
	private String customerName;
	private String customerEmail;
	
	public customer()
	{
		
	}
	
	
	public customer(String cname, String cemail)
	{
		//Set customer variables
		customerName = cname;
		customerEmail = cemail;
	}
	
	
	public void display()
	{
		//Display customer details
		System.out.println("Details are "+customerName+ " "+customerEmail);
	}
	
	
	public void getname()
	{
		//Get customer name
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter your name");
		customerName = kboard.nextLine();
	}
	
	
	public void getemail()
	{
		//Get customer contact details
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter your contact details");
		customerEmail = kboard.nextLine();
	}
}
