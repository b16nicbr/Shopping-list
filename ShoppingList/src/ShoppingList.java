import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {

	private int item_id;
	private String item_name;
	private int item_quantity;
	private double item_price;
	private double totalPrice;
	
	ShoppingList(int item_id, String item_name, int item_quantity, double item_price, double totalPrice){
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
		this.totalPrice = totalPrice;
	}
	//getters
	public int getItem_id() {
		return item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public double getItem_price() {
		return item_price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public static void displayFormat()   
    {  
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");  
        System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");  
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");  
    }  
       
    // display  
    public void display()   
    {  
        System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,item_id, item_name, item_quantity, item_price, totalPrice);  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the shopping list!");
		
		int id = 0;
		String name = null;
		int quantity = 0;
		double price = 0;
		double totalPrice = 0;
		double overallPrice = 0;
		char moreProducts = ' ';
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name: ");
		String customerName = sc.nextLine();
		List<ShoppingList>shoppinglist = new ArrayList<ShoppingList>();
		do {
			System.out.println("Please place your order " + customerName);
			System.out.println("Enter products information!");
			System.out.println("Enter ID:");
			id = sc.nextInt();
			System.out.println("Enter item name:");
			name = sc.next();
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			System.out.println("Enter price:");
			price = sc.nextDouble();
			totalPrice = price * quantity;
			overallPrice = overallPrice + totalPrice;
			shoppinglist.add(new ShoppingList(id, name, quantity, price, totalPrice));
			System.out.println("Do you want to enter more products (y/n)");
			moreProducts = sc.next().charAt(0);
			sc.nextLine();
		}while(moreProducts == 'y' || moreProducts == 'Y');
		ShoppingList.displayFormat();
		for(ShoppingList sh: shoppinglist) {
			sh.display();
		}
		System.out.println("-----------------------------------------------Overll price for billing " + overallPrice);
	}

}
