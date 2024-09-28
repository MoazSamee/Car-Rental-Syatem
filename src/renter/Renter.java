package renter;
import java.util.ArrayList;
import java.util.List;

import car.CompactCar;
import car.LuxuryCar;
import car.SUV;


public class Renter {
   protected String RenterId; //Id card number
   protected String Name;
   protected String Email;
   protected String RenterType;
   protected String phoneNo;
   protected String Address;
  
   
   private List<CompactCar> compactCars= new ArrayList<CompactCar>();
   private List<SUV> suvs= new ArrayList<SUV>();
   private List<LuxuryCar> luxuryCars= new ArrayList<LuxuryCar>();
   
	public Renter() {
		RenterId = "";
		Name = "";
		Email = "";
		RenterType = "";
		phoneNo = "";
		Address = "";
	}
	
	public Renter(String RenterId, String Name, String Email, String RenterType, String phoneNo, String Address) {
		this.RenterId = RenterId;
		this.Name = Name;
		this.Email = Email;
		this.RenterType = RenterType;
		this.phoneNo = phoneNo;
		this.Address = Address;
	}

	public void setRenterId(String RenterId) {
		this.RenterId = RenterId;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public void setRenterType(String RenterType) {
		this.RenterType = RenterType;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getRenterId() {
		return RenterId;
	}
 
	public String getName() {
		return Name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getRenterType() {
		return RenterType;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public String getAddress() {
		return Address;
	}
	
	
	public void addCompactCar(CompactCar compactCar) {
		compactCars.add(compactCar);
	}

	public void addSUV(SUV suv) {
		suvs.add(suv);
	}

	public void addLuxuryCar(LuxuryCar luxuryCar) {
		luxuryCars.add(luxuryCar);
	}

	public void removeCompactCar(CompactCar compactCar) {
		compactCars.remove(compactCar);
	}

	public void removeSUV(SUV suv) {
		suvs.remove(suv);
	}

	public void removeLuxuryCar(LuxuryCar luxuryCar) {
		luxuryCars.remove(luxuryCar);
	}

	public List<CompactCar> getCompactCars() {
		return compactCars;
	}

	public List<SUV> getSUVs() {
		return suvs;
	}

	public List<LuxuryCar> getLuxuryCars(){
        	return luxuryCars;
        }
	
	public boolean isEmpty() {
		if (compactCars.size() == 0 && suvs.size() == 0 && luxuryCars.size() == 0) {
			return true;
		}
		return false;
	}

   public void display() {
	           System.out.println("RenterId: " + RenterId);
	           System.out.println("Name: " + Name);
	           System.out.println("Email: " + Email);
	           System.out.println("RenterType: " + RenterType);
	           System.out.println("phoneNo: " + phoneNo);
	           System.out.println("Address: " + Address);
	          
	           if(compactCars.size()>0 )
	           { System.out.println("Compact Cars: \n");
				for (int i = 0; i < compactCars.size(); i++) {
					compactCars.get(i).display();
				}
	           }
	           
	           if(suvs.size()>0)
	           {
				System.out.println("SUVs: \n");
				for (int i = 0; i < suvs.size(); i++) {
					suvs.get(i).display();
				}
	           }
	          
	           if(luxuryCars.size()>0)
               {
				System.out.println("Luxury Cars: \n");
				for (int i = 0; i < luxuryCars.size(); i++) {
					luxuryCars.get(i).display();
				}
               }
   }	
}
