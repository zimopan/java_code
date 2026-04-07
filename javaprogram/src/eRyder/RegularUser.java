package eRyder;

public class RegularUser extends RegisteredUsers{
    public RegularUser(String fullName, String emailAddress, String dateOfBirth,
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
    public  double  calculateFare(double baseFare){
        return baseFare;
    }

    @Override
    public void displayUserType(){
        System.out.println("Regular User");
    }
}
