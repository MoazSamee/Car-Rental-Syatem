package renter;
import car.CompactCar;
import car.LuxuryCar;
import car.SUV;


public final class RentHistory extends Renter {
String CarType;
CompactCar compactCar;
SUV suv;
LuxuryCar luxuryCar;



int TotalCost;
int DamageCost;

public RentHistory() {
    super();
    CarType = "";
    TotalCost = 0;
    DamageCost = 0;
}

public RentHistory(String RenterId, String Name, String Email, String RenterType, String phoneNo, String Address,
		String CarType , int TotalCost, int DamageCost) {
	super(RenterId, Name, Email, RenterType, phoneNo, Address);
	this.CarType = CarType;
	
	
	this.TotalCost = TotalCost;
	this.DamageCost = DamageCost;
	
}

public void setCarType(String CarType) {
	this.CarType = CarType;
}

public void setCompactCar(CompactCar compactCar) {
	this.compactCar = compactCar;
}

public void setSUV(SUV suv) {
	this.suv = suv;
}

public void setLuxuryCar(LuxuryCar luxuryCar) {
	this.luxuryCar = luxuryCar;
}


public void setTotalCost(int TotalCost) {
	this.TotalCost = TotalCost;
}

public void setDamageCost(int DamageCost) {
	this.DamageCost = DamageCost;
}
public String getCarType() {
	return CarType;
}

public CompactCar getCompactCar() {
	return compactCar;
}

public SUV getSUV() {
	return suv;
}

public LuxuryCar getLuxuryCar() {
	return luxuryCar;
}




public int getTotalCost() {
	return TotalCost;
}

public int getDamageCost() {
	return DamageCost;
}
public void displayHistory() {
	
	System.out.println("Renter ID: " + RenterId);
    System.out.println("Name: " + Name);
    System.out.println("Email: " + Email);
    System.out.println("Renter Type: " + RenterType);
    System.out.println("Phone Number: " + phoneNo);
    System.out.println("Address: " + Address);
    System.out.println("Car Type: " + CarType);
	if (CarType.equals("Compact Car")) {
		System.out.println("Compact Car Details: ");
		compactCar.display();
	} else if (CarType.equals("SUV")) {
		System.out.println("SUV Details: ");
		suv.display();
	} else if (CarType.equals("Luxury Car")) {
		System.out.println("Luxury Car Details: ");
		luxuryCar.display();
	}
	
	System.out.println("Total Rental Cost: " + TotalCost);
	System.out.println("Damage Cost: " + DamageCost);

}

}
