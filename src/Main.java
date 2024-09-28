import crms.CRMS;

public class Main {
    public static void main(String[] args) {
		CRMS crms = new CRMS();
		
			 boolean running = true;
		        int choice = 0;
		      

		        while (running) {
		            System.out.println("\n\n>Press \n1. Add Car \n2.Remove Car \n3. Rent Car \n4. Return Car \n5. Display Renter History \n6. Display Cars \n0. Exit");

		            String input = System.console().readLine();
		            try {
		                choice = Integer.parseInt(input);

		                switch (choice) {
		                    case 1:
		                        crms.addCar();
		                        break;
		                    case 2:
		                        crms.removeCar();
		                        break;
		                    case 3:
		                        crms.rentCar();
		                        break;
							case 4:
								crms.returnCar();
								break;
							case 5:
								crms.displayRenterHistory();
								break;
		                    case 6:
		                        crms.displayCars();
		                        break;
		                    case 0:
		                        running = false;
		                        break;
		                    default:
		                        System.out.println("\nInvalid Option, Please try again!");
		                }
		            } catch (NumberFormatException e) {
		                System.out.println("\nInvalid input, please enter a number.");
		            }
		        }
		    
		}
    
}
