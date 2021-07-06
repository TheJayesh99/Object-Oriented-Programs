package com.bridgelabz.stockaccount;

import java.util.LinkedList;
import java.util.Stack;

public class StockServiceImplementation implements StockServices
{
	LinkedList <StockDetails> stockslist = new LinkedList<StockDetails>();
	Stack<String> stockTransaction = new Stack<String>();

	@Override
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
			String transaction = "Purchased : The "+ stock.getNumberofShare() +" of stock "+stock.getStockSymbol();
			stockTransaction.push(transaction);
		}
	}
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
	public void calculateValueOfEachItem()
	{
		for ( StockDetails stocks : stockslist) 
		{
			System.out.println("value of "+stocks.getStockName()+" is "+( stocks.getNumberofShare()*stocks.getPricePerShare() ) );
		}

	}

	@Override
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
	public void buyStocks(int amount , String symbol) 
	{
		boolean checkItem = false;
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockSymbol().equals(symbol))
			{	
				stocks.setNumberofShare(stocks.getNumberofShare()+amount);
				String transaction = "Purchased :  The "+ amount +" of stock "+stocks.getStockSymbol();
				stockTransaction.push(transaction);
				checkItem = true;
			}
		}
		if(checkItem)
		{
			System.out.println("The "+ amount +" stock of "+symbol +" purchased successfully");			
		}
		else
		{
			System.out.println("stock not found try adding your stock using add stock");
		}

	}
	@Override
	public void sellStocks(String symbol,int amount) {
		boolean checkItemRemoved = false;
		String transaction = null;
		for (StockDetails stocks : stockslist)
		{
			if (stocks.getStockSymbol().equals(symbol))
			{
				if(stocks.getNumberofShare() - amount > 0)
				{					
					stocks.setNumberofShare(stocks.getNumberofShare() - amount);
					 transaction = "Sold : The "+ amount +" of stock "+stocks.getStockSymbol();
					
				}
				else if (stocks.getNumberofShare() - amount == 0) 
				{
					 transaction = "Sold : The "+ amount +" of stock "+stocks.getStockSymbol();
					stockslist.remove(stocks);
				}
				checkItemRemoved = true;
			}
		}
		if(checkItemRemoved)
		{
			System.out.println("The "+ amount +" stock of "+symbol +" sold successfully");
			stockTransaction.push(transaction);
		}
		else
		{
			System.out.println("stock not selled because you dont have enough shares");
		}
	}
	@Override
	public void getTrasaction() 
	{
		for (String trasaction : stockTransaction)
		{
			System.out.println(trasaction);
		}
	}

}
