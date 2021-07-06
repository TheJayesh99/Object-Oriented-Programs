package com.bridgelabz.inventorymanagement;

public interface InventoryManagementService 
{

	//method to add item in inventory
	public  void addItem(ItemsDetails item);
	//method to get all details in inventory
	public void getDetails();
	//method to get details of particular item
	public void getDetailsByName(String itemName);
	//method to calculate value of each item
	public void calculateValueOfEachItem();
	//method to calculate value of all the items
	public void getTotalValue();
	//method to update value of item in inventory
	public void updateValue(ItemsDetails updateItem);
	//method to remove item in inventory
	public void deleteValue(String  deleteItem);
}
