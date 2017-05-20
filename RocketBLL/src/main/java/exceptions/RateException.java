package exceptions;

import java.util.regex.Pattern;

import rocketDomain.RateDomainModel;


public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	private RateDomainModel r;
	
	RateException(RateDomainModel r)
	{
		this.r = r;
	}
	
	public RateDomainModel getr()
	{
		return this.r;
	}
	
}