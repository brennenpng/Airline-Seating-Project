//Mitali Chowdhury
public class Seat {
	SeatType type; //Window, Aisle, or Center
	SeatClass cabin; //First or Economy
	String name; //Row # and Spot
	Passenger passenger; //Who is sitting here
	
	public Seat(int row, char seat, SeatType type, SeatClass cabin) {
		//sets seat number based on class
		if(cabin == SeatClass.FIRST)
			this.name = (row + 1) + "" + seat;
		else
			this.name = (row + 6) + "" + seat;
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
			return "";
		return passenger.getName() + "\tSeat " + this.name + "\n";
	}
}
