package tickets;

public class ServeTicket implements TicketService{

	@Override
	public int numSeatsAvailable(int venueLevel) {
		
		int count=0;
		
		if (Venue.levels.get(venueLevel)!=null){
			for (Row row: Venue.levels.get(venueLevel).rows){
				count += row.capacity-row.fullSeats;
			}		
		}
		return count;
	}

	@Override
	//I'm assuming here that people who buy seats together are willing to sit in different rows and levels
	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel,
			String customerEmail) {
		int numSeatsToHold= numSeats;
		SeatHold seatHold = new SeatHold();
		
		for (int i = minLevel; i<=maxLevel; i++){
			Level level  = Venue.levels.get(i);
			//results in an indefinite loop (FIX)
			while (numSeatsToHold>0){
				Row row = level.assignSeat(customerEmail);
				//if row does not equal null then a row with an available seat has been located
				if (row!=null){
					seatHold.seats.add(row.seats.get(row.fullSeats-1));
					if (!seatHold.level.contains(level)){
						seatHold.level.add(level);
					}
					if (!seatHold.row.contains(row)){
						seatHold.row.add(row);
					}
					numSeatsToHold--;
				} else {
					break;
				}
			}
		}
		
		if (numSeatsToHold==0){
			seatHold.customer = new Customer(customerEmail);
			seatHold.numSeats=numSeats;
			return seatHold;
		}
		
		return null;
	}

	@Override
	public String reserveSeats(String seatHoldId, String customerEmail) {
		//reserves a seat for the customer if their seatHoldId can be located in the Venue's list of SeatHolds
		SeatHold seatHold = Venue.seatHolds.get(seatHoldId);
		if (seatHold!=null){
			if (seatHold.customer.email.equals(customerEmail)){
				seatHold.setConfirmCode();
				return seatHold.getConfirmCode();
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
