package eRyder;

import java.util.List;
import java.util.Scanner;


public class AdminPanel {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();


    public void userManagementOptions() {
        while (true) {
       
            System.out.println("Welcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. View System Logs");
            System.out.println("7. Manage Pending Bike Requests");
            System.out.println("8. EXIT");

            String choice = scanner.nextLine();

            
            switch (choice) {
                case "1":
                    userService.addNewUsers();
                    List<RegisteredUsers> newUsers = userService.addNewUsers();
                    System.out.println("Successfully created " + newUsers.size() + " user(s):");
                    for (RegisteredUsers user : newUsers) {
                        System.out.println("  - " + user.getFullName() + " (" + user.getUserType() + ")");}
                    break;
                case "2":
                    userService.viewRegisteredUsers();
                    break;
                case "3":
                    userService.removeRegisteredUsers();
                    break;
                case "4":
                    userService.updateRegisteredUsers();
                    break;
                case "5":
                    if (!userService.registeredUsers.isEmpty()) {
                        RegisteredUsers userForRental = userService.registeredUsers.get(0);
                        BikeRental bikeRental = new BikeRental();
                        bikeRental.simulateApplicationInput(userForRental);  
                    } else {
                        System.out.println("No registered users found. Please add a user first (Option 1).");
                    }
                    break;
                case "6":
                    for(ERyderLog eRyderLog:BikeService.stack)
                    {
                    System.out.println(eRyderLog.toString());
                    }
                case "7":
                    System.out.println("1. View Queue");
                    System.out.println("2. Update Queue");
                    System.out.println("3. Exit");
                    String sevenchoice=scanner.nextLine();
                    if(choice.equals("1")){
                        for(BikeRequest bikeRequestsingle:BikeService.bikeRequestqueue){
                            System.out.println(bikeRequestsingle.toString());
                        }
                    }
                    else if(choice.equals("2")){
                        BikeService.bikeRequestqueue.poll();
                    }
                    else if(choice.equals("3")){
                        return;
                    }
                case "8":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }
}