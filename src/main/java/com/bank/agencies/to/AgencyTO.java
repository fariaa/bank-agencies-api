package com.bank.agencies.to;

import java.io.Serializable;

import com.bank.agencies.enums.StateEnum;

public class AgencyTO implements Serializable {

	private static final long serialVersionUID = -7394339763238481398L;

	private String name;
	private String bank;
	private String city;
	private StateEnum state;

	public AgencyTO() {}
	
	public AgencyTO(String name, String bank, String city, StateEnum state) {
		super();
		this.name = name;
		this.bank = bank;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}
}
