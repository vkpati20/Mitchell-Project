import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    Vehicle vehicle = new Vehicle();

	
		int choice = 0;
		do {
			System.out.println("Please select from the following options: ");
			System.out.println("1: Create a new vehicle");
			System.out.println("2: Update existing vehicle");
			System.out.println("3: Delete existing vehicle");
			System.out.println("4: View a specific vehicle");
			System.out.println("5: View all vehicles");
			System.out.println("6: Exit");
			choice = input.nextInt();
			
			
			switch(choice) {
			case 1:
				Create();
				break;
			case 2:
				Update();
				break;
			case 3: 
				Delete();
				break;
			case 4: 
				Get();
				break;
			case 5: 
				Getall();
				break;
			case 6:
				break;
			default:
				System.out.println("Please select from 6 options");
				
			}
			
			
		}while(choice!=6);

	}
	
	public static void Create() {
		
	}
	public static void Update() {
		
	}
	
	public static void Get() {
		
	}
	
	public static void Getall() {
		
	}
	
	public static void Delete() {
		
	}
}
