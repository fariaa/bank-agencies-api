    package com.bank.agencies.endpoint;

    import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.domain.AgencyResponse;
import com.bank.agencies.enums.StateEnum;
import com.bank.agencies.services.AgencyService;
import com.bank.agencies.usecase.FindAllBBAgenciesUseCase;

    @RestController
    @RequestMapping(value = "/agencies", produces = MediaType.APPLICATION_JSON_VALUE)
    public class AgenciesController {

        private final FindAllBBAgenciesUseCase findAllBBAgenciesUseCase;
        private final AgencyService agencyService;
        private List<AgencyGatewayResponse> agencies = null;

        public AgenciesController(FindAllBBAgenciesUseCase findAllBBAgenciesUseCase, AgencyService agencyService) {
            this.findAllBBAgenciesUseCase = findAllBBAgenciesUseCase;
            this.agencyService = agencyService;
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<AgencyResponse> findByStateBBAgencies(@RequestParam("state") String state) {
        	if(agencies == null)
        		agencies = findAllBBAgenciesUseCase.execute();
        	
            return agencyService.findByState(agencies, StateEnum.valueOf(state));
        }
    }
