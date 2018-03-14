import java.util.ArrayList;
import java.util.Scanner;

public class Group {
	
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	public Group(Scanner inFile) {
		int groupSize = inFile.nextInt();
		for(int i=0; i<groupSize; i++) {
			passengers.add(new Passenger(inFile));
		}
	}
	
	public Passenger getPassengerAt(int index) {
		return passengers.get(index);
	}
	
	public int getGroupSize() {
		return passengers.size();
	}
	
	public SeatClass getSeatClass() {
		return passengers.get(0).getSeatClass();
	}
	
	public void printGroup() {
		for(Passenger p : passengers) {
			System.out.println(p);
		}
	}
	
	public String toString() {
		String s = "\n";
		for(Passenger p : passengers) {
			s += "- " + p.toString() + " -";
		}
		return s;
	}

}
