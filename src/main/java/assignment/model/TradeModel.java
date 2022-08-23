package assignment.model;

import java.util.Date;

public class TradeModel {
	
	private String tradeID;
	private Integer version;
	private String countryPartyID;
	private String bookID;
	private Date maturityDate;
	private Date createdDate;	
	private String expired;
	
	public TradeModel(){
		
	}
	
	public TradeModel(String tradeID, Integer version, String countryPartyID, String bookID, Date maturityDate,
			Date createdDate, String expired) {
		super();
		this.tradeID = tradeID;
		this.version = version;
		this.countryPartyID = countryPartyID;
		this.bookID = bookID;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCountryPartyID() {
		return countryPartyID;
	}
	public void setCountryPartyID(String countryPartyID) {
		this.countryPartyID = countryPartyID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
}
