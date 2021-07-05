package inventorymanagementprogram;

import java.util.Scanner;

public class InventoryManagementMain
{
	public static final int ADD_ITEM = 1;
	public static final int REMOVE_ITEM = 2;
	public static final int UPDATE_VALUE = 3;
	public static final int GET_ALL_DETAILS = 4;
	public static final int GET_DETAILS_PARTICULAR_ITEM = 5;
	public static final int CALCULATE_VALUE_OF_EACH = 6;
	public static final int CALCULATE_TOTAL_VALUE = 7;
	public static final int QUIT = 8;


	public static void main(String[] args)
	{
		InventoryManagementService newItem = new InventoryManagementServiceImplementation();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Inventory Management System");
		while (true)
		{
			System.out.println("what you want to do ");
			System.out.println("1) Add items \n2) Remove item \n3) Update values \n4) Get details"
					+ " \n5) Get details of particular iteam \n6) Calculate value of each item"
					+ " \n7) Calculate total value \n8) Quit");
			System.out.println("Enter Your Choice ");

			int userChoice = scanner.nextInt();
			switch (userChoice)
			{
			//case to add item in inventory
			case ADD_ITEM:
			{
				System.out.println("Enter the number of items you want to add");
				int numberOfItems = scanner.nextInt();
				for ( int Quantity = 0; Quantity < numberOfItems; Quantity++) 
				{
					ItemsDetails item = new ItemsDetails();
					System.out.println("Enter the name of the item");
					item.setItemName(scanner.next().toUpperCase());
					System.out.println("Enter the weight of the item");
					item.setWeight(scanner.nextDouble());
					System.out.println("Enter the price of the item per Kg");
					item.setPricePerKg(scanner.nextDouble());
					newItem.addItem(item);		
				}
				break;

			}
			
			//case to remove item in inventory
			case REMOVE_ITEM:
			{
				System.out.println("Enter the name of the item which you want to Delete");
				newItem.deleteValue(scanner.next().toUpperCase());
				break;
			}
			
			//case to update value of item in inventory
			case UPDATE_VALUE:
			{
				ItemsDetails item = new ItemsDetails();
				System.out.println("Enter the name of the item which you want to update");
				item.setItemName(scanner.next().toUpperCase());
				System.out.println("Enter the weight of the item");
				item.setWeight(scanner.nextDouble());
				System.out.println("Enter the price of the item per Kg");
				item.setPricePerKg(scanner.nextDouble());
				newItem.updateValue(item);
				break;
			}
			
			//case to get all details in inventory
			case GET_ALL_DETAILS :
			{
				newItem.getDetails();
				break;
			}
			
			//case to get details of particular item
			case GET_DETAILS_PARTICULAR_ITEM :
			{
				System.out.println("Enter the name of the item which you want to update");
				newItem.getDetailsByName(scanner.next().toUpperCase());
				break;
			}
			
			//case to calculate value of each item
			case CALCULATE_VALUE_OF_EACH:
			{
				newItem.calculateValueOfEachItem();
				break;
			}

			//case to calculate value of all the items
			case CALCULATE_TOTAL_VALUE:
			{
				newItem.getTotalValue();
				break;
			}
			
			//case to exit program
			case QUIT:
			{
				System.out.println("Thanks for using us");
				scanner.close();
				System.exit(0);
				break;
			}

			default:
				System.out.println("Enter Corret option");

			}

		}

	}
}
