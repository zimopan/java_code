package eRyder;

public class main{
public static void main(String[] args)
{
eRyder e1=new eRyder();
e1.printBikeDetails();
eRyder e2=new eRyder(12345,6,true,200);
e2.printBikeDetails();
eRyder e3=new eRyder();
eRyder e4=new eRyder(12345,6,true,200);
e3.printBikeDetails();
e4.printBikeDetails();

String sent1 = "I was very satisfied with the service.";
String sent2 = "The e-Bike is quite comfortable to ride.";
String sent3 = "The battery life of the e-Bike is impressive.";
String sent4 = "The customer support was helpful and responsive.";
String sent5 = "I would recommend this e-Bike to my friends and family.";
Feedback feedback = new Feedback("Tom", "Smith", "tom.smith@test.com");
feedback.analyseFeedback(true, sent1, sent2, sent3, sent4, sent5);
System.out.println(feedback);

UserRegistration user=new UserRegistration();
user.registration();
System.out.println(user);

AdminPanel adminPanel1=new AdminPanel();
adminPanel1.userManagementOptions();
}
}