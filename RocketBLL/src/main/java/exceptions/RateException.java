package exceptions;

import java.util.regex.Pattern;

import rocketDomain.RateDomainModel;


public class RateException extends Exception {

	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	private RateDomainModel r;
	private double dInterestRate;
	
	public RateException(double dInterestRate)
	{
		super("credit No Good");
		this.dInterestRate = dInterestRate; 
	}
	
	public RateException(RateDomainModel r)
	{
		this.r = r;
	}
	public double getdInterestRate()
	{
		return this.dInterestRate;
	}
	public RateDomainModel getr()
	{
		return this.r;
	}
	
}