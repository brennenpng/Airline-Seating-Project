public class Seat {
	SeatType type; //Window, Aisle, or Center
	SeatClass cabin; //First or Economy
	String name; //Row # and Spot
	Passenger passenger; //Who is sitting here
	
	public Seat(int row, char seat, SeatType type, SeatClass cabin) {
		this.name = (row + 1) + "" + seat;
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
		if(this.passenger == null)
			return name;
		return name + " " + passenger.getName();
	}
}
