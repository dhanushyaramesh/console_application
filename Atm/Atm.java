import java.util.*;
class Solution
{
    private static Scanner sc =new Scanner(System.in);
    
    static int[] locker={30,30,30,30};

    static int[] den={2000,500,200,100};

    static int[] balance={40000,20000,30000,60000};
    
    static int total;
    
    static int ch,tp,attempt=0;
    static int pin=1234;

    static void home()
    {
        while(true)
        {
        System.out.println("!!!  WELCOME  !!!");
            System.out.println("---------ATM Machine---------");
            System.out.println("Enter 1 -> Admin Login");
            System.out.println("Enter 2 -> User Login");
            System.out.println("Enter 3 -> Exit");
            System.out.print("Enter your choice: ");
            
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("\033[H\033[2J");
                admin();  
                break;
                case 2:
                System.out.println("\033[H\033[2J");
                user();
                break;
                case 3:
                System.out.println("Invalid Input");
                break;
            }
        }
    }
    
    
    static void admin()
    {
        System.out.println("Enter user id ");
                String user=sc.next();
                System.out.println("Enter password ");
                int pwd=sc.nextInt();
                if(user.equals("dhanushya") && pwd==1234)
                {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Admin logged successfully!");
    
                }
                else if(user.equals("Admin2")&& pwd==1234)
                {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Admin logged successfully!");
                }
                else 
                {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Invalid Input");return;
                }
                adminpage();
            }

            
            
    static void adminpage()
    {
        System.out.println("Enter 1 -> add money");
        System.out.println("Enter 2 -> view balance");
           System.out.println("Enter 3 -> exit");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    addMoney();
                }
                else if(choice==2)
                {
                  viewBal();
                }
                else if(choice ==3)
                {
                   home();
                }
            }
            
    
    
    static void viewBal()
    {
        int n=0;
        for(int i=0;i<locker.length;i++)
        {
            System.out.println(den[i]+"-->"+(locker[i]));
            n=n+(locker[i]*(den[i]));
        }
    System.out.print("Your balance: ");
    System.out.println(n); 
    adminpage();
    }

    
    
    static void addMoney()
    {
        System.out.println("Enter Denominations");
        for(int i=0;i<4;i++)
        {
            System.out.print(den[i]+"-->");
            locker[i]=locker[i]+sc.nextInt();
        }
        System.out.println("\033[H\033[2J");
        System.out.println("Amount Added Successfully!");
        System.out.println("Do you want to view you current balance : ");
        System.out.println("if yes enter y else n");
        String opt=sc.next().charAt(0)+"";
        if(opt.equals("y"))
        {
            viewBal();
        }
    }
    
    
    
    static void user()
    {
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter pin number: ");
        int pwd = sc.nextInt();
        if(name.equals("dhanushya") && pwd==1234)
        {
            total = balance[0];
            System.out.println("\033[H\033[2J");
            System.out.println("User login successfull !");
            useroptions();
        }
        else if(name.equals("sakthi") && pwd==1234)
        {
            total = balance[1];
            System.out.println("\033[H\033[2J");
            System.out.println("User login successful !");
            useroptions();
        }
        else if(name.equals("arun") && pwd==1234)
        {
            total = balance[2];
            System.out.println("\033[H\033[2J");
            System.out.println("User login successful !");
            useroptions();
        
        }
        else if(name.equals("agila") && pwd==1234)
        {
            total=balance[3];
            System.out.println("\033[H\033[2J");
            System.out.println("User login successful !");
            useroptions();
        }
        else{
            System.out.println("\033[H\033[2J");
            System.out.println("Invalid Input"); 
            attempt++;
            if(attempt!=3){
            user();
            }
            else{
                System.out.println("---- !! TRY AGAIN LATER !! ----");
            }
        }
        home();
    }
    
    
    static void useroptions()
    {
        System.out.println("Enter 1 --> withdraw");
        System.out.println("Enter 2 --> deposit");
        System.out.println("Enter 3 --> show balance");
        System.out.println("Enter 4 --> Pin change");
        System.out.println("Enter 5 --> exit");
        System.out.print("Enter your choice :  ");
        int select = sc.nextInt();
        if(select == 1)
        {
            withdraw();
        }
        else if(select == 2)
        {
            deposit();
            System.out.println("\033[H\033[2J");
            System.out.println("---- Deposit successfull ! ----");
            System.out.println("your total balance");
            System.out.println(tp);
            
        }
        else if(select == 3)
        {
            System.out.println("your balance : ");
            System.out.println(total);
            useroptions();
        }
        else if(select == 4)
        {
            System.out.println("Enter your current pin");
            int cpin=sc.nextInt();
            if(cpin==pin){
            System.out.println("Enter new pin");
            int npin = sc.nextInt();
            pin=npin;
            System.out.println("---- Pin changed sucessfully ----");
            }

        }
        else if(select == 5)
        {
            home();
        }
    }
   
    
    
    static void withdraw()
    {
        System.out.println("\033[H\033[2J");
        System.out.println("Enter a amount: ");
        int amount = sc.nextInt();
        if(amount<=total)
        {
            total = total - amount;
            System.out.println("\033[H\033[2J");
            System.out.println("Amount withdraw successfull !");
            System.out.println("Do you want to view your bank balance ?");
            System.out.println("if yes type 1 else 0");
            int bal = sc.nextInt();
            if(bal==1)
            {
                System.out.println("your balance : ");
                System.out.println(total);
                useroptions();
            }
            else if(bal==0)
            {
                useroptions();
            }
            else
            {
                System.out.println("Invalid input");
                return;
            }
        }
        else
        {
            System.out.println("Insufficent balance !");
            
        }

        while(amount!=0)
        {
            int n=0;
            if(amount>=2000)
            {
                n = amount/2000;
                amount = amount-(n*2000);
                locker[0]=locker[0]-n;
            }
            else if(amount>=500)
            {
                n=amount/500;
                amount = amount-(n*500);
                locker[1]=locker[1]-n;
            }
            else if(amount>=200)
            {
                n=amount/200;
                amount = amount-(n*200);
                locker[2]=locker[2]-n;
            }
            else if(amount>=100)
            {
                n=amount/100;
                amount =amount-(n*100);
                locker[3]=locker[3]-n;
            }
        }
        
    }


    static void deposit()
    {
        System.out.println("\033[H\033[2J");
        System.out.println("Enter Denominations");
        for(int i=0;i<4;i++)
        {
            
            System.out.print(den[i]+"-->");
            locker[i]+=sc.nextInt();
            tp+=(den[i]*(locker[i]));
        }
        
}
 




    public static void main(String args[])
    {
       home();
    }
}