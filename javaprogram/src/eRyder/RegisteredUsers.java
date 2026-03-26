package eRyder;
import eRyder.UserRegistration.*;

public class RegisteredUsers {
     String fullName;
    String emailAddress;
    String dateOfBirth;
    String cardExpiryDate;
    String cardProvider;
    String userType;
    long cardNumber;
    int cvv;
    String[] lastThreeTrips;

    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                           long cardNumber, String cardProvider, String cardExpiryDate,
                           int cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardProvider = cardProvider;
        this.cardExpiryDate = cardExpiryDate;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }


    public RegisteredUsers() {
    }
 
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }

    @Override
    public String toString() {
        StringBuilder tripsInfo = new StringBuilder();
        if (lastThreeTrips != null) {
            for (int i = 0; i < lastThreeTrips.length; i++) {
                tripsInfo.append("\n  Trip ").append(i + 1).append(": ").append(lastThreeTrips[i]);
            }
        } else {
            tripsInfo.append("\n  No trip records");
        }

        return "RegisteredUsers{" +
                "\n  fullName='" + fullName + '\'' +
                ",\n  emailAddress='" + emailAddress + '\'' +
                ",\n  dateOfBirth='" + dateOfBirth + '\'' +
                ",\n  cardExpiryDate='" + cardExpiryDate + '\'' +
                ",\n  cardProvider='" + cardProvider + '\'' +
                ",\n  userType='" + userType + '\'' +
                ",\n  cardNumber=" + cardNumber +
                ",\n  cvv=" + cvv +
                ",\n  lastThreeTrips=" + tripsInfo.toString() +
                "\n}";
    }


}
