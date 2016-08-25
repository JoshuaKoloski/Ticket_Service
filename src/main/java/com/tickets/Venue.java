package tickets;
import java.util.HashMap;


public class Venue {
	//uses a hash map from level number to level to avoid problems where level number is different from index in array
	public static HashMap<Integer, Level> levels=new HashMap<Integer, Level>();
	public static HashMap<String, SeatHold> seatHolds = new HashMap<String, SeatHold>();
	
	public static Level createLevel(int rowNum, int seatsNum, int levelNum){
		Level l1 = new Level(levelNum);
		
		l1.seatsInRow = seatsNum;
		l1.levelRows = rowNum;
		
		for (int i = 0; i < l1.levelRows; i++){
			Row r = new Row(l1);
			l1.rows.add(r);
		}
		return l1;
	}
}
