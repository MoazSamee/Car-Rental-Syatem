import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import car.CompactCar;
import car.SUV;
import car.LuxuryCar;
import crms.CRMS; // Assuming CRMS is your CarManager class
import renter.Renter;
import static org.junit.jupiter.api.Assertions.*;

public class CarManagerTest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUp() {
        // You can add setup code here if necessary
    }

    @AfterEach
    public void tearDown() {
        // Reset System.in after each test
        System.setIn(originalSystemIn);
    }

    @Test
    public void testAddCarCompact() {
        CRMS carManager = new CRMS(); // Ensure that this is the right class you're testing

        // Simulating user input for adding a compact car
        String input = "1\nModelX\nBrandY\n2022\n500\n10\nAB123CD\nSunroof\n20000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set the input stream to our simulated input

        // Call the method to be tested
        carManager.addCar();  // This method should use the simulated input

        // Verify that the car was added successfully
        // Assuming you have a method `getCompactCars()` that returns the list of added cars
        assertEquals(1, carManager.getCompactCars().size(), "Car was not added properly.");
        
        CompactCar addedCar = carManager.getCompactCars().get(0);

        // Verify car properties
        assertEquals("ModelX", addedCar.getModel());
        assertEquals("BrandY", addedCar.getBrand());
        assertEquals(2022, addedCar.getYear());
        assertEquals(500, addedCar.getBaseRent());
        assertEquals(10, addedCar.getTravelCost());
        assertEquals("AB123CD", addedCar.getPlateNumber());
        assertEquals("Sunroof", addedCar.getFeature());
        assertEquals(20000, addedCar.getVehicleCost());
    }

    @Test
    public void testInvalidOption() {
        CRMS carManager = new CRMS(); // Use the correct class

        // Simulating invalid input for car type choice
        String input = "5\n";  // 5 is an invalid option as per your logic
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method
        carManager.addCar();  // This should handle invalid input gracefully

        // Verify that no car was added due to the invalid option
        assertEquals(0, carManager.getCompactCars().size(), "Invalid option should not add any car.");
    }
    
    @Test
    public void testRemoveCarCompactSuccess() {
        CRMS carManager = new CRMS();
        
        // Simulate adding a Compact Car first
        CompactCar compactCar = new CompactCar("C123", "BrandY", "ModelX", 2022, 500, 10, "AB123CD", "Sunroof", 20000);
        carManager.addCompactCar(compactCar);

        // Simulate input for removing the added compact car
        String input = "1\nC123\n";  // Select option 1 (Compact Car) and car ID "C123"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set simulated input

        // Call the method to remove the car
        carManager.removeCar();

        // Verify that the car was removed successfully
        assertEquals(0, carManager.getCompactCars().size(), "Car was not removed properly.");
    }

    @Test
    public void testRemoveCarCompactNotFound() {
        CRMS carManager = new CRMS();
        
        // Simulate adding a different Compact Car
        CompactCar compactCar = new CompactCar("C123", "BrandY", "ModelX", 2022, 500, 10, "AB123CD", "Sunroof", 20000);
        carManager.addCompactCar(compactCar);

        // Simulate input for trying to remove a car with a non-existent ID
        String input = "1\nC999\n";  // Select option 1 (Compact Car) but with non-existent car ID "C999"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set simulated input

        // Call the method to remove the car
        carManager.removeCar();

        // Verify that no car was removed, since car ID "C999" does not exist
        assertEquals(1, carManager.getCompactCars().size(), "No car should have been removed.");
    }

    @Test
    public void testRemoveCarInvalidOption() {
        CRMS carManager = new CRMS();

        // Simulate input for an invalid option (e.g., 4, which is out of range)
        String input = "4\n";  // Invalid option for car removal
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set simulated input

        // Capture the method's behavior when an invalid option is provided
        carManager.removeCar();

        // Check that no car was removed due to invalid option
        // Assuming no car was added in this test case
        assertEquals(0, carManager.getCompactCars().size(), "Invalid option should not remove any car.");
    }
    
    @Test
    public void testRentCompactCar() {
        CRMS carManager = new CRMS();

        // Simulate adding a Compact Car
        CompactCar compactCar = new CompactCar("C123", "BrandX", "ModelY", 2022, 500, 10, "AB123CD", "Sunroof", 20000);
        carManager.addCompactCar(compactCar);

        // Simulate user input for renting the car
        String input = "1\nC123\n111222333444\nJohn Doe\njohndoe@example.com\n1\n1234567890\n123 Main St\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method to rent a car
        carManager.rentCar();

        // Verify that the car was rented successfully
        assertTrue(carManager.getCompactCars().get(0).getRented(), "Car should be marked as rented.");
        assertEquals(1, carManager.getRenters().size(), "There should be one renter.");
        
        Renter renter = carManager.getRenters().get(0);
        assertEquals("John Doe", renter.getName(), "Renter name mismatch.");
        assertEquals("111222333444", renter.getRenterId(), "Renter ID mismatch.");
        assertEquals("Regular", renter.getRenterType(), "Renter type mismatch.");
    }

    @Test
    public void testRentSUVCarWithInsurance() {
        CRMS carManager = new CRMS();

        // Simulate adding an SUV
        SUV suv = new SUV("S456", "BrandZ", "ModelQ", 2021, 700, 15, "EF456GH", "4WD", 30000);
        carManager.addSUV(suv);

        // Simulate user input for renting the SUV with insurance
        String input = "2\nS456\n111222333444\nJohn Doe\njohndoe@example.com\n2\n1234567890\n123 Main St\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method to rent an SUV
        carManager.rentCar();

        // Verify that the SUV was rented successfully
        assertTrue(carManager.getSUVs().get(0).getRented(), "SUV should be marked as rented.");
        assertTrue(carManager.getSUVs().get(0).getInsured(), "SUV should be insured.");
        
        assertEquals(1, carManager.getRenters().size(), "There should be one renter.");
        Renter renter = carManager.getRenters().get(0);
        assertEquals("John Doe", renter.getName(), "Renter name mismatch.");
        assertEquals("111222333444", renter.getRenterId(), "Renter ID mismatch.");
        assertEquals("Frequent", renter.getRenterType(), "Renter type mismatch.");
    }

    @Test
    public void testRentLuxuryCarWithoutInsurance() {
        CRMS carManager = new CRMS();

        // Simulate adding a Luxury Car
        LuxuryCar luxuryCar = new LuxuryCar("L789", "BrandA", "ModelB", 2020, 1000, 20, "IJ789KL", "Leather Seats", 50000);
        carManager.addLuxuryCar(luxuryCar);

        // Simulate user input for renting the luxury car without insurance
        String input = "3\nL789\n555666777888\nJane Doe\njanedoe@example.com\n3\n0987654321\n456 Main St\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method to rent the luxury car
        carManager.rentCar();

        // Verify that the luxury car was rented successfully
        assertTrue(carManager.getLuxuryCars().get(0).getRented(), "Luxury car should be marked as rented.");
        assertFalse(carManager.getLuxuryCars().get(0).getInsured(), "Luxury car should not be insured.");
        
        assertEquals(1, carManager.getRenters().size(), "There should be one renter.");
        Renter renter = carManager.getRenters().get(0);
        assertEquals("Jane Doe", renter.getName(), "Renter name mismatch.");
        assertEquals("555666777888", renter.getRenterId(), "Renter ID mismatch.");
        assertEquals("Corporate", renter.getRenterType(), "Renter type mismatch.");
    }

    @Test
    public void testInvalidCarChoice() {
        CRMS carManager = new CRMS();

        // Simulate user input with an invalid car choice (e.g., option 4)
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the method to rent a car
        carManager.rentCar();

        // Verify that no car was rented due to invalid choice
        assertTrue(carManager.getCompactCars().isEmpty(), "No car should be rented for invalid choice.");
        assertTrue(carManager.getSUVs().isEmpty(), "No car should be rented for invalid choice.");
        assertTrue(carManager.getLuxuryCars().isEmpty(), "No car should be rented for invalid choice.");
    }
}
