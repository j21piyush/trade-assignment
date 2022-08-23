package assignment.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import assignment.model.TradeModel;
import assignment.service.TradeStoreService;

public class TradeStoreMain {

	public static void main(String[] args) throws ParseException {
		TradeModel t1 = new TradeModel();
		t1.setBookID("B1");
		t1.setCountryPartyID("CP-1");
		t1.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2023"));
		t1.setExpired("N");
		t1.setMaturityDate(new SimpleDateFormat("dd-MM-yyyy").parse("20-03-2024"));
		t1.setTradeID("T2");
		t1.setVersion(1);
		
		TradeStoreService tradeStoreService = new TradeStoreService();
		tradeStoreService.StoreTrade(t1);

	}

}
