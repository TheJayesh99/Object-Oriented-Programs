package com.bridgelabz.inventorymanagement;

import java.util.LinkedList;




public class InventoryManagementServiceImplementation implements InventoryManagementService
{
	LinkedList <ItemsDetails> itemlist = new LinkedList<ItemsDetails>();
	@Override
	public void addItem(ItemsDetails item)
	{
		if (ItemAlreadyPresent(item))
		{
			System.out.println("Item already exsists you can try update option to chenge the value");
		}
		else
		{

			itemlist.add(item);
			System.out.println(item.getItemName() +" Added sucessfully");
		}

	}

	//method to check item already present or not
	private boolean ItemAlreadyPresent(ItemsDetails item)
	{
		boolean check = false ; 
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(item.getItemName()))
			{			
				check = true;
				break;
			}
		}
		return check;
	}

	@Override
	public void getDetails()
	{
		System.out.println("items in the Inventory are ");
		int i = 1;
		for (ItemsDetails item : itemlist) 
		{
			System.out.println((i++)+") "+item);
		}

	}

	@Override
	public void getDetailsByName(String itemName)
	{
		boolean found = false;
		for (ItemsDetails item : itemlist)
		{
			if (item.getItemName().equals(itemName))
			{			
				System.out.println("iteam found : "+item);
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("Item not found");			
		}
	}



	@Override
	public void calculateValueOfEachItem()
	{
		for (ItemsDetails item : itemlist) 
		{
			System.out.println("value of "+item.getItemName()+" of  " +item.getWeight() +" kg is "+( item.getWeight()*item.getPricePerKg() ) );
		}


	}

	@Override
	public void getTotalValue()
	{
		double totalValue = 0;

		for (ItemsDetails item : itemlist) 
		{
			totalValue += item.getWeight()*item.getPricePerKg();
		}
		System.out.println("Total values of all items are "+totalValue);


	}

	@Override
	public void updateValue(ItemsDetails updateItem)
	{
		boolean checkItem = false;
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(updateItem.getItemName()))
			{	
				items.setWeight(updateItem.getWeight());
				items.setPricePerKg(updateItem.getPricePerKg());
				checkItem = true;
			}
		}
		if(checkItem)
		{
			System.out.println("Updated successfully");			
		}
		else
		{
			System.out.println("Item not found");
		}
	}

	@Override
	public void deleteValue(String  deleteItem)
	{
		boolean checkItemRemoved = false;
		for (ItemsDetails items : itemlist)
		{
			if (items.getItemName().equals(deleteItem))
			{
				itemlist.remove(items);
				checkItemRemoved = true;
			}
		}
		if(checkItemRemoved)
		{
			System.out.println("Item "+deleteItem +" Deleted successfully");			
		}
		else
		{
			System.out.println("Item not found");
		}
	}
}
