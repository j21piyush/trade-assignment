package assignment.service;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;

import assigment.exception.LowerVersionException;
import assignment.model.TradeModel;

import static org.powermock.api.mockito.PowerMockito.doReturn;

public class TradeStoreServiceTest {

	@Test
	public void testStoreTrade() throws Exception {
		TradeModel t1 = new TradeModel();
		TradeStoreService service= new TradeStoreService();
		t1.setBookID("B1");
		t1.setCountryPartyID("CP-1");
		t1.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2023"));
		t1.setExpired("N");
		t1.setMaturityDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2023"));
		t1.setTradeID("T2");
		t1.setVersion(1);

		TradeStoreService spy = PowerMockito.spy(new TradeStoreService());
		doReturn(1).when(spy, "validateVersion", ArgumentMatchers.any(),ArgumentMatchers.any());
		doReturn(1).when(spy, "getversion", ArgumentMatchers.any());
		service.StoreTrade(t1);
	}
	
	@Test(expected = LowerVersionException.class)
	void testStoreTradeWithLowerVersionException() throws Exception {
		TradeStoreService service= new TradeStoreService();
		TradeModel t1 = new TradeModel();
		t1.setBookID("B1");
		t1.setCountryPartyID("CP-1");
		t1.setCreatedDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2023"));
		t1.setExpired("N");
		t1.setMaturityDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2023"));
		t1.setTradeID("T2");
		t1.setVersion(2);

		TradeStoreService spy = PowerMockito.spy(new TradeStoreService());
		doReturn(1).when(spy, "validateVersion", ArgumentMatchers.any(),ArgumentMatchers.any());
		doReturn(1).when(spy, "getversion", ArgumentMatchers.any());
		service.StoreTrade(t1);
	
	}

}
