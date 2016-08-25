package tickets;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.UUID;

public class TestReserveSeats {
	public static ServeTicket serve = new ServeTicket();
	
	@Test
	//Tests that the reservation code returned by the reserveSeats method matches the seatHold's reservation code
	public void testReservation() {
		int rowNum = 10;
		int seatsNum = 10;
		int levelNum = 1;
		
		Venue.createLevel(rowNum, seatsNum, levelNum);
		
		Customer customer = new Customer("jordanj@gmail.com");
		int customerSeats = 3;
		SeatHold seatHold = serve.findAndHoldSeats(customerSeats, levelNum, levelNum, customer.email);
		if (seatHold==null){
			System.out.println("There are not enough available seats for the customer");
		} else {
			seatHold.printSeatHold();
		}
		
		String reservationCode = serve.reserveSeats(seatHold.getId(), customer.email);
		if (reservationCode!=null){
			System.out.print(reservationCode);
		} else {
			System.out.println("Sorry we cannot find any ticket corresponding to the information you have provided");
		}
		
		assertEquals(reservationCode, seatHold.getConfirmCode());
		
	}
	
	
	@Test
	//Tests that null is returned when a customer provides a 
	public void testNoReservation(){
		Customer customer = new Customer("andrew.johnson@gmail.com");
		String randId = UUID.randomUUID().toString();
		assertEquals(null, serve.reserveSeats(randId, customer.email));
	}

}
