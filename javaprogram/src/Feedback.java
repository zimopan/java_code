public class Feedback {
    String firstName;
    String lastName;
    String email;
    String completeFeedback;
    String reviewID;
    String sent1;
    String sent2;
    String sent3;
    String sent4;
    String sent5;
    String concatenatedFeedback;

    boolean longFeedback;
    boolean isConcatenation;
    

    public Feedback(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public Feedback(){
        
    }
    public void analyseFeedback(boolean isConcatenation,String sent1,String sent2,String sent3,String sent4,String sent5){
        if(isConcatenation==true){
            completeFeedback=feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
            boolean islong=checkFeedbackLength(completeFeedback);
            createReviewID(firstName,lastName,completeFeedback);

        }
        else if(isConcatenation==false){
            completeFeedback=feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
            boolean islong=checkFeedbackLength(completeFeedback);
            createReviewID(firstName,lastName,completeFeedback);

        }
    }
    private String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String sent4,String sent5){
            concatenatedFeedback=sent1+sent2+sent3+sent4+sent5;
            return concatenatedFeedback;
    }
    private StringBuilder feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String sent4,String sent5)
    {
        StringBuilder sb=new StringBuilder();
        sb.append(sent1).append(sent2).append(sent3).append(sent4).append(sent5);
        return sb;
    }

    private boolean checkFeedbackLength(String completeFeedback){
        boolean length;
        if(completeFeedback.length()>500)
        {length=true;}
        else 
        {length=false;}
        return length;
        }

       
    public void createReviewID(String firstName, String lastName, String completeFeedback) {
    String namePart = (firstName + lastName).substring(2, 6).toUpperCase();
    String feedbackPart = completeFeedback.substring(10, 15).toLowerCase();
    int length = completeFeedback.length();
    long timeStamp = System.currentTimeMillis();
    
    String reviewID = namePart + feedbackPart + length + "_" + timeStamp;
    reviewID = reviewID.replace(" ", "");
}
public String toString() {
    return firstName + " " + lastName + " " + email + " " + completeFeedback + " " + longFeedback + " " + reviewID;
}

    }

