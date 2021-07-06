package com.bridgelabz.inventorymanagement;

public class ItemsDetails
{

	//required specification for a product
	private String itemName;
	private double weight;
	private double pricePerKg;

	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}
	public double getWeight() 
	{
		return weight;
	}
	public void setWeight(double weight) 
	{
		if (weight > 0)
		{			
			this.weight = weight;
		}
		else
		{
			System.err.println("Weight cannot less than or equal to zero");
		}
	}
	public double getPricePerKg() 
	{
		return pricePerKg;
	}
	public void setPricePerKg(double pricePerKg) 
	{
		if(pricePerKg > 0)
		{			
			this.pricePerKg = pricePerKg;
		}
		else
		{
			System.err.println("Price per Kg cannot less than or equal to zero");
		}
	}
	@Override
	public String toString() {
		return "ItemsDetails [itemName=" + itemName + ", weight=" + weight + ", pricePerKg=" + pricePerKg + "]";
	}
	
}
