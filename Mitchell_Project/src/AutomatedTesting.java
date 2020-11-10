import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomatedTesting {
	private VehicleDB vehicleTestDB = new VehicleDB();
		
	@BeforeEach
	public void setup() {
		vehicleTestDB = new VehicleDB();
		vehicleTestDB.Create(1, 2018, "BMW", "Series 7");
		vehicleTestDB.Create(2, 2012, "Audi", "Sedan");
		vehicleTestDB.Create(3, 2016, "Toyota", "Corolla");
	}
	
	@Test
	public void testCreate() {
		int id = 4;
		int year = 2019;
		String Make = "BMW";
		String Model = "i8";
		Vehicle testVehicle = vehicleTestDB.Create(id,year, Make, Model);
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
	
	@Test
	public void testDelete() {
		int delete_id = 1;
		int exist_id = 3;
		vehicleTestDB.Delete(delete_id);
		
		assertEquals(false, vehicleTestDB.VehicleExist(delete_id));
		assertEquals(true,vehicleTestDB.VehicleExist(exist_id));
	}
	
	@Test
	public void testGetbyID() {
		int id = 2;
		Vehicle v = vehicleTestDB.Get(2);
		assertEquals(2, v.getId());
		assertEquals(2012, v.getYear());
		assertEquals("Audi", v.getMake());
		assertEquals("Sedan", v.getModel());
	}
	
	
	@Test
	public void testGetbyValue() {
		String text = "BMW";
		//Creating dummy 
		vehicleTestDB.Create(4, 2015, "BMW", "Sedan");
		vehicleTestDB.Create(5, 2012, "BMW", "Series 4");

		
		//Test 1: Testing Make field
		List<Vehicle> dummyList1 = new ArrayList<>();
		dummyList1.add(new Vehicle(1, 2018, "BMW", "Series 7"));
		dummyList1.add(new Vehicle(4, 2015, "BMW", "Sedan"));
		dummyList1.add(new Vehicle(5, 2012, "BMW", "Series 4"));
		
		List<Vehicle> makeTestList = vehicleTestDB.Get(text);
		
		
		for(int i = 0; i < 3; i++) {
			assertEquals(dummyList1.get(i).getId(), makeTestList.get(i).getId());
			assertEquals(dummyList1.get(i).getYear(), makeTestList.get(i).getYear());
			assertEquals(dummyList1.get(i).getMake(), makeTestList.get(i).getMake());
			assertEquals(dummyList1.get(i).getModel(), makeTestList.get(i).getModel());
		}
		
		
		//Test 2: Testing Model field
		text = "Sedan";
		List<Vehicle> modelTestList = vehicleTestDB.Get(text);
		
		List<Vehicle> dummyList2 = new ArrayList<>();
		dummyList2.add(new Vehicle(2, 2012, "Audi", "Sedan"));
		dummyList2.add(new Vehicle(4, 2015, "BMW", "Sedan"));
	
		for(int i = 0; i < 2; i++) {
			assertEquals(dummyList2.get(i).getId(), modelTestList.get(i).getId());
			assertEquals(dummyList2.get(i).getYear(), modelTestList.get(i).getYear());
			assertEquals(dummyList2.get(i).getMake(), modelTestList.get(i).getMake());
			assertEquals(dummyList2.get(i).getModel(), modelTestList.get(i).getModel());
		}
	}
	
	
	@Test
	public void testException() {
		int id = 4;
		int year1 = 2019;
		String Make = "";
		String Model = "i8";
	    
	    assertThrows(IllegalArgumentException.class, () -> vehicleTestDB.Create(id,year1, Make, Model));

	    //I can't use id 4 for the below test cases because in the previous step, Vehicle with object id 4 is not created
	    int year2 = 1900;
	    assertThrows(IllegalArgumentException.class, () -> vehicleTestDB.Update(1,year2, Make, Model));

		String Make2 = null;
	    assertThrows(IllegalArgumentException.class, () -> vehicleTestDB.Update(1,year2, Make2, Model));

	    String Model3 = null;
	    assertThrows(IllegalArgumentException.class, () -> vehicleTestDB.Update(1,year2, Make2, Model3));

	}
	
	
	
	

}
