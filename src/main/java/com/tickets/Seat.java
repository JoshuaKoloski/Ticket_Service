package tickets;

public class Seat {
	Customer customer;
	Level level;
	Row row;
	
	public Seat(Row row){
		this.row = row;
		this.level = row.level;
	}
	public Seat(String email, Row row){
		this(row);
		this.customer.email=email;
	}
	//prints out the seat number where the level is represented by a level number, the row is represented by an uppercase letter
	//and the seat is represented by a seat number
	public String getSeatNum(){
		int seatLoc = row.seats.indexOf(this)+1;
		return ""+level.getLevelNum()+row.getRowLocation()+seatLoc;

	}


}
