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
		this.setId(Id);
		this.setYear(Year);
		this.setMake(Make);
		this.setModel(Model);
	}
	
	
	//Id-------------
	public int getId() {
		return this.Id;
	}
	public void setId(int Id) {
		if(Id>=0)  
			this.Id = Id; 
		else 
			throw new IllegalArgumentException("Invalid Action");
	}
	
	//Year------------
	public int getYear() {
		return this.Year;
	}
	
	public void setYear(int Year) {
		if(Year>=1950 && Year<=2050)  
			this.Year = Year; 
		else 
			throw new IllegalArgumentException("Invalid Action");	
	}
	
	//Make------------
	public String getMake() {
		return this.Make;
	}
	public void setMake(String Make) {
		if(Make!=null && Make.length()>0)
			this.Make = Make;
		else
			throw new IllegalArgumentException("Invalid Action");
	}
	
	//Model-------------
	public String getModel() {
		return this.Model;
	}
	public void setModel(String Model) {
		if(Model!=null && Model.length()>0)
			this.Model = Model;
		else
			throw new IllegalArgumentException("Invalid Action");
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
