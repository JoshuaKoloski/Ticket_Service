package tickets;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemainingSeats {
	public static ServeTicket serve  = new ServeTicket();
	
	@Test
	//Tests calculating remaining seats after adding seats and removing seats
	public void testAddingAndRemoving() {
		
		int seatsNum = 20;
		int rowNum = 6;
		int levelNum = 1;
		Level l1 = Venue.createLevel(rowNum, seatsNum, levelNum);

		
		int seatsAssigned = 0;
		assertEquals(l1.seatsInRow*l1.levelRows, serve.numSeatsAvailable(l1.getLevelNum()));
		l1.assignSeat("joshuakoloski@gmail.com");
		seatsAssigned++;
		l1.assignSeat("jaredk#gmail.com");
		seatsAssigned++;
		assertEquals((l1.seatsInRow*l1.levelRows)-seatsAssigned, serve.numSeatsAvailable(l1.getLevelNum()));
		
		
		//fail("Not yet implemented");
	}

	@Test
	//Tests that 0 is returned when searching for available seats in a level with no available seats
	public void testNoAvailableSeats(){

		int seatsNum=50;
		int rowNum=15;
		int levelNum=3;
		
		Level l3 = Venue.createLevel(rowNum, seatsNum, levelNum);
		
		for (int i = 0; i < l3.levelRows*l3.seatsInRow; i++){
			l3.assignSeat(""+i);
		}
		assertEquals(0, serve.numSeatsAvailable(l3.getLevelNum()));
	}

}
