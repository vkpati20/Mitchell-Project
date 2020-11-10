import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Vehicle {
	private int Id;
	private int Year;
	private String Make;
	private String Model;
	
	public Vehicle() {
		
		this.Id = -1;
		this.Year = -1;
		this.Make="Generic";
		this.Model="Generic";
	}
	
	public Vehicle(int Id, int Year, String Make, String Model) {
		if(
			(Make!=null && Make.length()>0)
			&& (Model!=null && Model.length()>0)
			&& (Year>=1950 && Year<=2050)
			) {
		this.Id = Id;
		this.Year = Year;
		this.Make= Make;
		this.Model= Model;
		}
		else {
		    throw new IllegalArgumentException("Invalid Vehicle Creation");
		}
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
