import java.util.ArrayList;
import java.util.List;


public class VehicleDB {
	//List to store all instances of Vehicle class
	static List<Vehicle> allVehicles;
	
	/*
	 * Default Constructor 
	 * 
	 * Initializes a new instance of the class VehicleDB and allVehicles list.
	 */
	public VehicleDB() {
		allVehicles = new ArrayList<>();
	}
	
	/**
	 * Create method creates a new instance of class Vehicles with the given
	 * fields and stores this new instance in allVehicles() list.
	 * 
	 * @param Id: int
	 * @param Year: int
	 * @param Make: String
	 * @param Model: String
	 * @return
	 */
	public Vehicle Create(int Id,int Year, String Make, String Model) {
		Vehicle v = new Vehicle(Id,Year, Make, Model);
		allVehicles.add(v);
		return v;

	}
	
	/**
	 * Delete method removes a Vehicle instance in allVehicles based on id field.
	 * @param id: int
	 * @return
	 */
	public int Delete(int id) {
		//pos gets the index of list where the vehicle object with matching id is located.
		int pos = getPosition(id);
		
		//if pos == -1, then Vehicle with this id does not exist. 
		if(pos!=-1)
			allVehicles.remove(pos);
		
		return pos;
	}
	
	/**
	 * Get method returns all the Vehicle objects in allVehicles list
	 * @return
	 */
	public List<Vehicle> Get() {
		return allVehicles;
	}
	
	/**
	 * Get method returns the Vehicle object with matching id 
	 * @param id: int
	 * @return
	 */
	public Vehicle Get(int id) {
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getId() == id)
				return allVehicles.get(i);
		}
		
		return null;
	}
	
	

	/**
	 * Get method takes a string (Make or Model name)
	 * It searches the Make field of all Vehicle objects and returns any matching Vehicle objects
	 * 
	 * If it's not a Make field, then it searches Model field of all Vehicle objects and returns 
	 * any matching Vehicle objects
	 * @param temp: String
	 * @return
	 */
	public List<Vehicle> Get(String temp) {
		List<Vehicle> Vehicles = new ArrayList<>();
		boolean isMake = false;
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getMake().equals(temp)) {
				isMake = true;
				Vehicles.add(allVehicles.get(i));
			}
		}
		if(isMake == false)
		{
			for(int i = 0; i < allVehicles.size(); i++)
			{
				if(allVehicles.get(i).getModel().equals(temp)) {
					Vehicles.add(allVehicles.get(i));
				}
			}
		}
		
		return Vehicles;
	}
	
	
	/**
	 * Update method updates an existing Vehicle instance with matching id
	 * 
	 * @param id: int
	 * @param year: int
	 * @param make: String
	 * @param model: String
	 * @return
	 */
	public Vehicle Update(int id, int year, String make, String model) {
		Vehicle vehicle = Get(id);
		if(year!= -1)
			vehicle.setYear(year);
		
		if(make.length()!=0)
			vehicle.setMake(make);
		
		if(model.length()!=0)
			vehicle.setModel(model);
		
		return vehicle;
		
	}

	/**
	 * getPosition returns the index of an Vehicle instance with matching id
	 * @param id: int
	 * @return
	 */
	private int getPosition(int id) {
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getId() == id) return i;
		}
		return -1;
	}
	
	/**
	 * Returns the size of the allVehicles list
	 * @return
	 */
	public int Size() {
		return allVehicles.size();
	}
	
	/**
	 * Returns allVehicles list
	 * @return
	 */
	public List<Vehicle> AllVehicles(){
		return allVehicles;
	}
}
