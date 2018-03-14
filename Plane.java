import java.util.ArrayList;

public class Plane {
	Seat[][] firstClass = new Seat[3][4];
	Seat[][] economyClass = new Seat[22][6];
	
	public Plane(ArrayList<Group> groups) {
		for(int i = 0; i < groups.size(); i++) {
			if(groups.get(i).getSeatClass() == SeatClass.FIRST) {
				firstClass
			} else {
				economyClass
			}
		}
	}
	
	public void printPlane() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(firstClass[i][j] + "\t\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < 22; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(economyClass[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
