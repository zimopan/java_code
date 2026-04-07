package eRyder;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;


public class RentalService {


    private final LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    double BASE_FARE=3.0;
    private RegisteredUsers currentUser; 
    
 
    public void setCurrentUser(RegisteredUsers user) {
        this.currentUser = user;
    }
   
    public void startRental(String bikeID, String emailAddress, LocalDateTime tripStartTime) {
        ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
        activeRentalsList.add(activeRental);
    }


    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    public void endRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
    }

   
    public void cancelRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
    }



    public void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
     
                if (currentUser != null) {
                    currentUser.calculateFare(BASE_FARE);
                }
                
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
    
}