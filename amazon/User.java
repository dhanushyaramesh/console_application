public class User {

    static String[] id = {"dhanushya","sakthi"};
    static int[] pass = { 0000,1111};


    static void user()
    {
        System.out.println("----- User login -----");
        System.out.println("Enter 1 --> new User");
        System.out.println("Enter 2 --> Existing User");
        System.out.println("Enter 3 --> Exit");
        System.out.println("Enter a number : ");
        int num = Integer.parseInt(Main.sc.nextLine());
        switch(num)
        {
            case 1:
            newUser();
            break;
            case 2:
            break;
            case 3:
            break;

        }
    }



    static void newUser()
    {
        System.out.println("----- SIGNUP -----");
        System.out.println("Enter your name:");
        String name = Main.sc.nextLine();
        System.out.println("Enter Password");
        int pwd = Main.sc.nextInt();
        for(int i=0;i<name.length();i++){
            if(name.equals(id[i]) && pwd ==pass[i])
            {
                System.out.println("signUp Successfull !");

            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }
    
}
