package eRyder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class UserRegistration {
    Scanner scanner=new Scanner(System.in);
    double VIP_DISCOUNT_UNDER_18_BIRTHDAY=25.0;
    double VIP_DISCOUNT_UNDER_18=20.0;
    double VIP_BASE_FEE=100.0;
    double feeToCharge;

    String fullName;
    String emailAddress;
    String dateOfBirth;
    String cardProvider;
    String cardExpiryDate;
    String userType;

    boolean emailValid;
    boolean minorAndBirthday;
    boolean minor;
    boolean ageValid;
    boolean cardNumberValid;
    boolean cardStillValid;
    boolean validCVV;
    
    long cardNumber;
    int cvv;
    public void registration(){
        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.println("Please enter your choice (1 or 2):");
        int choice=scanner.nextInt();
        if(choice==1){
            userType="Regular User";
        }
        else if(choice==2){
            userType="VIP User";
        }
        scanner.nextLine();
        System.out.println("enter the full name:");
        fullName=scanner.nextLine();
        
        System.out.println("enter their date of birth in the format YYYY-MM-DD:");
        String dateOfBirth=scanner.nextLine();
        LocalDate dob=LocalDate.parse(dateOfBirth);


        System.out.println("please enter their card number");
        System.out.println("only Visa, MasterCard, and American Express cards are accepted");
        cardNumber=scanner.nextLong();
        scanner.nextLine();

        System.out.println("enter their card expiry date");
        String cardExpiryDate=scanner.nextLine();
        scanner.nextLine();

        System.out.println("enter the card's CVV");
        cvv=scanner.nextInt();
        scanner.nextLine();

        scanner.close();

    }
    private boolean analyseEmail(String emailAddress){
        boolean isEmail1;
        boolean isEmail2;
        isEmail1=emailAddress.contains(".");
        isEmail2=emailAddress.contains("@");
        if(isEmail1==true && isEmail2==true){
            System.out.println("Email is valid”");
            emailValid=true;
        }
        else if(isEmail1==false|| isEmail2==false)
        {
            System.out.println("Invalid email address. Going back to the start of the registration");
            emailValid=false;
        }
        registration();
        return emailValid;
        
        
    }
    public boolean analyseAge(LocalDate dob){
        LocalDate now=LocalDate.now();
        Period period1=Period.between(dob, now);
        int year1=period1.getYears();
        boolean isBirthday;
        int dobday=dob.getDayOfMonth();
        int dobmonth=dob.getMonthValue();
        int nowday=now.getDayOfMonth();
        int nowmonth=now.getMonthValue();
        if(dobday==nowday&&dobmonth==nowmonth){
            isBirthday=true;
        }else{
            isBirthday=false;
        }
        if(userType=="VIP User”"){
            if(isBirthday==true){
                if(year1>12&&year1<=18){
                    System.out.println("Happy Birthday!");
                    System.out.println("You get 25% discount on the VIP subscription fee for being born today and being under 18!");
                    minorAndBirthday=true;
                    ageValid=true;
                }
            }else if(year1>12&&year1<=18){
                System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                minor=true;
                ageValid=true;
            }

        }
        if(year1<=12||year1>120){
            System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day");
            System.exit(0);
            ageValid=false;
        }
        return ageValid;
    }


    private boolean analyseCardNumber(long cardNumber){
        String cardNumStr=String.valueOf(cardNumber);
        int firstTwoDigits;
        int firstFourDigits;
        String subString;
        int length=cardNumStr.length();
        
        subString=cardNumStr.substring(0,2);
        firstTwoDigits=Integer.parseInt("subString");
        subString=cardNumStr.substring(0,4);
        firstFourDigits=Integer.parseInt("subString");
        if(length==13||length==15){
            if(cardNumStr.startsWith("4")){
                cardProvider="VISA";
                cardNumberValid=true;
            }
        }
        if(length==16){
            if(firstTwoDigits>=51&&firstTwoDigits<=55||firstFourDigits>=2221&&firstFourDigits<=2720){
                cardProvider="MasterCard";
                cardNumberValid=true;
            }
        }
        if(length==15){
            if(cardNumStr.startsWith("34")||cardNumStr.startsWith("37")){
                cardProvider="American Express";
                cardNumberValid=true;
            }
        }
        if(cardProvider==null){
            System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.");
            System.out.println("Going back to the start of the registration.");
            registration();
            cardNumberValid=false;
        } 
        return cardNumberValid;
    }


    private boolean analyseCardExpiryDate(String cardExpiryDate){
        int month;
        String monthstr=cardExpiryDate.substring(0,2);
        month=Integer.parseInt(monthstr);
        int year;
        String yearstr=cardExpiryDate.substring(3,5);
        year=Integer.parseInt(yearstr);
        year+=2000;
        LocalDate currentDate=LocalDate.now();
        int currentYear;
        currentYear=currentDate.getYear();
        int currentMonth;
        currentMonth=currentDate.getMonthValue();
        if(year>currentYear||year==currentYear&&month>=currentMonth){
            System.out.println("The card is still valid");
            cardStillValid=true;
        }else{
            System.out.println("Sorry, your card has expired. Please use a different card.");
            System.out.println("Going back to the start fo the registration process…");
            registration();
            cardStillValid=false;
        }
        return cardStillValid;
        }


    private boolean analyseCVV(int cvv){
    String cvvStr=String.valueOf(cvv);
    if(cardProvider=="American Express"&&cvvStr.length()==4||cardProvider=="VISA"&&cvvStr.length()==3||cardProvider=="MasterCard"&&cvvStr.length()==3){
        System.out.println("Card CVV is valid.");
        validCVV=true;
    }else{
        System.out.println("Invalid CVV for the given card.");
        System.out.println("Going back to the start of the registration process.");
        registration();
        validCVV=false;
    }
        return validCVV;
    
    }
    private void finalCheckpoint(){
        if(emailValid==true&&ageValid==true&&cardNumberValid==true&&cardStillValid==true)
            chargeFees();
        }
     private void chargeFees(){
        if(minorAndBirthday==true){
            feeToCharge=VIP_BASE_FEE*0.75;
        }
        if(minor==true){
            feeToCharge=VIP_BASE_FEE*0.8;
        }
        if(minorAndBirthday==false&&minor==false){
            feeToCharge=VIP_BASE_FEE;
        }
        String cardNumbers=String.valueOf(cardNumber);
        System.out.println("Thank you for your payment.");
        System.out.println("A fee of"+feeToCharge+"has been charged to your card ending with"+cardNumbers.substring(cardNumbers.length()-4));
    }
    @Override
    public String toString(){
        String cardNumberStr=String.valueOf(cardNumber);
        String censoredPart=cardNumberStr.substring(0,cardNumberStr.length()-4);
        String lastFourDigits=cardNumberStr.substring(cardNumberStr.length()-4);
               censoredPart=censoredPart.replace(".","*");
        String censoredNumber=censoredPart+lastFourDigits;
        return "Registration successful! Here are your details:\n"
        +"User Type:"+userType+"\n"
        +"Full Name:"+fullName+"\n"
        +"Email Address:"+emailAddress+"\n"
        +"Date of Birth:"+dateOfBirth+"\n"
        +"Card Number:"+censoredNumber+"\n"
        +"Card Provider:"+cardProvider+"\n"
        +"Card Expiry Date:"+cardExpiryDate;
    }
    }





    
