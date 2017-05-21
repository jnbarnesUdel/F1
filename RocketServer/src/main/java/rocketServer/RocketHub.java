package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message){
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived
			try{
				RateBLL.getRate(lq.getiCreditScore());
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			}
			catch(RateException e) {
				e.printStackTrace();
			}
			
			//if you can pay or not, and sets payment if you can pay
			if(RateBLL.expences(lq)) 
			{
				lq.setdPayment(RateBLL.getPayment(lq.getdRate(), lq.getiTerm() * 12, lq.getdAmount()-lq.getiDownPayment(), 0, true));
				sendToAll(lq);
			}
			else
			{
				//can't afford house
			}
			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
		}
	}
}
