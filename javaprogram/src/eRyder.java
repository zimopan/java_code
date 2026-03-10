public class eRyder{
    int bikeID;
    int batteryLevel;
    boolean isAvailable;
    int kmDriven;

    public eRyder(){
        bikeID=123456;
        batteryLevel=0;
        isAvailable=true;
        kmDriven=0;
    }
    public eRyder(int bikeID,int batteryLevel,boolean isAvailable,int kmDriven)
    {
        this.bikeID=bikeID;
        this.batteryLevel=batteryLevel;
        this.isAvailable=isAvailable;
        this.kmDriven=kmDriven;
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
}