package eRyder;
public class eRyder{
    int bikeID;
    int batteryLevel;
    boolean isAvailable;
    int kmDriven;
    String COMPANY_NAME;
    double BASE_FARE;
    double PER_MINUTE_FARE;
    private int totalUsageInMinutes;
    private double totalFare;
    final String LINKED_ACCOUNT;
    final int LINKED_PHONE_NUMBER;
    int  usageInMinutes;

    public eRyder(){
        bikeID=123456;
        batteryLevel=0;
        isAvailable=true;
        kmDriven=0;
        COMPANY_NAME="ERyder";
        BASE_FARE=1.0;
        PER_MINUTE_FARE=0.5;
        totalUsageInMinutes=2;
        totalFare=30;
        LINKED_ACCOUNT="mo";
        LINKED_PHONE_NUMBER=182311;
        usageInMinutes=300;

    }
    public eRyder(int bikeID,int batteryLevel,boolean isAvailable,int kmDriven)
    {
        this.bikeID=bikeID;
        this.batteryLevel=batteryLevel;
        this.isAvailable=isAvailable;
        this.kmDriven=kmDriven;
        LINKED_ACCOUNT="mo";
        LINKED_PHONE_NUMBER=182311;
    }



    
    public boolean ride(){
    if(batteryLevel>=0){
        if(isAvailable==true){
            System.out.println("This bike is availability");
            return true;
        }
        else{
             System.out.println("This bike is not availability");
            return false;
            
        }
    }   
    else{
    return false;
    }
    }
     public void printBikeDetails(){
        System.out.println("bike ID:"+bikeID);
        System.out.println("battery level:"+batteryLevel);
        System.out.println("bike availability:"+isAvailable);
        System.out.println("distance travelled in km:"+kmDriven);
    }
    public void printRideDetails(){
        System.out.println("link account:"+LINKED_ACCOUNT);
        System.out.println("link phone number:"+LINKED_PHONE_NUMBER);
        System.out.println("bikeID:"+bikeID);
        System.out.println("usageInMinutes:"+usageInMinutes);
        System.out.println("total fare:"+totalFare);
    }
    private double calculateFare(){
        totalFare=BASE_FARE+PER_MINUTE_FARE*usageInMinutes;
        return totalFare;
    }
}