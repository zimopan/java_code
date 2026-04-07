package eRyder;

public class VIPUser extends RegisteredUsers{
    public VIPUser(String fullName, String emailAddress, String dateOfBirth,
                           long cardNumber, String cardProvider, String cardExpiryDate,
                           int cvv, String userType, String[] lastThreeTrips) {
        super.fullName = fullName;
        super.emailAddress = emailAddress;
        super.dateOfBirth = dateOfBirth;
        super.cardNumber = cardNumber;
        super.cardProvider = cardProvider;
        super.cardExpiryDate = cardExpiryDate;
        super.cvv = cvv;
        super.userType = userType;
        super.lastThreeTrips = lastThreeTrips;
    }



    @Override
    public double calculateFare(double baseFare){
        baseFare=baseFare*0.8;
        return baseFare;
    }


    @Override
    public void displayUserType(){
        System.out.println("VIP User");
    }

}
