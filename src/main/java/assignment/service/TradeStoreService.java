package assignment.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import assigment.exception.LowerVersionException;
import assignment.model.TradeModel;
import repository.TradeStoreRepository;


public class TradeStoreService {
	
	public void StoreTrade(TradeModel trade) {
		TradeStoreRepository repo= new TradeStoreRepository();
		try {
			Integer version= validateVersion(trade.getTradeID(), trade.getVersion());
			boolean maturityFlag= checkTradeWithMaturityDate(trade.getMaturityDate());
			if (version==0 || version<trade.getVersion()) {
				if(maturityFlag)
						repo.addTrade(trade,flagExpired(trade.getCreatedDate(),trade.getMaturityDate()));
			}else if (version==trade.getVersion()) {
				if(maturityFlag) 
					repo.updateTrade(trade,flagExpired(trade.getCreatedDate(),trade.getMaturityDate()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (LowerVersionException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
	}
	
	
	
	private Integer validateVersion(String tradeID, Integer version) throws LowerVersionException {
		Integer storedVersion = getversion(tradeID);
			if(storedVersion!=null && version >=storedVersion) {
				return storedVersion;
			}else if(storedVersion==null){
				return 0;
			}else {
				throw new LowerVersionException("Trade# = " +tradeID + "contain lower version");
			}
	}
	
	 private boolean checkTradeWithMaturityDate(Date maturityDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		Date currentDate = formatter.parse(formatter.format(today));
		if (maturityDate.compareTo(currentDate)>0) {
			return true;
		}
		return false;
	}
	
	
	 private boolean flagExpired(Date createdDate, Date maturityDate) {
		if(maturityDate.compareTo(createdDate)<0) {
			return true;
		}
		return false;
	}
	 
	 private Integer getversion(String tradeID) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("T1", 1);
			map.put("T3", 2);
			map.put("T4", 3);
			map.put("T3", 1);
			map.put("T2", 2);
			
			//Since code is not using database so getting data from hashmap 
			return map.get(tradeID);
			
		}
}
