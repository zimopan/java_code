package eRyder;

import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    public ActiveRental(){}
    public ActiveRental(String bikeID,String userEmail,LocalDateTime tripStartTime){
        this.bikeID=bikeID;
        this.tripStartTime=tripStartTime;
        this.userEmail=userEmail;
    }

    public String getBikeID() {
        return bikeID;
    }
    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }
    public String getUserEmail() {
        return userEmail;
    }
    @Override
    public String toString(){
        return "bikeID"+bikeID+"\n"+
        "userEmail"+userEmail+"\n"+
        "tripStartTime"+tripStartTime;
    }
    


}
