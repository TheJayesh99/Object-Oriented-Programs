package com.bridgelabz.stockaccount;

public class StockDetails 
{
	private String stockName; 
	private  int  numberofShare; 
	private double sharePrice;
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
	public double getSharePrice() 
	{
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) 
	{
		if (sharePrice > 0) 
		{			
			this.sharePrice = sharePrice;
		}
		else
		{
			System.err.println(" Share Price cannot be less than 1");
		}
	}
	@Override
	public String toString() {
		return "StockDetails [stockName=" + stockName + ", numberofShare=" + numberofShare + ", sharePrice="
				+ sharePrice + "]";
	}


}
