import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomatedTesting {
	private VehicleDB vehicleTestDB = new VehicleDB();
		
	/**
	 * setup method executes before each test case.
	 * It initializes vehicleTestDB with predefined values.
	 */
	@BeforeEach
	public void setup() {
		vehicleTestDB = new VehicleDB();
		vehicleTestDB.Create(1, 2018, "BMW", "Series 7");
		vehicleTestDB.Create(2, 2012, "Audi", "Sedan");
		vehicleTestDB.Create(3, 2016, "Toyota", "Corolla");
	}
	
	/**
	 * This method tests Create() method in VehicleDB
	 * Inside this method, testVehicle dummy instance of Vehicle is created.
	 * 
	 * Since the list field in VehicleDB class stores all the instances of Vehicle, 
	 * this newly created dummy instance should be the last element in that list.
	 * 
	 * assertEquals() performs this test.
	 */
	@Test
	public void testCreate() {
		int id = 4;
		int year = 2019;
		String Make = "BMW";
		String Model = "i8";
		Vehicle testVehicle = vehicleTestDB.Create(id,year, Make, Model);
		int size = vehicleTestDB.Size();
		
		/*
		 * vehicleTestDB.Create() creates a Vehicle i, adds to the list field in VehicleDB and 
		 * returns the current Vehicle object that was created.
		 * 
		 * Below test is checking whether the last element in list is the  newly created vehicle object
		 */
		assertEquals(vehicleTestDB.Get().get(size-1), testVehicle);
		
		//Creating a Vehicle instance with existing id
		testVehicle = vehicleTestDB.Create(1,year, Make, Model);
			//Vehicle with id = 1 exists
		assertEquals(null, testVehicle);
	}
	
	
	
	/**
	 * testUpdate() method tests Update() method in VehicleDB
	 * This method gets the id of last Vehicle Instance in allVehicles list from vehicleTestDB
	 * and updates the year field of that vehicle
	 * 
	 * Next, a dummy vehicle instance is created and the updated Vehicle instance should match with this 
	 * instance.
	 */
	@Test
	public void testUpdate() {
		int newYear = 2021;
		String Make = "";
		String Model = "";
		int size = vehicleTestDB.Size();
		
		
		int id = vehicleTestDB.Get().get(size-1).getId();
		Vehicle testVehicle = vehicleTestDB.Update(vehicleTestDB.Get().get(size-1).getId(), newYear, Make, Model);
		
		/*
		 * dummy instance is what the instance should look like after Update
		 */
		//Updating an existing Vehicle instance
		Vehicle dummy = new Vehicle();
		dummy.setId(id);
		dummy.setYear(newYear);
		dummy.setMake("Toyota");
		dummy.setModel("Corolla");
		System.out.println();
		assertEquals(dummy.getId(), testVehicle.getId());
		assertEquals(dummy.getYear(), testVehicle.getYear());
		assertEquals(dummy.getMake(), testVehicle.getMake());
		assertEquals(dummy.getModel(), testVehicle.getModel());
		
		//Updating a non-existing Vehicle instance
		testVehicle = vehicleTestDB.Update(10, newYear, Make, Model);
				//vehicle instance with id = 10 does not exist
		assertEquals(null, testVehicle);
	
	}
	
	/**
	 * testDelete() method tests Delete() method in VehicleDB
	 * This method deletes the Vehicle instance in VehicleDB with id of 1.
	 * Then it checks if that instance exists after deletion
	 */
	@Test
	public void testDelete() {
		int delete_id = 1;
		int exist_id = 3;
		vehicleTestDB.Delete(delete_id);
		
		//Vehicle with id = 1 should not exist, hence null
		assertEquals(null, vehicleTestDB.Get(delete_id));
		
		//Vehicle with id = 3 should exist, hence not null
		assertNotEquals(null, vehicleTestDB.Get(exist_id));
	}
	
	/**
	 * testGetbyID method tests Get(int) method in VehicleDB
	 * This method gets the Vehicle instance from VehicleDB with matching id
	 */
	@Test
	public void testGetbyID() {
		//vehicle with id 2 exists
		int id = 2;
		Vehicle testVehicle = vehicleTestDB.Get(id);
		assertEquals(2, testVehicle.getId());
		assertEquals(2012, testVehicle.getYear());
		assertEquals("Audi", testVehicle.getMake());
		assertEquals("Sedan", testVehicle.getModel());
		
		//vehicle with id 10 does not exists
		assertEquals(null, vehicleTestDB.Get(10));
	}
	
	/**
	 * testGetByValue method tests Get(String) method in VehicleDB
	 * This method gets Vehicle instances from Vehicle DB with matching Make or Model
	 */
	@Test
	public void testGetbyValue() {
		String text = "BMW";
		//Creating extra instances 
		vehicleTestDB.Create(4, 2015, "BMW", "Sedan");
		vehicleTestDB.Create(5, 2012, "BMW", "Series 4");

		
		//Test 1: Testing Make field
			//creating dummylist with expected outcome of Get(Make) method
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
			
			//creating dummylist with expected outcome of Get(Model) method
		List<Vehicle> dummyList2 = new ArrayList<>();
		dummyList2.add(new Vehicle(2, 2012, "Audi", "Sedan"));
		dummyList2.add(new Vehicle(4, 2015, "BMW", "Sedan"));
	
		
		List<Vehicle> modelTestList = vehicleTestDB.Get(text);

		for(int i = 0; i < 2; i++) {
			assertEquals(dummyList2.get(i).getId(), modelTestList.get(i).getId());
			assertEquals(dummyList2.get(i).getYear(), modelTestList.get(i).getYear());
			assertEquals(dummyList2.get(i).getMake(), modelTestList.get(i).getMake());
			assertEquals(dummyList2.get(i).getModel(), modelTestList.get(i).getModel());
		}
		
		//Test 3: Testing text that not match with with either fields
			//should return empty list
		text = "Rover";
		assertTrue(vehicleTestDB.Get(text).isEmpty());
	}
	
	/**
	 * testException method checks for exception cases such as providing null values for Make
	 * or Model and range for year.
	 */
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

	    String Model2 = null;
	    assertThrows(IllegalArgumentException.class, () -> vehicleTestDB.Update(1,year2, Make2, Model2));

	}
}
