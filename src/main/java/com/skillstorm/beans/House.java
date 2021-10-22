package com.skillstorm.beans;

public class House {
	
	private int houseid;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private int sqft;
	private Long estPrice;
	private int numberBedRooms;
	private int numberBathRooms;
	private boolean forSale;
	private String typeOfProperty;
	
	
	
	public House() {
		super();
	}



	public House(String streetAddress, String city, String state, String country, String postalCode,
			int sqft, Long estPrice, int numberBedRooms, int numberBathRooms, boolean forSale, String typeOfProperty) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.sqft = sqft;
		this.estPrice = estPrice;
		this.numberBedRooms = numberBedRooms;
		this.numberBathRooms = numberBathRooms;
		this.forSale = forSale;
		this.typeOfProperty = typeOfProperty;
	}



	public House(int houseid, String streetAddress, String city, String state, String country, String postalCode,
			int sqft, Long estPrice, int numberBedRooms, int numberBathRooms, boolean forSale, String typeOfProperty) {
		super();
		this.houseid = houseid;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.sqft = sqft;
		this.estPrice = estPrice;
		this.numberBedRooms = numberBedRooms;
		this.numberBathRooms = numberBathRooms;
		this.forSale = forSale;
		this.typeOfProperty = typeOfProperty;
	}



	public House(String streetAddress, String city, String state, String country, String postalCode, int sqft,
			int numberBedRooms, int numberBathRooms, boolean forSale) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.sqft = sqft;
		this.numberBedRooms = numberBedRooms;
		this.numberBathRooms = numberBathRooms;
		this.forSale = forSale;
	}



	public House(String streetAddress, String city, String state, String country, String postalCode, int sqft) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.sqft = sqft;
	}



	public House(String streetAddress, String city, String state, String country, String postalCode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}



	public int getHouseid() {
		return houseid;
	}



	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}



	public String getStreetAddress() {
		return streetAddress;
	}



	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public int getSqft() {
		return sqft;
	}



	public void setSqft(int sqft) {
		this.sqft = sqft;
	}



	public Long getEstPrice() {
		return estPrice;
	}



	public void setEstPrice(Long estPrice) {
		this.estPrice = estPrice;
	}



	public int getNumberBedRooms() {
		return numberBedRooms;
	}



	public void setNumberBedRooms(int numberBedRooms) {
		this.numberBedRooms = numberBedRooms;
	}



	public int getNumberBathRooms() {
		return numberBathRooms;
	}



	public void setNumberBathRooms(int numberBathRooms) {
		this.numberBathRooms = numberBathRooms;
	}



	public boolean isForSale() {
		return forSale;
	}



	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}



	public String getTypeOfProperty() {
		return typeOfProperty;
	}



	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((estPrice == null) ? 0 : estPrice.hashCode());
		result = prime * result + (forSale ? 1231 : 1237);
		result = prime * result + houseid;
		result = prime * result + numberBathRooms;
		result = prime * result + numberBedRooms;
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + sqft;
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((typeOfProperty == null) ? 0 : typeOfProperty.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (estPrice == null) {
			if (other.estPrice != null)
				return false;
		} else if (!estPrice.equals(other.estPrice))
			return false;
		if (forSale != other.forSale)
			return false;
		if (houseid != other.houseid)
			return false;
		if (numberBathRooms != other.numberBathRooms)
			return false;
		if (numberBedRooms != other.numberBedRooms)
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (sqft != other.sqft)
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (typeOfProperty == null) {
			if (other.typeOfProperty != null)
				return false;
		} else if (!typeOfProperty.equals(other.typeOfProperty))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "House [houseid = " + houseid + ", streetAddress = " + streetAddress + ", city = " + city + ", state = " + state
				+ ", country = " + country + ", postalCode = " + postalCode + ", sqft = " + sqft + ", estPrice = " + estPrice
				+ ", numberBedRooms = " + numberBedRooms + ", numberBathRooms = " + numberBathRooms + ", forSale = " + forSale
				+ ", typeOfPropeerty = " + typeOfProperty + "]\n";
	}
	
	
	
	
	
	
	
	
	
	
}
