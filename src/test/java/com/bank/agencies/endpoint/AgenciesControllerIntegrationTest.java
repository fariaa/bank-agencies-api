package com.bank.agencies.endpoint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bank.agencies.Application;
import com.bank.agencies.domain.AgencyResponse;
import com.bank.agencies.enums.StateEnum;

@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgenciesControllerIntegrationTest {

	private static final String API_BASE_URL = "/agencies";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnListOfAgeciesWhenDoGetRequestByStateValueSP() {
		ResponseEntity<AgencyResponse> responseEntity = restTemplate
				.getForEntity(API_BASE_URL + "?state=" + StateEnum.SP.state, AgencyResponse.class);
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assertions.assertTrue(responseEntity.getBody().getAgenciesTotal() > 0);
	}
}
