import java.util.ArrayList;
import java.util.Scanner;

public class Group {
	
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	/*
	 * reads group size
	 * adds this amount of passengers to the arraylist
	 */
	public Group(Scanner inFile) {
		int groupSize = inFile.nextInt();
		for(int i=0; i<groupSize; i++) {
			passengers.add(new Passenger(inFile));
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	/* getter for a passenger at a given index */
	public Passenger getPassengerAt(int index) {
		return passengers.get(index);
	}
	
	/* getter for number of passengers in this group */
	public int getGroupSize() {
		return passengers.size();
	}
	
	/* getter for seat class of this group */
	public SeatClass getSeatClass() {
		return passengers.get(0).getSeatClass();
	}
	
	public String toString() {
		String s = "\n";
		for(Passenger p : passengers) {
			s += "- " + p.toString() + " -";
		}
		return s;
	}

}
