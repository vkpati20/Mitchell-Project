import java.util.List;
import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
	    VehicleDB vehicleDB = new VehicleDB();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

	
		int choice = 0;
		do {
			System.out.println("Please select from the following options: ");
			System.out.println("1: Create a new vehicle");
			System.out.println("2: Update existing vehicle");
			System.out.println("3: Delete existing vehicle");
			System.out.println("4: View a specific vehicle");
			System.out.println("5: View all vehicles");
			System.out.println("6: Exit");
			System.out.print("Choice: ");
			choice = input.nextInt();
			System.out.println("");
			
			
			switch(choice) {
			case 1:
				Create(vehicleDB);
				break;
			case 2:
				Update(vehicleDB);
				break;
			case 3: 
				Delete(vehicleDB);
				break;
			case 4: 
				Get(vehicleDB);
				break;
			case 5: 
				Getall(vehicleDB);
				break;
			case 6:
				break;
			default:
				System.out.println("Please select from 6 options");
				
			}
			System.out.println("");
			System.out.println("");

			
		}while(choice!=6);

	}
	
	public static void Create(VehicleDB vehicle) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int year = -1;
		String make="", model=""; 
		
		System.out.print("Enter Year: ");
		year = input.nextInt();
		
		input.nextLine();
		System.out.print("Enter Make: ");
		make = input.nextLine();
		
		System.out.print("Enter Model: ");
		model = input.nextLine();
		
		vehicle.Create(year, make, model);
		
		
		
	}
	public static void Update(VehicleDB vehicleDB) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int id = -1, year=-1;
		String make="", model="";
		
		System.out.print("Enter vehicle id: ");
		id = input.nextInt();
		
		String change="";

		
		input.nextLine();
		do {
			System.out.print("Change Year? (y/n)? ");
			change = input.nextLine();
		}while( !(change.equals("y") || change.equals("n")));
		
		if(change.equals("y") || change.equals("yes")) {
			System.out.print("Enter Year: ");
			year = input.nextInt();
		}
		
		input.nextLine();
		do {
			System.out.print("Change Make? (y/n)? ");
			change = input.nextLine();
		}while( !(change.equals("y") || change.equals("n")));
		
		if(change.equals("y") || change.equals("yes")) {
			System.out.print("Enter Year: ");
			make = input.nextLine();

		}
		
		
		do {
			System.out.print("Change Model? (y/n)? ");
			change = input.nextLine();
		}while( !(change.equals("y") || change.equals("n")));
		
		if(change.equals("y") || change.equals("yes")) {
			System.out.print("Enter Year: ");
			model = input.nextLine();

		}
		vehicleDB.Update(id, year, make, model);
		
	}
	
	
	public static void Get(VehicleDB vehicleDB) {
		
	}

	public static void Getall(VehicleDB vehicleDB) {
		List<Vehicle> vehicles = vehicleDB.Get();
		for(Vehicle vehicle: vehicles) {
			System.out.println(
					"["
					+ "id: " + vehicle.getId() 
					+ ",\tYear: " + vehicle.getYear() 
					+ ",\tMake: " + vehicle.getMake() 
					+ ",\tModel: " + vehicle.getModel() 
					+ "]"
					);
		}
	}
	
	public static void Delete(VehicleDB vehicleDB) {
		
	}
}
