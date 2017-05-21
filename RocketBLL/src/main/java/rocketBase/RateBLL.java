package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		//used OrderBy in the HQL
		
		//calls getAllRates
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		//sorts and sets the dInterestRate
		for(RateDomainModel r : rates)
		{
			if(r.getiMinCreditScore() < GivenCreditScore)
			{
				dInterestRate = r.getdInterestRate();
				return dInterestRate;	//returns determined rate
			}
		}
		if(dInterestRate == 0)
		{
			throw new RateException(dInterestRate); // throw exception
		}
		
		return dInterestRate;
	}
	
	
	public static boolean expences(LoanRequest lq)
	{
		try{
			if(RateBLL.getPayment(RateBLL.getRate(lq.getiCreditScore()), lq.getiTerm() * 12, lq.getdAmount()-lq.getiDownPayment(), 0, true) < lq.getIncome() * .18 
				& RateBLL.getPayment(RateBLL.getRate(lq.getiCreditScore()), lq.getiTerm() * 12, lq.getdAmount()-lq.getiDownPayment(), 0, true) + lq.getExpenses() <lq.getIncome()* .32)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (RateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
