package com.bridgelabz.stockaccount;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockServiceImplementation implements StockServices
{
	LinkedList <StockDetails> stockslist = new LinkedList<StockDetails>();
	Stack<String> stockTransaction = new Stack<String>();
	Queue<String> stockTimeStamp = new LinkedList<String>();

	@Override
	//method to add stocks 
	public void addStock(StockDetails stock)
	{
		if (ItemAlreadyPresent(stock))
		{
			System.out.println("Item already exsists you can try update option to chenge the value");
		}
		else
		{	
			stockslist.add(stock);
			System.out.println(stock.getStockName() +" Added sucessfully");
			String transaction = "Added : The "+ stock.getNumberofShare() +" of stock "+stock.getStockSymbol();
			stockTransaction.push(transaction);
			stockTimeStamp.add(transaction +" at " +getCurrentTime());
		}
	}
	//method to check stock already present 
	private boolean ItemAlreadyPresent(StockDetails stock)
	{
		boolean check = false ; 
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockName().equals(stock.getStockName()))
			{			
				check = true;
				break;
			}
		}
		return check;
	}

	@Override
	//method to get all details in stock account
	public void getDetails() 
	{
		System.out.println("Stocks in the Inventory are ");
		int i = 1;
		for (StockDetails stocks : stockslist) 
		{
			System.out.println((i++)+") "+stocks);
		}

	}

	@Override
	//method to get details of particular stock account
	public void getDetailsByName(String stockName) 
	{
		boolean found = false;
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockName().equals(stockName))
			{			
				System.out.println("Stock found : "+stocks);
				found = true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("Stock not found");			
		}

	}

	@Override
	//method to calculate value of each stock
	public void calculateValueOfEachItem()
	{
		for ( StockDetails stocks : stockslist) 
		{
			System.out.println("value of "+stocks.getStockName()+" is "+( stocks.getNumberofShare()*stocks.getPricePerShare() ) );
		}

	}

	@Override
	//method to calculate value of all the stocks
	public void getTotalValue() 
	{
		double totalValue = 0;

		for (StockDetails stocks : stockslist) 
		{
			totalValue += stocks.getNumberofShare()*stocks.getPricePerShare();
		}
		System.out.println("Total values of all stocks are "+totalValue);

	}
	@Override
	//method to buy stocks
	public void sellStocks( String symbol,int amount) 
	{
		boolean checkItem = false;
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockSymbol().equals(symbol))
			{	
				stocks.setNumberofShare(stocks.getNumberofShare()+amount);
				String transaction = "Sold :  The "+ amount +" of stock "+stocks.getStockSymbol();
				stockTransaction.push(transaction);
				stockTimeStamp.add(transaction +" at " +getCurrentTime());
				checkItem = true;
			}
		}
		if(checkItem)
		{
			System.out.println("The "+ amount +" stock of "+symbol +" Sold successfully");			
		}
		else
		{
			System.out.println("stock not found try adding your stock using add stock");
		}

	}
	@Override
	//method to sell stocks
	public void  buyStocks(int amount,String symbol) {
		boolean checkItemRemoved = false;
		String transaction = null;
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockSymbol().equals(symbol))
			{
				if(stocks.getNumberofShare() - amount > 0)
				{					
					stocks.setNumberofShare(stocks.getNumberofShare() - amount);
					transaction = "Purchased : The "+ amount +" of stock "+stocks.getStockSymbol();
					checkItemRemoved = true;
				}
				else if (stocks.getNumberofShare() - amount == 0) 
				{
					transaction = "Purchased : The "+ amount +" of stock "+stocks.getStockSymbol();
					stockslist.remove(stocks);
					checkItemRemoved = true;
				}
			}
		}
		if(checkItemRemoved)
		{
			System.out.println("The "+ amount +" stock of "+symbol +" Purchased successfully");
			stockTransaction.push(transaction);
			stockTimeStamp.add(transaction +" at " +getCurrentTime());
		}
		else
		{
			System.out.println("stock not buyed because company dont have enough shares");
		}
	}
	@Override
	//method to show past transaction
	public void getTrasaction() 
	{
		for (String trasaction : stockTransaction)
		{
			System.out.println(trasaction);
		}
	}
	@Override
	//method to show past transaction by time stamp 
	public void getTimestamp() 
	{  
		for (String timestamp : stockTimeStamp)
		{
			System.out.println(timestamp);
		}
	}
	//method to get current time
	private java.util.Date getCurrentTime()
	{
		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis);
		return date;
	}

}
