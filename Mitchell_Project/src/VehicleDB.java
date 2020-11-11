import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class VehicleDB {
	//List to store all instances of Vehicle class
	static List<Vehicle> allVehicles;
	//stores all id's
    static HashSet<Integer> allIds;

	/*
	 * Default Constructor 
	 * 
	 * Initializes a new instance of the class VehicleDB and allVehicles list.
	 */
	public VehicleDB() {
		allVehicles = new ArrayList<>();
		allIds = new HashSet<>();
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
		//If an existence Vehicle with matching id exists, then return null
		if(allIds.contains(Id))
			return null;
		
		allIds.add(Id);
		Vehicle v = new Vehicle(Id,Year, Make, Model);
		allVehicles.add(v);
		return v;

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
		
		//Get(id) returns the Vehicle instance with matching id
		//if the vehicle does not exist, then Get returns null
		Vehicle vehicle = Get(id);
		if(vehicle!=null) {
			
			if(year!= -1)
				vehicle.setYear(year);
			
			if(make.length()!=0)
				vehicle.setMake(make);
			
			if(model.length()!=0)
				vehicle.setModel(model);
		}
		
		return vehicle;
	}
	
	/**
	 * Delete method removes a Vehicle instance in allVehicles based on id field.
	 * @param id: int
	 * @return
	 */
	public int Delete(int id) {
		if(!allIds.contains(id))
			return -1;
		
		//pos gets the index of list where the vehicle object with matching id is located.
		int pos = getPosition(id);
		
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
		if(!allIds.contains(id))
			return null;
		
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
	 * @param s1: String
	 * @return
	 */
	public List<Vehicle> Get(String s1) {
		List<Vehicle> Vehicles = new ArrayList<>();
		boolean isMake = false;
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getMake().equals(s1)) {
				isMake = true;
				Vehicles.add(allVehicles.get(i));
			}
		}
		if(isMake == false)
		{
			for(int i = 0; i < allVehicles.size(); i++)
			{
				if(allVehicles.get(i).getModel().equals(s1)) {
					Vehicles.add(allVehicles.get(i));
				}
			}
		}
		
		return Vehicles;
	}

	/**
	 * Get method takes 2 strings: Make and Model (in that order)
	 * It calls Get(String) method to get all the Vehicle instances with matching Make
	 * Then it checks each vehicle model in this list and deletes the ones who's model does not 
	 * match with string s2
	 * 
	 * @param s1: String - Make
	 * @param s2: String - Model
	 * @return
	 */
	public List<Vehicle> Get(String s1, String s2){
		List<Vehicle> Vehicles = this.Get(s1);
	    Iterator<Vehicle> itr = Vehicles.iterator();
	    while (itr.hasNext()) {
	    	if(!itr.next().getModel().equals(s2))
	    		itr.remove();
	    }
		return Vehicles;
	}
	
	/**
	 * getPosition returns the index of an Vehicle instance with matching id
	 * @param id: int
	 * @return
	 */
	private int getPosition(int id) {
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getId() == id) 
				return i;
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
