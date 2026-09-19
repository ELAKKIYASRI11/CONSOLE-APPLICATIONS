import java.util.*;

// Interface
interface Sellable {

	abstract float sellItem (int quantity);
}

// Parent class
class Product {

	int id;
	String name ;
	int price ;
	int quantity ;

	Product(int id, String name, int price, int quantity)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;

	}
}

// child class 1
class Electro extends Product implements Sellable {

	Electro (int id, String name, int price, int quantity)
	{
		super(id,name,price,quantity);
	}

	public float sellItem(int quantity)
	{
		int total = price * quantity;
		return total;

	}
}

// child class 2

class Grocery extends Product implements Sellable {

	Grocery (int id, String name, int price, int quantity)
	{
		super(id,name,price,quantity);
	}

	public float sellItem(int quantity)
	{
		int total =price * quantity;
		return total;

	}
}


// MAIN CLASS

public class Main {

	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Product > map = new HashMap <> ();

	public static void main(String[] args)
	{
		int n = sc.nextInt();

		for(int i=0 ; i<n ; i++)
		{
			String str = sc.next();

			// Adding Electronics
			if(str.equals("ADD_ELECTRO"))
			{
				int id = sc.nextInt();
				String name = sc.next();
				int price = sc.nextInt();
				int quantity = sc.nextInt();

				Electro e1 = new Electro(id,name,price,quantity);

				map.put(id,e1);

				System.out.println("Item added: " + name);
			}
			// Adding grocery

			else if(str.equals("ADD_GRO"))
			{
				int id = sc.nextInt();
				String name = sc.next();
				int price = sc.nextInt();
				int quantity = sc.nextInt();

				Grocery g1 = new Grocery(id,name,price,quantity);

				map.put(id,g1);

				System.out.println("Item added: " + name);

			}
			// Selling

			else if(str.equals("SELL"))
			{
				int id = sc.nextInt();
				int quantity = sc.nextInt();

				if(!map.containsKey(id))
				{
					System.out.println("Item not found");
				}
				else if(map.get(id).quantity < quantity)
				{
					System.out.println("Insufficient stock");

				}
				else {
					Sellable item = (Sellable) map.get(id);

					float total = item.sellItem(quantity);
					map.get(id).quantity -= quantity;

					System.out.printf("%.2f", total);
				}

			}
			// Stock level
			else if(str.equals("STOCK"))
			{
				int id  = sc.nextInt();
				if(!map.containsKey(id))
				{
					System.out.println("Item not found");
				}
				else {

					System.out.println(map.get(id).quantity + " " + map.get(id).name + " " + map.get(id).price);
				}


			}




		}
	}
}


