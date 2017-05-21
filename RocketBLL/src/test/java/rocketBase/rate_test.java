package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;


public class rate_test {


	//		Check to see if a known credit score returns a known interest rate
	@Test
	public void creditTest()
	{
		try {
			System.out.println(RateBLL.getRate(760));
			assertEquals(RateBLL.getRate(760), 5.75);
		} catch (RateException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void failTest()
	{
		try{
			assertEquals(RateBLL.getRate(300), "credit no good");
		}
		catch(RateException e){
			e.printStackTrace();
		}
	}
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	
	
	// make shour dal sorts thing right
	@Test
	public void dalTest()
	{
		ArrayList r1 = new ArrayList();
		ArrayList r2 = new ArrayList();
		r2.add(800);
		r2.add(750);
		r2.add(700);
		r2.add(650);
		r2.add(600);
		for(RateDomainModel r : RateDAL.getAllRates())
		{
			r1.add(r);
		}
		assertEquals(r1, r2);
	}
}
