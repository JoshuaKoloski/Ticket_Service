package tickets;
import java.util.*;


public class SeatHold {
	Customer customer;
	ArrayList<Seat> seats;
	ArrayList<Level> level;
	ArrayList<Row> row;
	int numSeats;
	private String id;
	private String confirmCode;
	
	
	public SeatHold(){
		customer = new Customer();
		seats = new ArrayList<Seat>();
		level = new ArrayList<Level>();
		row  = new ArrayList<Row>();
		//generates a random string to use as an id
		id = UUID.randomUUID().toString();
		Venue.seatHolds.put(id, this);
	}
	
	//prints out the levels associated with the SeatHold
	public void printLevels(){
		for (Level l : level){
			System.out.print(l.getLevelNum());
			if (l!=level.get(level.size()-1)){
				System.out.print(", ");
			}else {
				System.out.println("");
			}
		}
	}
	//prints out the rows associated with the SeatHold
	public void printRows(){
		for (Row r : row){
			System.out.print(""+r.level.getLevelNum()+r.getRowLocation());
			if (r!=row.get(row.size()-1)){
				System.out.print(", ");
			}else {
				System.out.println("");
			}
		}
	}
	//prints out the seats associated with the SeatHold
	public void printSeats(){
		for (Seat s : seats){
			System.out.print(s.getSeatNum());
			if (s!=seats.get(seats.size()-1)){
				System.out.print(", ");
			}else {
				System.out.println("");
			}
		}
	}
	
	//prints out the SeatHold information, including customer,levels, rows, and seats
	public void printSeatHold(){
		System.out.println("Customer: " + customer.email);
		System.out.print("Level(s): ");
		printLevels();
		System.out.print("Row(s): ");
		printRows();
		System.out.print("Seat(s): ");
		printSeats();
	}
	
	public String getId(){
		return this.id;
	}
	
	public String setConfirmCode(){
		//generates a random unique string to use as an confirm code
		return confirmCode = UUID.randomUUID().toString();	
	}
	
	public String getConfirmCode(){
		return confirmCode;
	}

	
}
