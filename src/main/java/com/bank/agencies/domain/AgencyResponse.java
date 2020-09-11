package com.bank.agencies.domain;

import java.io.Serializable;
import java.util.List;

import com.bank.agencies.to.AgencyTO;

/**
 * 
 * @author lucas_faria
 *
 */
public class AgencyResponse implements Serializable {

	private static final long serialVersionUID = -7045126330135698391L;

	private List<AgencyTO> agencies;
	private int agenciesTotal;

	public AgencyResponse() {
	}

	public AgencyResponse(List<AgencyTO> agencies, int agenciesTotal) {
		super();
		this.agencies = agencies;
		this.agenciesTotal = agenciesTotal;
	}

	public List<AgencyTO> getAgencies() {
		return agencies;
	}

	public void setAgencies(List<AgencyTO> agencies) {
		this.agencies = agencies;
	}

	public int getAgenciesTotal() {
		return agenciesTotal;
	}

	public void setAgenciesTotal(int agenciesTotal) {
		this.agenciesTotal = agenciesTotal;
	}

}
