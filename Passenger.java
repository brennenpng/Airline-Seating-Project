import java.util.Scanner;

public class Passenger {
	
	private String name;
	private SeatClass seatClass;
	private SeatType seatType;
	
	
	/*
	 * receives scanner that reads data file
	 * reads passenger name, class, and seat type
	 * assigns them to their respective variables
	 */
	public Passenger(Scanner inFile) {
		name = inFile.next() + " " + inFile.next();
		seatClass = SeatClass.valueOf(inFile.next());
		seatType = SeatType.valueOf(inFile.next());
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	/* getters and toString */
	
	public String getName() {
		return name;
	}
	
	public SeatClass getSeatClass() {
		return seatClass;
	}
	
	public SeatType getSeatType() {
		return seatType;
	}
	
	public String toString() {
		return name + " " + seatClass + " " + seatType;
	}
	
}
