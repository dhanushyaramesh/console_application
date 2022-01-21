public class Admin
 {
    static void login()
     {
        System.out.print("\033[H\033[2J");
        System.out.println("---- ADMIN LOGIN ----");
        System.out.print("Enter Username : ");
        String uname = Main.sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = Main.sc.nextLine();
        if (uname.equals("admin") && pass.equals("12345")) 
        {
            adminpage();
        }
    }


     

    static void adminpage()
     {

        System.out.println("Enter 1 --> Approval or Rejection");
        System.out.println("Enter 2 --> Add or Remove Merchant");
        System.out.println("Enter 3 --> Exit");
        int n = Integer.parseInt(Main.sc.nextLine());
        if (n == 1) 
        {
            approval();
        } else if (n == 2) 
        {
            addOrrem();
        }
        else if(n==3)
         {
        return;
        }
    }

    public static void approval() {
        for (int i = 0; i < Main.merchants.size(); i++ , System.out.print("\033[H\033[2J")) {
            if (Main.merchants.get(i).status.equals("Pending")) {
                System.out.print("\033[H\033[2J");
                System.out.println("User name : " + Main.merchants.get(i).username);
                System.out.println("Enter 1 --> To Approve the merchant");
                System.out.println("Enter 2 --> To Reject the merchant");
                int n = Integer.parseInt(Main.sc.nextLine());
                if (n == 1) {
                    System.out.print("\033[H\033[2J");
                    Main.merchants.get(i).status = "Approved";
                    System.out.printf("Merchant \"%s\" has been Approved Successfully !\n", Main.merchants.get(i).username);
                    System.out.println("Press enter to continue");
                    Main.sc.nextLine();
                    continue;
                } else {
                    Main.merchants.get(i).status = "Rejected";
                    System.out.println("User Rejected");
                    System.out.println("Press enter to continue");
                    Main.sc.nextLine();
                }
            }
        }
        System.out.println("Merchants Waiting for Approval :- 0");
        adminpage();
    }

    public static void addOrrem() {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter 1 --> Add a vendor");
        System.out.println("Enter 2 --> Remove a vendor");
        System.out.println("Enter 3 --> Exit");
        int opt = Integer.parseInt(Main.sc.nextLine());
        if (opt == 1) {
            addAvendor();
        } else if (opt == 2) {
            removeAvendor();
        } else if (opt == 3) {
            return;
        } else {
            System.out.println("Incorrect Choice");
            addOrrem();
        }
    }

    public static void addAvendor() {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Username : ");
        String username = Main.sc.nextLine();
        System.out.print("Enter Password :  ");
        String password = Main.sc.nextLine();
       
        Main.merchants.add(new Merchant(username, password, "Approved"));
        System.out.println("Merchant added successfully !");
        addOrrem();
    }

    public static void removeAvendor() {
        System.out.println("Enter Username of the User to be removed :");
        String s = Main.sc.nextLine();
        for (int i = 0; i < Main.merchants.size(); i++) {
            if (Main.merchants.get(i).username.equals(s)) {
                Main.merchants.get(i).status = "Deactivated\nContact Admin";
            }
            System.out.println("Merchant removed successfully !");
        }
        addOrrem();
    }

}