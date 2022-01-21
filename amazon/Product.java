import java.util.ArrayList;

public class Product 
{
    String productName;
    Integer quantity;
    String sellername;
    String ProductReview;
    Integer productRating;
    Integer price;
    Integer WarrentyPeriod;
    Integer returnPeriod;

    public Product(String productName, Integer quantity, String productReview,
    Integer productRating, Integer price, Integer warrentyPeriod, Integer returnPeriod, String sellername) {
        this.productName = productName;
        this.quantity = quantity;
        this.ProductReview = productReview;
        this.productRating = productRating;
        this.price = price;
        WarrentyPeriod = warrentyPeriod;
        this.returnPeriod = returnPeriod;
        this.sellername = sellername;
    }

        public static void addProduct(Merchant merchant) 
        {
            int i = 1;
            while (i != 0) 
            {
                System.out.print("Enter Product Name : ");
                String productName = Main.sc.nextLine();
                System.out.print("Enter Quantity :");
                Integer quantity = Integer.parseInt(Main.sc.nextLine());
                System.out.print("Product Description :");
                String productReview = Main.sc.nextLine();
                System.out.print("Enter Prouct Rating : ");
                Integer productRating = Integer.parseInt(Main.sc.nextLine());
                System.out.print("Price : ");
                Integer price = Integer.parseInt(Main.sc.nextLine());
                System.out.print("Enter Warrenty Period : ");
                Integer warrentyPeriod = Integer.parseInt(Main.sc.nextLine());
                System.out.print("Enter Return Period :");
                Integer returnPeriod = Integer.parseInt(Main.sc.nextLine());
                Main.prodList.add(new Product(productName, quantity, productReview, productRating, price, warrentyPeriod,
                        returnPeriod, merchant.username));
                System.out.print("Do you want to add one more product \n\n press 1 if yes else 0");
                i = Integer.parseInt(Main.sc.nextLine());
            }
            Merchant.merchantChoice(merchant);
        }

        
        
        public static void viewProductDetails(Merchant merchant)
         {

            ArrayList<Product> tp = new ArrayList<>();
    
            for (int i = 0; i < Main.prodList.size(); i++)
             {
                if (Main.prodList.get(i).sellername.equals(merchant.username)) 
                {
                    tp.add(Main.prodList.get(i));
                }
            }
    
            if (tp.isEmpty()) 
            {
                System.out.println("You Don't have any product Selling on Amazon\n\nPress enter to continue");
                Main.sc.nextLine();
            }
            else 
            {
                System.out.println("-----Your Products-----");
                for (int i = 0; i < tp.size(); i++, System.out.println()){
                    System.out.println("Product name : " + tp.get(i).productName);
                    System.out.println("Quantity Available : " + tp.get(i).quantity);
                    System.out.println("Product Rating : " + tp.get(i).productRating);
                    System.out.println("Product Price: " + tp.get(i).price);
                    System.out.println("Product Warrenty Period : " + tp.get(i).WarrentyPeriod);
                    System.out.println("Product Product Return period : " + tp.get(i).returnPeriod);
                    System.out.print("Press 0 to continue");
                    
            
                }
            }
    
            Merchant.merchantChoice(merchant);
}
}

