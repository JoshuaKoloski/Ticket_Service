package tickets;
import java.util.ArrayList;


public class Row {
	Level level;
	public ArrayList<Seat> seats;
	int capacity;
	int fullSeats;
	private int rowNum;
	
	public Row (Level l){
		level=l;
		seats = new ArrayList<Seat>();
		capacity=l.seatsInRow;
		populateSeats(capacity);
		rowNum = l.rows.size()+1;
	}
	
	public boolean isFull(){
		return fullSeats==capacity;
	}
	//adds a specified number of seats to a row
	public void populateSeats(int capacity){
		for (int i = 0; i < capacity; i++){
			seats.add(new Seat(this));
		}
	}
	//finds and returns the best seat that is not held or reserved by any customer
	public Seat findAvaliableSeat(){
		if (!this.isFull()){
			return seats.get(fullSeats);
		} 
		return null;
		
	}
	
	public int getRowNum(){
		return rowNum;
	}
	//converts the row number into the correlative uppercase letter (e.g. 1-> A)
	public char getRowLocation(){
		int asciiNumToLetter = 64;
		return(char)(getRowNum()+asciiNumToLetter);	
	}

}
