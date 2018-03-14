import java.util.Scanner;

public class Passenger {
	
	private String name;
	private SeatClass seatClass;
	private SeatType seatType;
	
	public Passenger(Scanner inFile) {
		name = inFile.next() + " " + inFile.next();
		seatClass = stringToSeatClass(inFile.next());
		seatType = stringToSeatType(inFile.next());
	}
	
	public static SeatClass stringToSeatClass(String s) {
		switch(s) {
		case "First": return SeatClass.FIRST;
		case "Econ": return SeatClass.ECON;
		default: return SeatClass.ECON;
		}
	}
	
	public static SeatType stringToSeatType(String s) {
		switch(s) {
		case "W": return SeatType.WIN;
		case "C": return SeatType.CEN;
		case "A": return SeatType.AIS;
		default: return SeatType.AIS;
		}
	}
	
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
