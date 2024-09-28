package car;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class SUV extends Vehicle {
	int insuranceCost;
	
	public SUV() {
		super();
	}

	public SUV(String CarId, String Brand, String Model, int Year, int BaseRent, int TravelCost, String PlateNumber,
			String Feature, int VehicleCost) {
		super(CarId, Brand, Model, Year, BaseRent, TravelCost, PlateNumber, Feature, true, VehicleCost);
		this.insuranceCost = (5 * VehicleCost) / 100;
	}
	public int initialCost(String RenterType)
	{
		if(RenterType.equals("Regular"))
        {
            return BaseRent;
        }
        else if(RenterType.equals("Corporate"))
        {
            return (BaseRent*90)/100;
        }
        else if(RenterType.equals("Frequent"))
        {
            return (BaseRent*80)/100;
        }
        else
        {
            return 0;
        }
    }
	
	public int finalCost()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int distance=0;
		int damage=0;
		int ch=0;
		try {
			System.out.println("Enter The Distance Travelled: ");
			distance = Integer.parseInt(br.readLine());
			System.out.println("Is There Any Damage? \n1.Yes\n2.No)");
			ch = Integer.parseInt(br.readLine());
			if (ch == 1) {
				
				damage = BaseRent*50/100;
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		if(ch==1 && Insured==true)
		{
		   damage=damage*80/100;	
		}
		DamageCost=damage;
		return distance*TravelCost+damage;
		
	}
}
