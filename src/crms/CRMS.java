package crms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import car.CompactCar;
import car.LuxuryCar;
import car.SUV;
import renter.Renter;
import renter.RentHistory;
public final class CRMS {
	
	List<Renter> renters = new ArrayList<Renter>();
	List<RentHistory> rentHistories = new ArrayList<RentHistory>();
	
	List<CompactCar> compactCars = new ArrayList<CompactCar>();
	List<SUV> suvs = new ArrayList<SUV>();
	List<LuxuryCar> luxuryCars = new ArrayList<LuxuryCar>();
	
	public void addRenter(Renter renter) {
        renters.add(renter);
    }
	
	public void addRentHistory(RentHistory rentHistory) {
        rentHistories.add(rentHistory);
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
	
	public void removeRenter(Renter renter) {
        renters.remove(renter);
    }
	
	public void removeRentHistory(RentHistory rentHistory) {
        rentHistories.remove(rentHistory);
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
	
	
	public List<Renter> getRenters() {
		return renters;
	}
	
	public List<RentHistory> getRentHistories() {
		return rentHistories;
	}
	
	public List<CompactCar> getCompactCars() {
		return compactCars;
	}
	
	public List<SUV> getSUVs() {
		return suvs;
	}
	
	public List<LuxuryCar> getLuxuryCars() {
		return luxuryCars;
	}
	
	
	public String calCarId(String type) {
	    String carId = "";
	    int nextId = 1; // Default value for the new ID

	    if (type.equals("Compact")) {
	        if (compactCars.size() == 0) {
	            carId = "C0001";
	        } else {
	            String lastCarId = compactCars.get(compactCars.size() - 1).getCarId();
	            nextId = Integer.parseInt(lastCarId.substring(1)) + 1; // Increment numeric part
	            carId = "C" + String.format("%04d", nextId); // Format with leading zeros
	        }
	    } else if (type.equals("SUV")) {
	        if (suvs.size() == 0) {
	            carId = "S0001";
	        } else {
	            String lastCarId = suvs.get(suvs.size() - 1).getCarId();
	            nextId = Integer.parseInt(lastCarId.substring(1)) + 1; // Increment numeric part
	            carId = "S" + String.format("%04d", nextId); // Format with leading zeros
	        }
	    } else if (type.equals("Luxury")) {
	        if (luxuryCars.size() == 0) {
	            carId = "L0001";
	        } else {
	            String lastCarId = luxuryCars.get(luxuryCars.size() - 1).getCarId();
	            nextId = Integer.parseInt(lastCarId.substring(1)) + 1; // Increment numeric part
	            carId = "L" + String.format("%04d", nextId); // Format with leading zeros
	        }
	    }
	    
	    return carId;
	}

	
	public void addCar() {
	    // Create a BufferedReader to read user input from the console
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    try {
	        // Display options for the type of car the user wants to add
	        System.out.println("\n\n>Press \n1. Add Compact Car \n2. Add SUV \n3. Add Luxury Car");
	        int choice = Integer.parseInt(reader.readLine()); // Read and parse the user's choice

	        // Check if the user's choice is valid (1, 2, or 3)
	        if (choice > 3 || choice < 1) {
	            System.out.println("\n       Invalid Option, Please try again!");
	            return; // Exit the method if the choice is invalid
	        }

	        // Declare variables to store car details
	        String carId;
	        String Brand;
	        String Model;
	        int Year;
	        int BaseRent;
	        int TravelCost; // per km
	        String PlateNumber;
	        String Feature;
	        int VehicleCost;

	        // Prompt the user to enter details for the car being added
	        System.out.println("Enter Model: ");
	        Model = reader.readLine(); // Read the car's model
	        System.out.println("Enter Brand: ");
	        Brand = reader.readLine(); // Read the car's brand
	        System.out.println("Enter Year: ");
	        Year = Integer.parseInt(reader.readLine()); // Read the manufacturing year of the car
	        System.out.println("Enter Base Rent: ");
	        BaseRent = Integer.parseInt(reader.readLine()); // Read the base rent price
	        System.out.println("Enter Travel Cost per km: ");
	        TravelCost = Integer.parseInt(reader.readLine()); // Read the travel cost per kilometer
	        System.out.println("Enter Plate Number: ");
	        PlateNumber = reader.readLine(); // Read the car's license plate number
	        System.out.println("Enter Feature: ");
	        Feature = reader.readLine(); // Read additional features of the car
	        System.out.println("Enter Vehicle Cost: ");
	        VehicleCost = Integer.parseInt(reader.readLine()); // Read the vehicle cost

	        // Switch block to handle the car type chosen by the user
	        switch (choice) {
	            case 1:
	                // Generate a unique ID for the Compact Car
	                carId = calCarId("Compact");
	                // Create a new CompactCar object with the entered details
	                CompactCar compactCar = new CompactCar(carId, Brand, Model, Year, BaseRent, TravelCost, PlateNumber, Feature, VehicleCost);
	                // Add the new compact car to the system
	                addCompactCar(compactCar);
	                break;
	                
	            case 2:
	                // Generate a unique ID for the SUV
	                carId = calCarId("SUV");
	                // Create a new SUV object with the entered details
	                SUV suv = new SUV(carId, Brand, Model, Year, BaseRent, TravelCost, PlateNumber, Feature, VehicleCost);
	                // Add the new SUV to the system
	                addSUV(suv);
	                break;
	                
	            case 3:
	                // Generate a unique ID for the Luxury Car
	                carId = calCarId("Luxury");
	                // Create a new LuxuryCar object with the entered details
	                LuxuryCar luxuryCar = new LuxuryCar(carId, Brand, Model, Year, BaseRent, TravelCost, PlateNumber, Feature, VehicleCost);
	                // Add the new luxury car to the system
	                addLuxuryCar(luxuryCar);
	                break;
	        }

	        // Print success message after the car is added
	        System.out.println("Car Added Successfully!");
	        
	    } catch (IOException | NumberFormatException e) {
	        // Catch any input/output or number format errors and display an error message
	        System.out.println("An error occurred during input: " + e.getMessage());
	    }
	}

	public void removeCar() {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    try {
	        System.out.println("\n\n>Press \n1. Remove Compact Car \n2. Remove SUV \n3. Remove Luxury Car");
	        int choice = Integer.parseInt(reader.readLine());

	        if (choice > 3 || choice < 1) {
	            System.out.println("\n       Invalid Option, Please try again!");
	            return;
	        }

	        String carId;
	        System.out.println("Enter Car ID: ");
	        carId = reader.readLine(); // Reading car ID

	        switch (choice) {
	            case 1:
	                for (int i = 0; i < compactCars.size(); i++) {
	                    if (compactCars.get(i).getCarId().equals(carId)) {
	                        removeCompactCar(compactCars.get(i));
	                        System.out.println("Car Removed Successfully!");
	                        return;
	                    }
	                }
	                break;
	            case 2:
	                for (int i = 0; i < suvs.size(); i++) {
	                    if (suvs.get(i).getCarId().equals(carId)) {
	                        removeSUV(suvs.get(i));
	                        System.out.println("Car Removed Successfully!");
	                        return;
	                    }
	                }
	                break;
	            case 3:
	                for (int i = 0; i < luxuryCars.size(); i++) {
	                    if (luxuryCars.get(i).getCarId().equals(carId)) {
	                        removeLuxuryCar(luxuryCars.get(i));
	                        System.out.println("Car Removed Successfully!");
	                        return;
	                    }
	                }
	                break;
	        }

	        System.out.println("Car not found!");

	    } catch (IOException | NumberFormatException e) {
	        System.out.println("An error occurred during input: " + e.getMessage());
	    }
	}
	
	public void rentCar() {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String Name;
	    String Email;
	    String RenterType="Regular";
	    String phoneNo;
	    String Address;
	    
	    try {
	    	//Get ino about the car to add
	            
	        System.out.println("Chose Car you want to rent: \n1. Compact Car \n2. SUV \n3. Luxury Car\n> ");
	        int choice = Integer.parseInt(reader.readLine());
	        
	        if (choice > 3 || choice < 1) {
	            System.out.println("\n       Invalid Option, Please try again!");
	            return;
	        }
	        
	        if(choice == 1) {
	            System.out.println("\n        Compact Cars \n ");
	            for (int i = 0; i < compactCars.size(); i++) {
	                System.out.println(i + 1 + ". ");
	                compactCars.get(i).display();
	            }
	        } else if (choice == 2) {
	            System.out.println("\n        SUVs \n ");
	            for (int i = 0; i < suvs.size(); i++) {
	                System.out.println(i + 1 + ". ");
	                suvs.get(i).display();
	            }
	        } else if (choice == 3) {
	            System.out.println("\n        Luxury Cars \n ");
	            for (int i = 0; i < luxuryCars.size(); i++) {
	                System.out.println(i + 1 + ". ");
	                luxuryCars.get(i).display();
	            }
	        }
	        
	        System.out.println("Enter Car ID you want to rent: ");
	        String carId = reader.readLine();
	        int index = -1;
	        
	        if (choice == 1) {
	            for (int i = 0; i < compactCars.size(); i++) {
	                if (compactCars.get(i).getCarId().equals(carId)) {
	                    index = i;
	                    break;
	                }
	            }
	        } else if (choice == 2) {
	            for (int i = 0; i < suvs.size(); i++) {
	                if (suvs.get(i).getCarId().equals(carId)) {
	                    index = i;
	                    break;
	                }
	            }
	        } else if (choice == 3) {
	            for (int i = 0; i < luxuryCars.size(); i++) {
	                if (luxuryCars.get(i).getCarId().equals(carId)) {
	                    index = i;
	                    break;
	                }
	            }
	        }
	        
	        if (index == -1) {
	            System.out.println("Car not found!");
	            return;
	        }
	        
	        System.out.println("Enter Renter ID (CNIC): ");
	        String renterId = reader.readLine();
	        
	        int index2 = -1;
	        for (int i = 0; i < renters.size(); i++) {
	            if (renters.get(i).getRenterId().equals(renterId)) {
	                index2 = i;
	                break;
	            }
	        }
	        
	        boolean insured = false;
	        
	        if (index2 == -1) {
	            int rt;
	           
	           //if user is not already added in the system
	            
	            System.out.println("Enter Renter name: ");
	            Name = reader.readLine();
	            System.out.println("Enter Email: ");
	            Email = reader.readLine();
	            System.out.println("Enter Renter Type \n 1. Regular \n 2.Frequent \n 3. Corporate \n> ");
	            rt = Integer.parseInt(reader.readLine());
	            
	            if(rt == 1) {
	                RenterType = "Regular";
	            } else if(rt == 2) {
	                RenterType = "Frequent";
	            } else {
	                RenterType = "Corporate";
	            }
	            
	            System.out.println("Enter Phone Number: ");
	            phoneNo = reader.readLine();
	            System.out.println("Enter Address: ");
	            Address = reader.readLine();
	            
	            if(choice != 1) {
	                System.out.println("Do you want to insure the car? \n1. Yes \n2. No \n> ");
	                int ch = Integer.parseInt(reader.readLine());
	                if (ch == 1) {
	                    insured = true;
	                }
	            }
	            Renter renter = new Renter(renterId, Name, Email, RenterType, phoneNo, Address);
	            
	            if (choice == 1) {
	                compactCars.get(index).setRented(true);
	                renter.addCompactCar(compactCars.get(index));
	            } else if (choice == 2) {
	                suvs.get(index).setRented(true);
	                suvs.get(index).setInsured(insured);
	                renter.addSUV(suvs.get(index));
	            } else if (choice == 3) {
	                luxuryCars.get(index).setRented(true);
	                luxuryCars.get(index).setInsured(insured);
	                renter.addLuxuryCar(luxuryCars.get(index));
	            }
	            
	        } else {
	        	//if user is already added in the system Just add car to the user
	            if (choice != 1) {
	                System.out.println("Do you want to insure the car? \n1. Yes \n2. No \n> ");
	                int ch = Integer.parseInt(reader.readLine());
	                if (ch == 1) {
	                    insured = true;
	                }
	            }
	            
	            if (choice == 1) {
	                compactCars.get(index).setRented(true);
	                renters.get(index2).addCompactCar(compactCars.get(index));
	               
	            } else if (choice == 2) {
	                suvs.get(index).setRented(true);
	                suvs.get(index).setInsured(insured);
	                renters.get(index2).addSUV(suvs.get(index));
	               
	            } else if (choice == 3) {
	                luxuryCars.get(index).setRented(true);
	                luxuryCars.get(index).setInsured(insured);
	                renters.get(index2).addLuxuryCar(luxuryCars.get(index));
	                
	            }
	        }
	        //displaying cost
	       int cost=0;
			if (choice == 1) {
				cost = compactCars.get(index).initialCost(RenterType);
			} else if (choice == 2) {
				cost = suvs.get(index).initialCost(RenterType);
			} else if (choice == 3) {
				cost = luxuryCars.get(index).initialCost(RenterType);
			}
			
	        System.out.println("Car Rented Successfully! \nInitial Cost: " + cost);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void displayCars() {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    try {
	        System.out.println("\n\n>Press \n1. Compact Cars \n2. SUVs \n3. Luxury Cars \n4. All Cars \n>  ");
	        int choice = Integer.parseInt(reader.readLine());
	        
	        if (choice > 4 || choice < 1) {
	            System.out.println("\n       Invalid Option, Please try again!");
	            return;
	        }
	        
	        if (choice == 1) {
	            for (int i = 0; i < compactCars.size(); i++) {
	                compactCars.get(i).display();
	                System.out.println("\n");
	            }
	        } else if (choice == 2) {
	            for (int i = 0; i < suvs.size(); i++) {
	                suvs.get(i).display();
	                System.out.println("\n");
	            }
	        } else if (choice == 3) {
	            for (int i = 0; i < luxuryCars.size(); i++) {
	                luxuryCars.get(i).display();
	                System.out.println("\n");
	            }
	        } else if (choice == 4) {
	            System.out.println("\n        Compact Cars \n ");
	            for (int i = 0; i < compactCars.size(); i++) {
	                compactCars.get(i).display();
	                System.out.println("\n");
	            }
	            System.out.println("\n        SUVs \n ");
	            for (int i = 0; i < suvs.size(); i++) {
	                suvs.get(i).display();
	                System.out.println("\n");
	            }
	            System.out.println("\n        Luxury Cars \n ");
	            for (int i = 0; i < luxuryCars.size(); i++) {
	                luxuryCars.get(i).display();
	                System.out.println("\n");
	            }
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public void returnCar() {
		        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
        	System.out.println("Enter Cartype: \n1.Compact \n2.SUV \n3.Luxury");
        	int cartype=Integer.parseInt(reader.readLine());
            System.out.println("Enter Car ID: ");
            String carId = reader.readLine();
            int index = -1;
            
       if(cartype==1)
       {
			for (int i = 0; i < compactCars.size(); i++) {
				if (compactCars.get(i).getCarId().equals(carId)) {
					index = i;
					break;
				}
			}
		} else if (cartype == 2) {
			for (int i = 0; i < suvs.size(); i++) {
				if (suvs.get(i).getCarId().equals(carId)) {
					index = i;
					break;
				}
			}
		} else if (cartype == 3) {
			for (int i = 0; i < luxuryCars.size(); i++) {
				if (luxuryCars.get(i).getCarId().equals(carId)) {
					index = i;
					break;
				}
			}
		}

		if (index == -1) {
			System.out.println("Car not found!");
			return;
		}

		System.out.println("Enter Renter ID (CNIC): ");
		String renterId = reader.readLine();
		int index2 = -1;
		for (int i = 0; i < renters.size(); i++) {
			if (renters.get(i).getRenterId().equals(renterId)) {
				index2 = i;
				break;
			}
		}

		if (index2 == -1) {
			System.out.println("Renter not found!");
			return;
		}
//get Cost when user returns the car
		int cost = 0;
		if (cartype == 1) {
			cost = compactCars.get(index).finalCost();
		} else if (cartype == 2) {
			cost = suvs.get(index).finalCost();
		} else if (cartype == 3) {
			cost = luxuryCars.get(index).finalCost();
		}

		System.out.println("Car Returned Successfully! \nFinal Cost: " + cost);
		//get data for rentHistory
      Renter renter = renters.get(index2);
      String CarType;
      int initialCost=0;
      int damageCost=0;
      if(cartype==1)
      {
    	  CarType="Compact Car";
    	  initialCost=compactCars.get(index).initialCost(renter.getRenterType());
    	  damageCost=compactCars.get(index).getDamageCost();
      }
      else if(cartype==2)
      {
    	  CarType="SUV";
    	  initialCost=suvs.get(index).initialCost(renter.getRenterType());
    	  damageCost=suvs.get(index).getDamageCost();
      }
      else
      {
    	  CarType="Luxury Car";
    	  initialCost=luxuryCars.get(index).initialCost(renter.getRenterType());
    	  damageCost=luxuryCars.get(index).getDamageCost();
      }
      //add returned car to history
		if(cartype==1)
		{
			RentHistory rh = new RentHistory(
				    renter.getRenterId(), 
				    renter.getName(), 
				    renter.getEmail(), 
				    renter.getRenterType(), 
				    renter.getPhoneNo(), 
				    renter.getAddress(),
				    CarType, 
				    (cost + initialCost), 
				    damageCost
				);
				rentHistories.add(rh);
			} else if (cartype == 2) {
				RentHistory rh = new RentHistory(renter.getRenterId(), renter.getName(), renter.getEmail(), 
						renter.getRenterType(), renter.getPhoneNo(), renter.getAddress(), CarType, (cost + initialCost),
						damageCost);
				rentHistories.add(rh);
			}
		    else if(cartype==3)
            {
                RentHistory rh = new RentHistory(renter.getRenterId(), renter.getName(), renter.getEmail(), // Include
                        renter.getRenterType(), renter.getPhoneNo(), renter.getAddress(), CarType, (cost + initialCost),
                        damageCost);
                rentHistories.add(rh);
            }
		//Reset the car to available and remove from user 
		
		if (cartype == 1) {
			compactCars.get(index).setRented(false);
			renters.get(index2).removeCompactCar(compactCars.get(index));
		} else if (cartype == 2) {
			suvs.get(index).setRented(false);
			renters.get(index2).removeSUV(suvs.get(index));
		} else if (cartype == 3) {
			luxuryCars.get(index).setRented(false);
			renters.get(index2).removeLuxuryCar(luxuryCars.get(index));
		}
		
		if(renter.isEmpty()) {
            renters.remove(index2);
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayRenterHistory() {
		for (int i = 0; i < rentHistories.size(); i++) {
			rentHistories.get(i).displayHistory();
		}
	}
		
	}
	
	


