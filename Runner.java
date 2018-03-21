import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("PassengerData.txt"));
		ArrayList<Group> groups = new ArrayList<Group>();
		while(scan.hasNext()) {
			groups.add(new Group(scan));
		}
		Plane p = new Plane(groups);
		p.printPlane();
	}
}
