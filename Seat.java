public class Seat {
	SeatType type;
	SeatClass cabin;
	String name;
	Passenger passenger;
	
	public Seat(int row, char seat, SeatType type, SeatClass cabin) {
		this.name = row + "" + seat;
		this.type = type;
		this.cabin = cabin;
	}
	
	public SeatType getSeatType() {
		return this.type;
	}
	
	public SeatClass getSeatClass() {
		return this.cabin;
	}
	
	public void setPassenger(Passenger p) {
		this.passenger = p; 
	}
	
	public Passenger getPassenger() {
		return this.passenger;
	}
	
	public String toString() {
		return name;
	}
}
