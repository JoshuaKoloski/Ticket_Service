package tickets;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFindAndHoldSeats {
	public static ServeTicket serve = new ServeTicket();
	@Test
	//test finding and holding seats in a single row
	public void testSeatsInOneRow() {
		int rowNum = 20;
		int seatsNum = 6;
		int levelNum=1;
		
		Level l1 = Venue.createLevel(rowNum, seatsNum, levelNum);
		
		int minLevel=1;
		int maxLevel=minLevel;
		String customerEmail = "jeremy.kol@comcast.net";
		int numSeats = 10;
		SeatHold seatHold = serve.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
		if (seatHold==null){
			fail("There are not enough available seats for the customer");
		} else {
			seatHold.printSeatHold();
		}
		
		assertEquals(seatHold.customer.email, customerEmail);
		assertEquals(seatHold.level.get(0), l1);
		assertEquals(seatHold.numSeats, numSeats);
		assertEquals(seatHold.row.get(0), l1.rows.get(0));
		assertEquals(seatHold.seats.size(), numSeats);
	}
	
	@Test
	//Tests finding and holding seats in two rows
	public void testSeatsInTwoRows(){
		int rowNum = 20;
		int seatsNum = 6;
		int levelNum=1;
		
		Level l1 = Venue.createLevel(rowNum, seatsNum, levelNum);
		
		int customerSeatsNum = rowNum+1;
		int minLevel=1;
		int maxLevel=2;
		String customerEmail = "jordan@yahoo.com";
		
		SeatHold seatHold = serve.findAndHoldSeats(customerSeatsNum, minLevel, maxLevel, customerEmail);
		if (seatHold==null){
			fail("there are not enough available seats for the customer");
		} else {
			seatHold.printSeatHold();
		}
		
		assertEquals(seatHold.customer.email, customerEmail);
		assertEquals(seatHold.level.get(0), l1);
		assertEquals(seatHold.numSeats, customerSeatsNum);
		assertEquals(seatHold.row.get(0), l1.rows.get(0));
		assertEquals(seatHold.row.get(1), l1.rows.get(1));
		assertEquals(seatHold.seats.size(), customerSeatsNum);
		
		
	}
	
	@Test
	//Tests finding and holding seats in two levels
	public void testSeatsInTwoLevels(){
		int seatsNum1 = 10;
		int rowNum1 = 10;
		int levelNum1=1;
		Level l1 = Venue.createLevel(rowNum1, seatsNum1, levelNum1);
		
		int seatsNum2 = 15;
		int rowNum2 = 4;
		int levelNum2 = 2;
		Level l2 = Venue.createLevel(rowNum2, seatsNum2, levelNum2);

		SeatHold seatHold = new SeatHold();
		//
		for (Row r: l1.rows){
			if (r.getRowNum()==l1.rows.size()){
				seatHold=serve.findAndHoldSeats((r.capacity-r.fullSeats)+1, l1.getLevelNum(), l2.getLevelNum(), r.getRowNum()+"");
			} else {
				serve.findAndHoldSeats(r.capacity, l1.getLevelNum(), l2.getLevelNum(), r.getRowNum()+"");
			}
		}
		
		assertEquals(seatHold.customer.email, l1.rows.size()+"");
		assertEquals(seatHold.level.get(0), l1);
		assertEquals(seatHold.numSeats, l1.seatsInRow+1);
		assertEquals(seatHold.row.get(0), l1.rows.get(l1.levelRows-1));
		assertEquals(seatHold.row.get(1), l2.rows.get(0));
		
	}


}
