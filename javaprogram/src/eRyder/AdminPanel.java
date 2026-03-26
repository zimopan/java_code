package eRyder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;  

public class AdminPanel {
    String fullName;
    String emailAddress;
    String dateOfBirth;
    String cardExpiryDate;
    String cardProvider;
    String userType;
    long cardNumber;
    int cvv;
    String choice;
    String[] lastThreeTrips=new String[3];


Scanner scanner=new Scanner(System.in);
List<RegisteredUsers> registeredUsers = new ArrayList<>();

public void userManagementOptions(){
    // 循环显示菜单，直到选择5退出
    while(true) {
        System.out.println("Welcome to E-Ryder Administrator Panel.");
        System.out.println("What do you want to do?");
        System.out.println("1. Add New Users\n" + 
                            "2. View Registered Users\r\n" +
                            "3. Remove Registered Users\r\n" + 
                            "4. Update Registered Users\r\n" + 
                            "5. EXIT");
        choice = scanner.nextLine();
        
        if(choice.equals("1")) {
            addNewUsers();
        }
        else if(choice.equals("2")) {
            viewRegisteredUsers();
        }
        else if(choice.equals("3")) {
            removeRegisteredUsers();
        }
        else if(choice.equals("4")) {
            updateRegisteredUsers();
        }
        else if(choice.equals("5")) {
            System.out.println("Exiting program...");
            break;
        }
        else {
            System.out.println("Invalid choice. Please try again");
        }
    }
}


private void addNewUsers(){
    System.out.println("how many users:");
    int usernumber=scanner.nextInt();
    scanner.nextLine();
      for (int i = 0; i < usernumber; i++) {
        System.out.println("\n Adding User " + (i + 1) );
    
        System.out.print("Enter name: ");
        fullName = scanner.nextLine();
        
        System.out.print("Enter email address: ");
        emailAddress = scanner.nextLine();
        
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        dateOfBirth = scanner.nextLine();
        
        System.out.print("Enter card number: ");
        cardNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter card provider: ");
        cardProvider = scanner.nextLine();
        
        System.out.print("Enter card expiry date (MM/YY): ");
        cardExpiryDate = scanner.nextLine();
        
        System.out.print("Enter CVV: ");
        cvv = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter user type (e.g., Admin, Regular, Premium): ");
        userType = scanner.nextLine();

        System.out.print("Enter three trips: ");

         for (int a = 0; a < 3; a++) {
            System.out.println("\nTrip " + (a + 1) );
            
     
            System.out.print("Enter the date of the trip (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            

            System.out.print("Enter source (e.g., NJIT Gate 5): ");
            String source = scanner.nextLine();
            
  
            System.out.print("Enter destination (e.g., Wending Square): ");
            String destination = scanner.nextLine();
            

            System.out.print("Enter fare paid : ");
            double fare = scanner.nextDouble();
            scanner.nextLine(); 
            
    
            System.out.print("Enter feedback (or press Enter for NULL): ");
            String feedback = scanner.nextLine();
         
            
            StringBuilder tripBuilder = new StringBuilder();
            tripBuilder.append("Date: ").append(date)
                      .append(", Source: ").append(source)
                      .append(", Destination: ").append(destination)
                      .append(", Fare : ").append(fare)
                      .append(", Feedback: ").append(feedback);
            
         
            lastThreeTrips[a] = tripBuilder.toString();
         }
    
    }

 
        
        System.out.println("\n Last Three Trips");
        for (int i = 0; i < lastThreeTrips.length; i++) {
            System.out.println("Trip " + (i + 1) + ": " + lastThreeTrips[i]);
        }
        
        RegisteredUsers newuser1=new RegisteredUsers(fullName,emailAddress,dateOfBirth,cardNumber,cardProvider,cardExpiryDate,cvv,userType,lastThreeTrips);
        registeredUsers.add(newuser1);

}


        private  void viewRegisteredUsers(){
            if(registeredUsers.isEmpty()){
                System.out.println("No registered users to display");
            }
            else{
            for(RegisteredUsers user:registeredUsers){
                  
                    System.out.println("name: " + user.getFullName());
                    System.out.println("emial: " + user.getEmailAddress());
                    System.out.println("DateOfBirth: " + user.getDateOfBirth());
                    System.out.println("CardNumbe: " + user.getCardNumber());
                    System.out.println("CardProvider: " + user.getCardProvider());
                    System.out.println("CardExpiryDate: " + user.getCardExpiryDate());
                    System.out.println("Cvv: " + user.getCvv());
                    System.out.println("UserType: " + user.getUserType());
                    System.out.println(lastThreeTrips);
                }
            }
        }


        private void removeRegisteredUsers(){
            if(registeredUsers.isEmpty()){
                System.out.println("No registered users to remove");
            }
            else{
                System.out.println("email address of the user whose object must be updated:");
                String emailToRemove=scanner.nextLine();
                boolean found=false;
                Iterator<RegisteredUsers> iterator = registeredUsers.iterator();
                 while (iterator.hasNext()) {
                RegisteredUsers user = iterator.next();
                if (user.getEmailAddress().equals(emailToRemove)) {
                    iterator.remove(); 
                    found = true;}
                }
                if(!found){
                    System.out.println("No user found with this email address");
                }
            }
            }
        


           private void updateRegisteredUsers(){
            if(registeredUsers.isEmpty()){
        System.out.println("No registered users to remove");
        }
        else{
        boolean found=false;
        System.out.println("email address of the user whose object must be updated:");
        String emailToupdate=scanner.nextLine();
        RegisteredUsers userToUpdate = null;

        Iterator<RegisteredUsers> iterator = registeredUsers.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(emailToupdate)) {
                userToUpdate = user;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.print("enter name (use enter to remain original value: " + userToUpdate.getFullName() + "): ");
        String fullName = scanner.nextLine();
        if (!fullName.isEmpty()) {
            userToUpdate.setFullName(fullName);
        } 

        System.out.print("enter the new email (use enter to remain original value: " + userToUpdate.getEmailAddress() + "): ");
        String emailAddress = scanner.nextLine();
        if (!emailAddress.isEmpty()) {
            userToUpdate.setEmailAddress(emailAddress);
        }

        System.out.print("enter dateofbirth (use enter to remain original value: " + userToUpdate.getDateOfBirth() + "): ");
        String dateOfBirth = scanner.nextLine();
        if (!dateOfBirth.isEmpty()) {
            userToUpdate.setDateOfBirth(dateOfBirth);
        }

        System.out.print("enter cardNumber(use enter to remain original value: " + userToUpdate.getCardNumber() + "): ");
        String cardNumberStr = scanner.nextLine();
        if (!cardNumberStr.isEmpty()) {
            long cardNumber = Long.parseLong(cardNumberStr);
            userToUpdate.setCardNumber(cardNumber);
        }

        System.out.print("enter new cardProvider(use enter to remain original value: " + userToUpdate.getCardProvider() + "): ");
        String cardProvider = scanner.nextLine();
        if (!cardProvider.isEmpty()) {
            userToUpdate.setCardProvider(cardProvider);
        }

        System.out.print("enter cardExpiryDate(use enter to remain original value: " + userToUpdate.getCardExpiryDate() + "): ");
        String cardExpiryDate = scanner.nextLine();
        if (!cardExpiryDate.isEmpty()) {
            userToUpdate.setCardExpiryDate(cardExpiryDate);
        }

        System.out.print("enter usetype(use enter to remain original value: " + userToUpdate.getUserType() + "): ");
        String userType = scanner.nextLine();
        if (!userType.isEmpty()) {
            userToUpdate.setUserType(userType);
        }

        String[] currentTrips = userToUpdate.getLastThreeTrips();
        String[] newTrips = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Trip " + (i + 1) + " (Current: " + currentTrips[i] + "): ");
            String trip = scanner.nextLine();
            if (!trip.isEmpty()) {
                newTrips[i] = trip;
            } else {
                newTrips[i] = currentTrips[i];
            }
        }

        userToUpdate.setLastThreeTrips(newTrips);
    }
    }
}
