public class Merchant {
    String username;
    String password;
    String status = "Pending";

    public Merchant(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Merchant(String username, String password, String status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public static void login() {
         System.out.print("\033[H\033[2J");
        System.out.println("Enter 1 --> Sign Up");
        System.out.println("Enter 2 --> Login");
        System.out.println("Enter 3 --> Exit");
        int n = Integer.parseInt(Main.sc.nextLine());
        if (n == 1) {
            MerchantSignUp();
        }
        if (n == 2) {
            MerchantLogin();
        }
        if (n == 3) {
            return;
        }
    }

    public static void MerchantSignUp() {
        System.out.print("\033[H\033[2J");
        System.out.println("------Merchant SignUp--------");
        System.out.print("Enter Username : ");
        String username = Main.sc.nextLine();
        System.out.print("Enter Password :  ");
        String password = Main.sc.nextLine();
        Main.merchants.add(new Merchant(username, password));
        System.out.println("-- Request pending ! waiting for approval --");
        System.out.println("Press Enter to continue");
        Main.sc.nextLine();
        login();
    }

    public static void MerchantLogin() {
        System.out.println("----------Merchant Login-------");
        System.out.print("Enter Username : ");
        String username = Main.sc.nextLine();
        int current = -1;
        for (int i = 0; i < Main.merchants.size(); i++) {
            if (Main.merchants.get(i).username.equals(username)) {
                current = i;
                break;
            }
        }
        if (current == -1) {
            System.out.println("User not found");
            login();
        }
        System.out.print("Enter Password :  ");
        String password = Main.sc.nextLine();
        if (Main.merchants.get(current).password.equals(password)) {
            if (Main.merchants.get(current).status.equals("Approved")) {
                System.out.println("Logged in Successfully");
                System.out.println("Press Enter to continue");
                Main.sc.nextLine();
                merchantChoice(Main.merchants.get(current));
            } else {
                System.out.println("Your approval Status : " + Main.merchants.get(current).status);
                Main.sc.nextLine();
                login();
            }
        } else {
            System.out.println("Incorrect Password !");
            Main.sc.nextLine();
            MerchantLogin();
        }

    }

    public static void merchantChoice(Merchant m){
        System.out.println("Enter 1 to add product");
        System.out.println("Enter 2 to view/change your product");
        System.out.println("Enter 3 to Remove a Product");
        System.out.println("Enter 4 to Logout");
        int n=Integer.parseInt(Main.sc.nextLine());
        if(n==1){
            Product.addProduct(m);
        }
        else if(n==2){
           Product.viewProductDetails(m);
        }
        else if(n==3){
           // Product.removeAProduct(m);
        }
        else{
            System.out.println("You've Logged out Successfully\n\nPress enter to continue");
            Main.sc.nextLine();
            login();
        }
    }
    

}
