import java.util.Scanner;

class BankAccount
{
   private String accountHolderName;
    private String accountNumber;
    private double balance;

     public void setAccountHolderName(String accountHolderName)
     {
           this.accountHolderName = accountHolderName;
     }
      public void setAccountNumber(String accountNumber)
     {
           this.accountNumber = accountNumber;
     }

      public String getAccountHolderName ()
     {
              return accountHolderName;
     }

     public String getAccountNumber ()
     {
       return accountNumber;
     }
    
     
   public void deposit(double amount)
    {
        
          balance += amount;  
          System.out.println(balance);
    }
    public void  withdraw(double withdrawing)
    {
        if(withdrawing <= balance)
        {
          balance -= withdrawing;  
        System.out.println(balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }


    }

    public void checkBalance()
    {
           System.out.println(balance);
    }

    public void displayAccountInfo()
    {
       

              System.out.println(accountHolderName);
              System.out.println(accountNumber);
              System.out.println(balance);
    }
}

class Main
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter details:");

        System.out.println("Enter AccountHolderName");
        String accountHolderName =sc.nextLine();
        
        System.out.println("Enter AccountNumber");
        String accountNumber=sc.nextLine();

      

        BankAccount a1 = new BankAccount();
        a1.setAccountHolderName(accountHolderName);
        a1.setAccountNumber(accountNumber);


        while (true) {
            System.out.println("1. deposit");
            System.out.println("2. withdraw");
            System.out.println("3. check balance");
            System.out.println("4. displayAccount info");
            System.out.println("5. Exit");

            System.out.println("Enter choice");
            int choice = sc.nextInt();

            if(choice == 1)
            {
                System.out.println("Enter Amount");
                double amount= sc.nextDouble();
                 a1.deposit(amount);
            }

             else if(choice == 2)
            {
                System.out.println("Enter withdraw Amount");
                double withdrawing= sc.nextDouble();
                 a1.withdraw(withdrawing);
            }
             else if(choice == 3)
            {
                System.out.println("Checking balance");
                 a1.checkBalance();
            }
            else if(choice == 4)
            {
                System.out.println("Displaying Account Information");
                 a1.displayAccountInfo();
            }
            else if(choice == 5)
            {
                return ;
            }

        }
    }
}