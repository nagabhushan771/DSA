package com.springrest.springrest.entities;

public class BinInfo {
	private int binRange;
	private String cardBrand;
	private String cardIssuer;
	private String cardType;
	private String cardSubType;
	private String country;
	private String countryCode;
	private String iso;
	private String currencyCode;
	private String url;
	private String contact;
	
	public BinInfo(int binRange, String cardBrand, String cardIssuer, String cardType, String cardSubType,
			String country, String countryCode, String iso, String currencyCode, String url, String contact) {
		super();
		this.binRange = binRange;
		this.cardBrand = cardBrand;
		this.cardIssuer = cardIssuer;
		this.cardType = cardType;
		this.cardSubType = cardSubType;
		this.country = country;
		this.countryCode = countryCode;
		this.iso = iso;
		this.currencyCode = currencyCode;
		this.url = url;
		this.contact = contact;
	}

	public int getBinRange() {
		return binRange;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public String getCardIssuer() {
		return cardIssuer;
	}

	public String getCardType() {
		return cardType;
	}

	public String getCardSubType() {
		return cardSubType;
	}

	public String getCountry() {
		return country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getIso() {
		return iso;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getUrl() {
		return url;
	}

	public String getContact() {
		return contact;
	}

	public void setBinRange(int binRange) {
		this.binRange = binRange;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public void setCardIssuer(String cardIssuer) {
		this.cardIssuer = cardIssuer;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setCardSubType(String cardSubType) {
		this.cardSubType = cardSubType;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "BinInfo [binRange=" + binRange + ", cardBrand=" + cardBrand + ", cardIssuer=" + cardIssuer
				+ ", cardType=" + cardType + ", cardSubType=" + cardSubType + ", country=" + country + ", countryCode="
				+ countryCode + ", iso=" + iso + ", currencyCode=" + currencyCode + ", url=" + url + ", contact="
				+ contact + "]";
	}
	
	
	
	
}
