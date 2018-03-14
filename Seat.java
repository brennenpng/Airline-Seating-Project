public class Seat {
	SeatType type;
	SeatClass cabin;
	String name;
	Passenger passenger;
	
	public Seat(int row, char seat, SeatType type, SeatClass cabin) {
		this.name = row + "" + seat;
		this.type = type;
		this.cabin = cabin;
		this.passenger = null;
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
		if(!passenger.equals(null))
			return name;
		return name + " " + passenger.getName();
	}
}
