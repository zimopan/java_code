package eRyder;

import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;
    public Bike(){}
    public Bike(String bikeID,boolean isAvailable,int batteryLevel,LocalDateTime lastUsedTime,String location)
    {
        this.bikeID=bikeID;
        this.isAvailable=isAvailable;
        this.batteryLevel=batteryLevel;
        this.lastUsedTime=lastUsedTime;
        this.location=location;
    }



    public int getBatteryLevel() {
        return batteryLevel;
    }
    public String getBikeID() {
        return bikeID;
    }
    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }
    public String getLocation() {
        return location;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }
    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return "bikeID:"+bikeID+"\n"+
        "isAvailable:"+isAvailable+"\n"+
        "batteryLevel:"+batteryLevel+"\n"+
        "lastUsedTime"+lastUsedTime+"\n"+
        "location"+location;
    }
}


