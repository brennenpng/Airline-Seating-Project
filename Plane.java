//Mitali Chowdhury
import java.util.ArrayList;

public class Plane {
	private Seat[][] firstClass = new Seat[3][4]; //first class section 
	private Seat[][] economyClass = new Seat[22][6]; //economy section
	
	public Plane(ArrayList<Group> groups) {
		//initialize all seats in plane
		for(int i = 0; i < firstClass.length; i++) {
			firstClass[i][0] = new Seat(i, 'A', SeatType.WIN, SeatClass.FIRST);
			firstClass[i][1] = new Seat(i, 'C', SeatType.AIS, SeatClass.FIRST);
			firstClass[i][2] = new Seat(i, 'D', SeatType.AIS, SeatClass.FIRST);
			firstClass[i][3] = new Seat(i, 'F', SeatType.WIN, SeatClass.FIRST);
		}
		
		for(int i = 0; i < economyClass.length; i++) {
			economyClass[i][0] = new Seat(i, 'A', SeatType.WIN, SeatClass.ECON);
			economyClass[i][1] = new Seat(i, 'B', SeatType.CEN, SeatClass.ECON);
			economyClass[i][2] = new Seat(i, 'C', SeatType.AIS, SeatClass.ECON);
			economyClass[i][3] = new Seat(i, 'D', SeatType.AIS, SeatClass.ECON);
			economyClass[i][4] = new Seat(i, 'E', SeatType.CEN, SeatClass.ECON);
			economyClass[i][5] = new Seat(i, 'F', SeatType.WIN, SeatClass.ECON);
		}
		
		//fill seats
		getSeats(groups);
	}
	
	public void getSeats(ArrayList<Group> groups) {
		for(int i = 0; i < groups.size(); i++) { 
			int row = 0, seat = 0; //keeping track
			//check if first class
			if(groups.get(i).getSeatClass() == SeatClass.FIRST) {
				if(groups.get(i).getGroupSize() == 1) {
					//if single passenger, find an empty seat matching preference
					while(firstClass[row][seat].getPassenger() != null || firstClass[row][seat].getSeatType() != groups.get(i).getPassengerAt(0).getSeatType()) {
						if(seat < 3)
							seat++;
						else {
							seat = 0;
							row++;
						}
					}
					firstClass[row][seat].setPassenger(groups.get(i).getPassengerAt(0));
				} else {
					//if group, check if group can fit in the row
					while(!(seat + groups.get(i).getGroupSize() < 4) || firstClass[row][seat].getPassenger() != null) {
						if(seat < 3)
							seat++;
						else {
							seat = 0;
							row++;
						}
					}
					
					for(int j = 0; j < groups.get(i).getGroupSize(); j++) {
						//find a seat for each passenger
						int x = 0;
						while(firstClass[row][seat + x].getSeatType() != groups.get(i).getPassengerAt(j).getSeatType() || firstClass[row][seat + x].getPassenger() != null)
							x++;
						//assign passenger to seat
						firstClass[row][seat + x].setPassenger(groups.get(i).getPassengerAt(j));
					}
				}
			} else {
				//check if group can fit in the row
				if(groups.get(i).getGroupSize() == 1) {
					while(economyClass[row][seat].getPassenger() != null || economyClass[row][seat].getSeatType() != groups.get(i).getPassengerAt(0).getSeatType()) {
						if(seat < 5)
							seat++;
						else {
							seat = 0;
							row++;
						}
					}
					economyClass[row][seat].setPassenger(groups.get(i).getPassengerAt(0));
				} else {
					//check if group can fit in the row
					while(!(seat + groups.get(i).getGroupSize() < 6) || economyClass[row][seat].getPassenger() != null) {
						if(seat < 5)
							seat++;
						else {
							seat = 0;
							row++;
						}
					}
					
					for(int j = 0; j < groups.get(i).getGroupSize(); j++) {
						//find a seat for each passenger
						int x = 0;
						while(economyClass[row][seat + x].getSeatType() != groups.get(i).getPassengerAt(j).getSeatType() || economyClass[row][seat + x].getPassenger() != null) {
							x++;
						}
						//assign passenger to seat
						economyClass[row][seat + x].setPassenger(groups.get(i).getPassengerAt(j));
					}
				}
			}
		}
	}
	
	public void printPlane() {
		System.out.println("First Class");
		for(int i = 0; i < firstClass.length; i++) {
			for(int j = 0; j < firstClass[i].length; j++) {
				System.out.print(firstClass[i][j]);
			}
		}
		
		System.out.println("\nEconomy Class");
		for(int i = 0; i < economyClass.length; i++) {
			for(int j = 0; j < economyClass[i].length; j++) {
				System.out.print(economyClass[i][j]);
			}
			System.out.println();
		}
	}
}
