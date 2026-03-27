import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Auditor {
    private int frequencyRating;
    private int amountRating;
    private int locationRating;
    private int oddHoursRating;
    private int compositeRating;
    private int riskLevel;
    private String riskTitle;
    private String actionToTake;
    private String accountNumbertoc;
    private String accountNumber;
    private LocalDateTime[] samectranstrantime=new LocalDateTime[21];
    Duration duration;
    Duration totalduration=Duration.ZERO;
    RiskEnum riskEnum;

    public int getFrequencyRating(){
        return frequencyRating;
    }
    public int getAmountRating(){
        return amountRating;
    }
    public int getLocationRating(){
        return locationRating;
    }
    public int getOddHoursRating(){
        return oddHoursRating;
    }
    public int getCompositeRating(){
        return compositeRating;
    }
    public int getRiskLevel(){
        return riskLevel;
    }
    public String getRiskTitle(){
        return riskTitle;
    }
    public String getActionToTake(){
        return actionToTake;
    }
    

    public void accountNumberInput(){
        for(AccountsEnum accountsEnum:AccountsEnum.values()){
            System.out.println(accountsEnum);
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter the accountnumber:");
        accountNumbertoc=scanner.nextLine();
        for(AccountsEnum accountsEnum:AccountsEnum.values()){
            if(accountNumbertoc.equals(accountsEnum.getAccountNumber()))
            {
            accountNumber=accountNumbertoc;
            auditTransactions(accountNumber);
            }
            else
            {
            System.out.println("enter the correct number:");
            accountNumbertoc=scanner.nextLine();
            }
        }

        scanner.close();
    }

   


    public void auditTransactions(String accountNumber){
        
        
        evaluateFrequency(accountNumbertoc);
        evaluateAmount(accountNumbertoc);
        evaluateLocation(accountNumbertoc);
        evaluateOddHour(accountNumbertoc);
        compositeRating=frequencyRating+amountRating+locationRating+oddHoursRating;
        evaluateRiskLevel(compositeRating);
        
    }




    private void evaluateFrequency(String accountNumbertoc){
        
        int i=0;
        for(TransactionsEnum transactionsEnum:TransactionsEnum.values())
        {
            
            if(accountNumbertoc.equals(transactionsEnum.getAccountNumber()))
                {
                    LocalDateTime time=LocalDateTime.parse(transactionsEnum.getTimestamp());
                    samectranstrantime[i]=time;
                    i+=1;
                }
        }
        for(int a=0;a<i-1;a++)
        {duration=Duration.between(samectranstrantime[i], samectranstrantime[i+1]);
            totalduration=totalduration.plus(duration);
            long durationmin=totalduration.toMinutes();
            if(durationmin<=1440)
            {
                frequencyRating+=5;
            }
            else if(durationmin>1440&&durationmin<=2880)
            {frequencyRating+=2;}
        }
    }
    


    private void evaluateAmount(String accountNumbertoc){
        double singleamount;
        
        for(TransactionsEnum transactionsEnum:TransactionsEnum.values())
        {
            if(accountNumbertoc.equals(transactionsEnum.getAccountNumber()))
                {
                  singleamount=transactionsEnum.getAmount();  
                if(singleamount>5000)
                    {
                        amountRating+=5;
                    }
                else if(singleamount>100&&singleamount<500)
                {
                    amountRating+=1;
                }
                }
        }
    }


    private void evaluateLocation(String accountNumbertoc){
        
        for(TransactionsEnum transactionsEnum:TransactionsEnum.values())
        {
            if(accountNumbertoc.equals(transactionsEnum.getAccountNumber()))
                {
                if(transactionsEnum.getTransactionType().equals("International"))
                    {
                        locationRating+=5;
                    }
                
                }
        }
        }


        private void evaluateOddHour(String accountNumbertoc){
            
        for(TransactionsEnum transactionsEnum:TransactionsEnum.values())
            {
            if(accountNumbertoc.equals(transactionsEnum.getAccountNumber()))
                {
                String time=transactionsEnum.getTimestamp();
                String hour=time.substring(12,14); 
                int hourint=Integer.valueOf(hour);
                if(hourint<6||hourint>22)
                {
                    oddHoursRating+=5;
                }
                }
            }
        }

        

        private void evaluateRiskLevel(int compositeRating){
            if(compositeRating<40)
            {
               riskEnum=RiskEnum.NO_RISK;            
            }
            else if(compositeRating<50)
            {
                riskEnum=RiskEnum.NEGLIGIBLE_RISK;
            }
            else if(compositeRating<60)
            {
                riskEnum=RiskEnum.LOW_RISK;
            }
            else if(compositeRating<70)
            {
                riskEnum=RiskEnum.MEDIUM_RISK;
            }
            else if(compositeRating<85)
            {
                riskEnum=RiskEnum.HIGH_RISK;
            }
            else
            {
                riskEnum=RiskEnum.CRITICAL;
            }
            riskLevel=riskEnum.getRiskLevel();
            riskTitle=riskEnum.getRiskTitle();
            actionToTake=riskEnum.getActionToTake();
        }

        @Override
        public String toString()
        {
            return "Risk Audit Result:\n"+
            "Transaction Frequency Risk:"+frequencyRating+"\n"+
            "Transaction Amount Risk:"+amountRating+"\n"+
            "Transaction Location Risk:"+locationRating+"\n"+
            "Transaction Timing Risk:"+oddHoursRating+"\n"+
            "Composite Risk:"+compositeRating+"\n"+
            "Estimated Risk Level:"+riskLevel+"\n"+
            "Overall Risk:"+riskTitle+"\n"+
            "Recommended Action:"+actionToTake+"\n"+
            "NOTE: Lower values are better.";
        }

        


}
