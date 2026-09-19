import java.util.*;

class Vehicle {

	int id ;
	int rental_rate;
	boolean isAvail = true;


	Vehicle (int id, int rental_rate)
	{

		this.id = id;
		this.rental_rate = rental_rate;
	}

	String getType()
	{
		return "Vehicle";
	}


}

class Car extends Vehicle
{
	Car(int id, int rental_rate)
	{
		super(id,rental_rate);
	}
	String getType()
	{
		return "Car";
	}


}

class Bike extends Vehicle
{
	Bike(int id, int rental_rate)
	{
		super(id,rental_rate);
	}
	String getType()
	{
		return "Bike";
	}


}

class Truck extends Vehicle
{
	Truck(int id, int rental_rate)
	{
		super(id,rental_rate);
	}
	String getType()
	{
		return "Truck";
	}

}

public class Main
{
	static   Scanner sc = new Scanner(System.in);
	static HashMap <Integer, Vehicle > map = new HashMap <> ();

	public static void main(String[] args) {


		int n = sc.nextInt();

		for(int i=0 ; i<n ; i++)
		{
			String str = sc.next();

			if(str.equals("ADD_CAR"))
			{
				ADD_CAR ();
			}
			else if(str.equals("ADD_BIKE"))
			{
				ADD_BIKE ();
			}
			else if(str.equals("ADD_TRUCK"))
			{
				ADD_TRUCK ();
			}
			else if(str.equals("INFO"))
			{
				INFO();
			}
			else if(str.equals("RENT"))
			{
				RENT();
			}
			else if(str.equals("RETURN"))
			{
				RETURN();
			}
		}


	}

	public static void  ADD_CAR()
	{

		int id  = sc.nextInt();
		int rental_rate = sc.nextInt();

		Vehicle v1 = new Car(id,rental_rate);

		map.put(id,v1);

		System.out.println(v1.getType() + " " + id  + " added");
	}
	public static void ADD_BIKE()
	{

		int id  = sc.nextInt();
		int rental_rate = sc.nextInt();

		Vehicle v1 = new Bike(id,rental_rate);

		map.put(id,v1);

		System.out.println(v1.getType() + " " +id  + " added");

	}
	public static void ADD_TRUCK()
	{

		int id  = sc.nextInt();
		int rental_rate = sc.nextInt();

		Vehicle v1 = new Truck(id,rental_rate);

		map.put(id,v1);

		System.out.println(v1.getType() + " " +id  + " added");

	}

	public static void INFO()
	{
		int id  = sc.nextInt();
		Vehicle v1 = map.get(id);

		if(!map.containsKey(id))
		{
			System.out.println("Vehicle not found");
		}
		else
		{
			System.out.print(v1.id + " " + v1.getType() + " " + v1.rental_rate + " ");

			if(v1.isAvail)
			{
				System.out.println("AVAILABLE");
			}
			else
			{
				System.out.println("RENTED");

			}

		}
	}
	public static void RENT()
	{
		int id  = sc.nextInt();
		int days = sc.nextInt();

		Vehicle v1 = map.get(id);

		if(!map.containsKey(id))
		{
			System.out.println("Vehicle not found");
		}
		else
		{
			if(!v1.isAvail)
			{
				System.out.println("Vehicle already rented");

			}
			else
			{
				int total = v1.rental_rate * days;
				System.out.print(v1.getType() + " rented, Cost: " + total );
				v1.isAvail = false;

			}
		}

	}

	public static  void RETURN()
	{
		int id  = sc.nextInt();

		if(!map.containsKey(id))
		{
			System.out.println("Vehicle not found");
		}
		else
		{
		    Vehicle v1 = map.get(id);

			if(v1.isAvail)
			{
				System.out.println("Vehicle already available");
			}
			else
			{
				v1.isAvail = true;
				System.out.println(v1.getType() + " returned");
			}
		}

	}



}