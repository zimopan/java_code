package eRyder;


import java.lang.reflect.AccessFlag.Location;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;


public class BikeService {
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    public static Deque<ERyderLog>stack=new ArrayDeque<>();
    public static Queue<BikeRequest>bikeRequestqueue=new ArrayDeque<>();
    public String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.getIsAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        return null;
    }

    public LocalDateTime reserveBike(String bikeID,String emailAddress,String location) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bike.getBikeID().equals(bikeID)) {
                    LocalDateTime tripStartTime = LocalDateTime.now();
                    bike.setAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    ERyderLog eRyderLog=new ERyderLog(bikeID,bike.getLocation(),LocalDateTime.now());
                    stack.push(eRyderLog);
                    return tripStartTime;
                }
            }
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
            BikeRequest bikesinglerequest=new BikeRequest(emailAddress, location, LocalDateTime.now());
            bikeRequest.add(bikesinglerequest);
        }
        return null;
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }


    public void viewSystemLogs(){
        for(ERyderLog singleRecord:stack){
            singleRecord.toString();
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
                if(!bikeRequest.isEmpty()){
                    bikeRequest.clear();
                }
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}