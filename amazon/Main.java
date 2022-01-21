
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Product> prodList = new ArrayList<>();
   static ArrayList<Merchant> merchants = new ArrayList<>();

    static Scanner sc;
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int a = 0;
        do{
        System.out.println("----- AMAZON SHOPPING -----");
        System.out.println("-------- Welcome -------");
        System.out.println("Enter 1 --> Admin Login");
        System.out.println("Enter 2 --> Merchant Login");
        System.out.println("Enter 3 --> User Login");
        System.out.println("Enter 4 --> Exit");
        System.out.print("Enter your choice : ");
        a = Integer.parseInt(sc.nextLine());
        switch (a) {
            case 1:
            Admin.login();
                break;
            case 2:
                Merchant.login();
                break;
            case 3:
                User.user();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid input");
        }
    }
    while(true);

    }
}
