public class User {
    String name;
    String pass;
    int id ;
    int amount=15000 ;
    static int x= 100 ;

    
    static void signUp(){
        System.out.println("username");
        String uname = Main.sc.next();
        System.out.println("password");
        String pwd = Main.sc.next(); 
        User userq = new User();
        userq.name=uname;
        userq.pass=pwd;
        userq.id=x;
        Main.users.add(userq);
        System.out.println("your id "+ x++ );
        Main.home();
     }

    static void login(){
        System.out.println("id");
        int id = Main.sc.nextInt();
        System.out.println("password");
        String pas= Main.sc.next();
        for(int i=0;i<Main.users.size();i++){
            if(Main.users.get(i).id==id){
                if(Main.users.get(i).pass.equals(pas)){
                    userPage();
                }
                else{
                    System.out.println("Invalid credentials");
                    login();
                }
            }

        }
    }

    static void userPage(){
        System.out.println("    -> Enter 1 for Train Ticket Booking");
        System.out.println("    -> Enter 2 to view/cancel Booked Tickets");
        System.out.println("    -> Enter 3 to view Wallet Amount");
        System.out.println("    -> Enter 4 to Logout");
        int sel = Main.sc.nextInt();
        if(sel == 1){
            // booking();
        }
        else if(sel==2){
            // viewcan();
        }
        else if(sel==3){
            // wallet();
        }
        else {
            Main.home();
        }



    }
}
