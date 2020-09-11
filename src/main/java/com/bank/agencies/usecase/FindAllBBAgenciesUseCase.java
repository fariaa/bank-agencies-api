package com.bank.agencies.usecase;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.external.gateway.AgenciesGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllBBAgenciesUseCase {

    private final AgenciesGateway bankResourcesGateway;

    public FindAllBBAgenciesUseCase(AgenciesGateway bankResourcesGateway) {
        this.bankResourcesGateway = bankResourcesGateway;
    }

    public List<AgencyGatewayResponse> execute() {
        return bankResourcesGateway.findAllBBAgencies();
    }
}
