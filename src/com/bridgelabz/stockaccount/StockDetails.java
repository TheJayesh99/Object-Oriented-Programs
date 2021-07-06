package com.bridgelabz.stockaccount;

public class StockDetails 
{
	private String stockName; 
	private  int  numberofShare; 
	private double pricePerShare;
	private String stockSymbol;
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getStockName() 
	{
		return stockName;
	}
	public void setStockName(String stockName) 
	{
		this.stockName = stockName;
	}
	public int getNumberofShare() 
	{
		return numberofShare;
	}
	public void setNumberofShare(int numberofShare) 
	{
		if (numberofShare > 0)
		{			
			this.numberofShare = numberofShare;
		}
		else
		{
			System.err.println("Number of shares cannot be less than 1");
		}
	}
	
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	
	@Override
	public String toString() {
		return "StockDetails [stockName=" + stockName + ", numberofShare=" + numberofShare + ", pricePerShare="
				+ pricePerShare + ", stockSymbol=" + stockSymbol + "]";
	}

}
