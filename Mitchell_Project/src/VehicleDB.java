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
	
	
	public Vehicle Create(int year, String Make, String Model) {
		Vehicle v = new Vehicle(year, Make, Model);
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
	
	
}
