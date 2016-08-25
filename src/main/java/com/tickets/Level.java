package tickets;
import java.util.ArrayList;


public class Level {
	
	private int levelNum;
	String levelName;
	int levelPrice;
	int levelRows;
	int seatsInRow;
	ArrayList<Row> rows;
	
	///creates a level and puts it into the venue hash map
	public Level(int levelNum){
		rows = new ArrayList<Row>();
		this.levelNum = levelNum;
		assignLevel(levelNum);
	}
	//Iterates through the rows in the level and assigns customer to best available seat
	public Row assignSeat(String email){
		for (Row r: rows){
			if (!r.isFull()){
				Seat seat = r.findAvaliableSeat();
				if (seat!=null){
					seat.customer = new Customer(email);
					r.fullSeats++;
					return r;
				}
				
			}
		}
		//no open seats
		return null;
		
	}
	
	
	public void assignLevel(int levelNum){
		Venue.levels.put(levelNum, this);
	}
	
	public int getLevelNum(){
		return levelNum;
	}

}
