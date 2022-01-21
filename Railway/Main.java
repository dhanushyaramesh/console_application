import java.util.*;

public class Main{

    static ArrayList<User> users = new ArrayList<>();

   

    public static Scanner sc = new Scanner(System.in);
    static void home(){
         System.out.println("1.new User");
         System.out.println("2.existing user");
         int opt= sc.nextInt();
         if(opt==1){
            User.signUp();
        }
        else if(opt==2){
            User.login();
        }
    }
    public static void main(String[] args) {
        home();
    }
}