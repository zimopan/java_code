public class eRyder {
    int bikeID;
    int batterylevel;
    boolean isAvailable;
    int kmDriven;
    public boolean ride(){
    if(batterylevel>=0){
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
        System.out.println("battery level:"+batterylevel);
        System.out.println("bike availability:"+isAvailable);
        System.out.println("distance travelled in km:"+kmDriven);
    }
    public void setbatterylevel(int batterylevel){
        this.batterylevel=batterylevel;
    }

}
class main{
    public static void main(String[] args){
        eRyder myBike = new eRyder();
        myBike.printBikeDetails();
    }
}