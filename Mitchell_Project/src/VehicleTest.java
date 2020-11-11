import java.util.List;
import java.util.Scanner;


/**
 * This is User driven test. This perpose of this test is for me to manually test a functionality and combination of functionalities 
 * @author Veerendranath Korrapait
 */
public class VehicleTest {
	public static void main(String[] args) {
	    VehicleDB vehicleDB = new VehicleDB();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("hello".contains("h"));
		int choice = 0;
		do {
			System.out.println("Please select from the following options: ");
			System.out.println("1: Create a new vehicle");
			System.out.println("2: Update existing vehicle");
			System.out.println("3: Delete existing vehicle");
			System.out.println("4: View a specific vehicle by id");
			System.out.println("5: View a specific vehicle by Make or Model");
			System.out.println("6: View a specific vehicle by Make and Model");
			System.out.println("7: View all vehicles");
			System.out.println("8: Exit");
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
				GetbyID(vehicleDB);
				break;
			case 5:
				GetbyValue(vehicleDB);
				break;
			case 6:
				GetbyMakeAndModel(vehicleDB);
				break;
			case 7: 
				Getall(vehicleDB);
				break;
			case 8:
				break;
			default:
				System.out.println("Please select from 6 options");
				
			}
			System.out.println("");
			System.out.println("");

			
		}while(choice!=8);
	}
	
	private static void GetbyMakeAndModel(VehicleDB vehicleDB) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter make: ");
		String make = input.nextLine();
		System.out.print("Enter make: ");
		String model = input.nextLine();
		List<Vehicle> vehicles = vehicleDB.Get(make, model);
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

	private static void GetbyValue(VehicleDB vehicleDB) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter identification: ");
		String temp = input.nextLine();
		
		List<Vehicle> vehicles = vehicleDB.Get(temp);
		
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

	public static void Create(VehicleDB vehicle) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int id = -1, year = -1;
		String make="", model=""; 
		
		System.out.print("Enter ID: ");
		id = input.nextInt();
		
		System.out.print("Enter Year: ");
		year = input.nextInt();
		
		input.nextLine();
		System.out.print("Enter Make: ");
		make = input.nextLine();
		
		System.out.print("Enter Model: ");
		model = input.nextLine();
		
		try {
		vehicle.Create(id, year, make, model);
		}
		catch(IllegalArgumentException e) {
			System.out.println("Exception!!");
		}
		
		
		
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
			System.out.print("Enter Make: ");
			make = input.nextLine();

		}
		
		
		do {
			System.out.print("Change Model? (y/n)? ");
			change = input.nextLine();
		}while( !(change.equals("y") || change.equals("n")));
		
		if(change.equals("y") || change.equals("yes")) {
			System.out.print("Enter Model: ");
			model = input.nextLine();

		}
		vehicleDB.Update(id, year, make, model);
		
	}
	
	
	public static void GetbyID(VehicleDB vehicleDB) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = input.nextInt();
		
		Vehicle vehicle = vehicleDB.Get(id);
		
		System.out.println(
				"["
				+ "id: " + vehicle.getId() 
				+ ",\tYear: " + vehicle.getYear() 
				+ ",\tMake: " + vehicle.getMake() 
				+ ",\tModel: " + vehicle.getModel() 
				+ "]"
				);		
	}

	public static void Getall(VehicleDB vehicleDB) {
		List<Vehicle> vehicles = vehicleDB.Get();
		if(vehicles.size() == 0) {
			System.out.println("No Vehicle Objects created!");
			return;
		}
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
		Scanner input = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = input.nextInt();
		
		int temp = vehicleDB.Delete(id);
		
		if(temp == -1) System.out.println("No such Vehicle exist!");
	}
}
