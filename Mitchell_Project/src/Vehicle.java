/*
 * @author Veerendranath Korrapati
 */

public class Vehicle {
	private int Id;
	private int Year;
	private String Make;
	private String Model;
	
	/*
	 * Default Constructor 
	 */
	public Vehicle() {
		
		this.Id = -1;
		this.Year = -1;
		this.Make="Generic";
		this.Model="Generic";
	}
	
	/**
	 * Constructor
	 * 
	 * Initializes a new instance of the class Vehicle with the following fields
	 * @param Id: int
	 * @param Year: String
	 * @param Make: String
	 * @param Model: String
	 */
	public Vehicle(int Id, int Year, String Make, String Model) {
		this.setId(Id);
		this.setYear(Year);
		this.setMake(Make);
		this.setModel(Model);
	}
	
	/*
	 * Defining Getters and Setters for fields: Id, Year, Make, Model
	 */
	public int getId() {
		return this.Id;
	}
	public void setId(int Id) {
		if(Id>=0)  
			this.Id = Id; 
		else 
			throw new IllegalArgumentException("Invalid Action");
	}
	
	public int getYear() {
		return this.Year;
	}
	public void setYear(int Year) {
		if(Year>=1950 && Year<=2050)  
			this.Year = Year; 
		else 
			throw new IllegalArgumentException("Invalid Action");	
	}
	
	public String getMake() {
		return this.Make;
	}
	public void setMake(String Make) {
		if(Make!=null && Make.length()>0)
			this.Make = Make;
		else
			throw new IllegalArgumentException("Invalid Action");
	}
	
	public String getModel() {
		return this.Model;
	}
	public void setModel(String Model) {
		if(Model!=null && Model.length()>0)
			this.Model = Model;
		else
			throw new IllegalArgumentException("Invalid Action");
	}
	
	//Returns the values of fields in current object (used for testing purpose in VehicleTest.java)
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
