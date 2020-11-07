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
		this.Year = -1;
		this.Make= Make;
		this.Model= Model;
	}
	
	
	//Id-------------
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	//Year------------
	public int getYear() {
		return Year;
	}
	public void setYear(int Year) {
		this.Year = Year;
	}
	
	//Make------------
	public String getMake() {
		return Make;
	}
	public void setMake(String Make) {
		this.Make = Make;
	}
	
	//Model-------------
	public String getModel() {
		return Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}
	
	
	
	
}
