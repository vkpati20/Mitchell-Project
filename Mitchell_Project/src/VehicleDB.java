import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * Comments
 * 
 * 		//I'm trying to store where this particular object is located in the array
		//so in Delete and Update, I don't have to traverse the objects. Instead, 
		//I can just go to that specific index by using HashMap which uses vehicle's id to map it to 
		//the index.
 */
public class VehicleDB {
	static List<Vehicle> allVehicles;
//	static HashMap<Integer, Integer> mapToVehicle;//to make delete and update operations faster
//	static int index;
	
	
	public VehicleDB() {
		allVehicles = new ArrayList<>();
	}
	
	
	public Vehicle Create(int id,int year, String Make, String Model) {
		Vehicle v = new Vehicle(id,year, Make, Model);
		allVehicles.add(v);
		return v;

	}
	
	public int Delete(int id) {
		int pos = getPosition(id);
		if(pos!=-1)
			allVehicles.remove(pos);
		return pos;
	}
	
	
	public List<Vehicle> Get() {
		return allVehicles;
	}
	
	
	public Vehicle Get(int id) {
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getId() == id)
				return allVehicles.get(i);
		}
		
		return null;
	}
	
	
	/*
	 * This method takes a string, a Make or Model name.
	 * It searches the Make field of all vehicles objects and returns the matching objects
	 * 
	 * If it's not a Make field, then it searches Model field of all vehicles objects 
	 * and returns the matching objects
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

	private int getPosition(int id) {
		for(int i = 0; i < allVehicles.size(); i++)
		{
			if(allVehicles.get(i).getId() == id) return i;
		}
		return -1;
	}
	
	public int Size() {
		return allVehicles.size();
	}
	
	public List<Vehicle> AllVehicles(){
		return allVehicles;
	}


	public boolean VehicleExist(int id) {
		int x = getPosition(id);
		
		return x==-1? false: true;
	}
	
	
	
}
