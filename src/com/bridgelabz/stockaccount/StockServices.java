package com.bridgelabz.stockaccount;

public interface StockServices 
{
	//method to add stocks 
	public  void addStock(StockDetails stock);
	//method to get all details in stock account
	public void getDetails();
	//method to get details of particular stock account
	public void getDetailsByName(String stockName);
	//method to calculate value of each stock
	public void calculateValueOfEachItem();
	//method to calculate value of all the stocks
	public void getTotalValue();
	//method to buy stocks
	public void buyStocks(int amount , String symbol);
	//method to sell stocks
	public void sellStocks(String sellStocks,int amount);
	//method to show past transaction
	public void getTrasaction();
	//method to show past transaction by time stamp 
	public void getTimestamp();
	
}
