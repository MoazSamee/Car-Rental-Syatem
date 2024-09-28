package car;


public abstract class Vehicle{
	protected String CarId;
	protected String Brand;
	protected String Model;
	protected int Year;
	protected boolean Rented;  //By the client
	protected boolean Insured; //By the client
	protected int BaseRent;
	protected int TravelCost; //per km
	protected String PlateNumber;
	protected String Feature;
	protected boolean Insurable;
	int VehicleCost;
	int DamageCost;
	
	
	public Vehicle() {
		CarId = "";
		Brand = "";
		Model = "";
		Year = 0;
		Rented = false;
		BaseRent = 0;
		TravelCost = 0;
		PlateNumber = "";
		Feature = "";
		Insurable = false;
		VehicleCost = 0;
		Insured = false;
		
	}
	
	public Vehicle(String CarId, String Brand, String Model, int Year, int BaseRent, int TravelCost,
			String PlateNumber, String Feature, boolean Insurable, int VehicleCost) {
		this.CarId = CarId;
		this.Brand = Brand;
		this.Model = Model;
		this.Year = Year;
		this.Rented = false;
		this.Insured = false;
		this.BaseRent = BaseRent;
		this.TravelCost = TravelCost;
		this.PlateNumber = PlateNumber;
		this.Feature = Feature;
		this.Insurable = Insurable;
		this.VehicleCost = VehicleCost;
	}
	
	   public void setCarId(String CarId) {
	        this.CarId = CarId;
	    }

	    public void setBrand(String Brand) {
	        this.Brand = Brand;
	    }

	    public void setModel(String Model) {
	        this.Model = Model;
	    }

	    public void setYear(int Year) {
	        this.Year = Year;
	    }
	    
	   

	    public void setRented(boolean Rented) {
	        this.Rented = Rented;
	    }

		public void setInsured(boolean Insured) {
			this.Insured = Insured;
		}
		
	    public void setBaseRent(int BaseRent) {
	        this.BaseRent = BaseRent;
	    }

	    public void setTravelCost(int TravelCost) {
	        this.TravelCost = TravelCost;
	    }

	    public void setPlateNumber(String PlateNumber) {
	        this.PlateNumber = PlateNumber;
	    }

	    public void setFeature(String Feature) {
	        this.Feature = Feature;
	    }

	    public void setInsurable(boolean Insurable) {
	        this.Insurable = Insurable;
	    }

	    public void setVehicleCost(int VehicleCost) {
	        this.VehicleCost = VehicleCost;
	    }
	    
		public void setDamageCost(int DamageCost) {
			this.DamageCost = DamageCost;
		}
	    
	public String getCarId() {
		return CarId;
	}
	
	public String getBrand() {
		return Brand;
	}
	
	public String getModel() {
		return Model;
	}
	
	public int getYear() {
		return Year;
	}
	
	public boolean getRented() {
		return Rented;
	}

	public boolean getInsured() {
		return Insured;
	}
	public int getBaseRent() {
		return BaseRent;
	}
	
	public int getVehicleCost() {
		return VehicleCost;
	}
	public String getPlateNumber() {
		return PlateNumber;
	}
	
	public String getFeature() {
		return Feature;
	}
	
	public boolean getInsurable() {
		return Insurable;
	}
	
	public int getTravelCost() {
		return TravelCost;
	}

	public int getDamageCost() {
		return DamageCost;
	}
	
	public void display() {
		System.out.println("Car ID: " + CarId);
		System.out.println("Brand: " + Brand);
		System.out.println("Model: " + Model);
		System.out.println("Year of make: " + Year);
		System.out.println("Base Rent: " + BaseRent);
		System.out.println("Travel Cost per km: " + TravelCost);
		System.out.println("Plate Number: " + PlateNumber);
		System.out.println("Feature: " + Feature);
		System.out.println("Insurable: " + Insurable);
		System.out.println("Rented: "+ Rented);
	}

	public int initialCost() { // days of rent
		return BaseRent;
	}
	public int finalCost( ) {    //distance in km
		System.out.println("Enter the distance in km: ");
		int distance = Integer.parseInt(System.console().readLine());
		
        return BaseRent + TravelCost * distance;
    }
	
}
