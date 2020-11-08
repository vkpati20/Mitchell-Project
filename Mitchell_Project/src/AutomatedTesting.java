import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomatedTesting {
	private VehicleDB vehicleTestDB = new VehicleDB();
	
	@BeforeEach
	public void setup() {
		vehicleTestDB = new VehicleDB();
		vehicleTestDB.Create(2002, "Nissian", "Altima");
		vehicleTestDB.Create(2012, "Honda", "Civic");
		vehicleTestDB.Create(2016, "Toyota", "Corolla");
	}
	
	@Test
	public void testCreate() {
		int year = 2019;
		String Make = "BMW";
		String Model = "i8";
		Vehicle testVehicle = vehicleTestDB.Create(year, Make, Model);
		int size = vehicleTestDB.Size();
		
		/*
		 * vehicleTestDB.Create() creates a Vehicle object, adds to the Vehicle ArrayList in VehicleDB and 
		 * returns the current Vehicle object that is created.
		 * 
		 * Below test is checking whether the last element in ArrayList is the  newly created vehicle object
		 */
		assertEquals(vehicleTestDB.Get().get(size-1), testVehicle);
	}
	
	@Test
	public void testUpdate() {
		int newYear = 2021;
		String Make = "";
		String Model = "";
		int size = vehicleTestDB.Size();
		
			
		
		int id = vehicleTestDB.Get().get(size-1).getId();
		Vehicle testVehicle = vehicleTestDB.Update(vehicleTestDB.Get().get(size-1).getId(), newYear, Make, Model);
		
		Vehicle dummy = new Vehicle();
		dummy.setId(vehicleTestDB.Get().get(size-1).getId());
		dummy.setYear(newYear);
		dummy.setMake("Toyota");
		dummy.setModel("Corolla");
		System.out.println();
		assertEquals(dummy.getId(), testVehicle.getId());
		assertEquals(dummy.getYear(), testVehicle.getYear());
		assertEquals(dummy.getMake(), testVehicle.getMake());
		assertEquals(dummy.getModel(), testVehicle.getModel());
	}
	
	

}
