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
		int rowF = 0, seatF = 0, rowE = 0, seatE = 0; //keeping track
		for(int i = 0; i < groups.size(); i++) { 
			//check if first class
			if(groups.get(i).getSeatClass() == SeatClass.FIRST) {
				//check if group can fit in the row
				if(!(seatF + groups.get(i).getGroupSize() < 4)) {
					rowF++;
					seatF = 0;
				}
				for(int j = 0; j < groups.get(i).getGroupSize(); j++) {
					//find a seat for each passenger
					//assign passenger to seat
					firstClass[rowF][getSeat(SeatClass.FIRST, rowF, seatF, groups.get(i).getPassengerAt(j).getSeatType())].setPassenger(groups.get(i).getPassengerAt(j));
				}
				//move placeholder values
				while(firstClass[rowF][seatF].getPassenger() != null) {
					if(seatF < 3)
						seatF++;
					else {
						seatF = 0;
						rowF++;
					}
				}
			} else {
				//check if group can fit in the row
				if(!(seatE + groups.get(i).getGroupSize() < 6)) {
					rowE++;
					seatE = 0;
				}
				for(int j = 0; j < groups.get(i).getGroupSize(); j++) {
					//find a seat for each passenger
					//assign passenger to seat
					economyClass[rowE][getSeat(SeatClass.ECON, rowE, seatE, groups.get(i).getPassengerAt(j).getSeatType())].setPassenger(groups.get(i).getPassengerAt(j));
				}
				while(economyClass[rowE][seatE].getPassenger() != null) {
					if(seatE < 5)
						seatE++;
					else {
						seatE = 0;
						rowE++;
					}
				}
			}
		}
	}
	
	public int getSeat(SeatClass c, int row, int firstSeat, SeatType type) {
		int x = 0;
		//check for class
		if(c == SeatClass.FIRST) {
			//find empty matching seat
			while(firstClass[row][firstSeat + x].getSeatType() != type || firstClass[row][firstSeat + x].getPassenger() != (null))
				x++;
		} else {
			//find empty matching seat
			while(economyClass[row][firstSeat + x].getSeatType() != type || economyClass[row][firstSeat + x].getPassenger() != (null))
				x++;
		}
		return firstSeat + x;
	}
	
	public void printPlane() {
		System.out.println("First Class");
		for(int i = 0; i < firstClass.length; i++) {
			for(int j = 0; j < firstClass[i].length; j++) {
				System.out.println(firstClass[i][j]);
			}
			System.out.println();
		}
		System.out.println("Economy Class");
		for(int i = 0; i < economyClass.length; i++) {
			for(int j = 0; j < economyClass[i].length; j++) {
				System.out.println(economyClass[i][j]);
			}
			System.out.println();
		}
	}
}
