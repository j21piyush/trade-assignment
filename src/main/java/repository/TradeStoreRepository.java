package repository;

import java.util.HashMap;
import java.util.Map;

import assignment.model.TradeModel;




public class TradeStoreRepository {
	
	
	
	public void updateTrade(TradeModel trade, boolean flagExpired) {
		if(flagExpired) {
			trade.setExpired("Y");
			//persist trade object in DB
		}else {
			trade.setExpired("N");
			//persist trade object in DB
		}
	}
	
	public void addTrade(TradeModel trade, boolean flagExpired) {
		if(flagExpired) {
			trade.setExpired("Y");
			//persist trade object in DB
		}else {
			trade.setExpired("N");
			//persist trade object in DB
		}
	}

}
