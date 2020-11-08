import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Vehicle {
	private int Id;
	private int Year;
	private String Make;
	private String Model;
	
	private static AtomicInteger ai = new AtomicInteger(10);

	public Vehicle() {
		
		this.Id = ai.incrementAndGet();
		this.Year = -1;
		this.Make="Generic";
		this.Model="Generic";
	}
	
	public Vehicle(int Year, String Make, String Model) {
		
		this.Id = ai.incrementAndGet();
		this.Year = Year;
		this.Make= Make;
		this.Model= Model;
	}
	
	
	//Id-------------
	public int getId() {
		return this.Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	//Year------------
	public int getYear() {
		return this.Year;
	}
	
	public void setYear(int Year) {
		this.Year = Year;
	}
	
	//Make------------
	public String getMake() {
		return this.Make;
	}
	public void setMake(String Make) {
		this.Make = Make;
	}
	
	//Model-------------
	public String getModel() {
		return this.Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}
	
	
	public String toString() {
		return(
				"["
				+ "id: " + this.getId() 
				+ ",\tYear: " + this.getYear() 
				+ ",\tMake: " + this.getMake() 
				+ ",\tModel: " + this.getModel() 
				+ "]"
				);
	}
	
	
}
