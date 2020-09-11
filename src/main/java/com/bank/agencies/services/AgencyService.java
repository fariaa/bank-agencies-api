package com.bank.agencies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.domain.AgencyResponse;
import com.bank.agencies.enums.StateEnum;
import com.bank.agencies.to.AgencyTO;

@Service
public class AgencyService {

	private ResponseEntity<AgencyResponse> findByState(List<AgencyGatewayResponse> agencies, StateEnum state) {
		List<AgencyTO> agencyResponse = agencies.stream()
				.map(agencyGateway -> new AgencyTO(agencyGateway.getBank(), agencyGateway.getCity(),
						agencyGateway.getName(), StateEnum.valueOf(agencyGateway.getState().toUpperCase())))
				.filter(agencyGateway -> agencyGateway.getState().equals(state)).collect(Collectors.toList());

		return new ResponseEntity<>(new AgencyResponse(agencyResponse, agencyResponse.size()), HttpStatus.OK);
	}

	private ResponseEntity<AgencyResponse> findByState(List<AgencyGatewayResponse> agencies) {
		List<AgencyTO> agencyResponse = agencies.stream()
				.map(agencyGateway -> new AgencyTO(agencyGateway.getBank(), agencyGateway.getCity(),
						agencyGateway.getName(), StateEnum.valueOf(agencyGateway.getState().toUpperCase())))
				.collect(Collectors.toList());

		return new ResponseEntity<>(new AgencyResponse(agencyResponse, agencyResponse.size()), HttpStatus.OK);
	}

	private ResponseEntity<AgencyResponse> findByStates(List<AgencyGatewayResponse> agencies, String states) {
		
		String[] ufs = states.split(",");
		List<StateEnum> statesEnum = new ArrayList<>();
		for (String uf: ufs) {
			statesEnum.add(StateEnum.valueOf(uf.toUpperCase()));
		}
		
		List<AgencyTO> agencyResponse = agencies.stream()
				.map(agencyGateway -> new AgencyTO(agencyGateway.getBank(), agencyGateway.getCity(),
						agencyGateway.getName(), StateEnum.valueOf(agencyGateway.getState().toUpperCase())))
				.filter(agencyGateway -> {
					long count = statesEnum.stream().filter(s -> s.state.equals(agencyGateway.getState().state)).count();
					
					if(count > 0 ) return true;
					else return false;
					
				}).collect(Collectors.toList());
				

		return new ResponseEntity<>(new AgencyResponse(agencyResponse, agencyResponse.size()), HttpStatus.OK);
	}
	
	public ResponseEntity<AgencyResponse> findByState(List<AgencyGatewayResponse> agencies, String state) {
		
		if(state != null && !state.isBlank()) {
			return findByState(agencies, StateEnum.valueOf(state));
		}
		
		return findByState(agencies);
	}

	public ResponseEntity<AgencyResponse> findByState(List<AgencyGatewayResponse> agencies, String state, String states) {
		
		if(state != null && !state.isBlank()) {
			return findByState(agencies, StateEnum.valueOf(state));
		}
		else if(states != null && !states.isBlank()) {
			
			return findByStates(agencies, states);
		}
		
		
		return null;
	}

}
