package com.erp.assignment.question1;

import com.erp.assignment.question1.controller.PrimeController;
import com.erp.assignment.question1.model.PrimeMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
class Question1ApplicationTests {
	@Autowired
	PrimeController primeController;

	@Test
	void contextLoads() { // sanity check
		Assert.notNull(primeController, "");
	}

	@Test
	void testPrimeGeneration() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/getprimes/";
		// TEST 1: negative number
		Integer test1 = -20;
		PrimeMessage m1 = restTemplate.getForObject(url + test1, PrimeMessage.class);
		Assertions.assertThat(m1).extracting(PrimeMessage::getCount).isEqualTo(0);
		Assertions.assertThat(m1).extracting(PrimeMessage::getUpperBound).isEqualTo(test1); // check number sent
		Assertions.assertThat(m1).extracting(PrimeMessage::getPrimeNumbers).asList().isEmpty(); // no numbers returned

		// TEST 2: small number 5
		Integer test2 = 5;
		PrimeMessage m2 = restTemplate.getForObject(url + test2, PrimeMessage.class);
		Assertions.assertThat(m2).extracting(PrimeMessage::getUpperBound).isEqualTo(test2); // check number sent
		Assertions.assertThat(m2).extracting(PrimeMessage::getCount).isEqualTo(3); // count is 3 (2,3,5)
		Assertions.assertThat(m2).extracting(PrimeMessage::getPrimeNumbers).asList().contains(2,3,5);

		// TEST 3: big number 1000000 (one million)
		Integer test3 = 1000000;
		PrimeMessage m3 = restTemplate.getForObject(url + test3, PrimeMessage.class);
		Assertions.assertThat(m3).extracting(PrimeMessage::getUpperBound).isEqualTo(test3); // check number sent
		Assertions.assertThat(m3).extracting(PrimeMessage::getCount).isEqualTo(78498); // number of primes in range
		Assertions.assertThat(m3).extracting(PrimeMessage::getPrimeNumbers).asList().isNotEmpty();
		Assertions.assertThat(m3).extracting(PrimeMessage::getPrimeNumbers).asList().containsAnyOf(2,3,5,999983);

		// TEST 4: beyond the max limit of 10 million, 400 error (bad request)
		Integer test4 = 10000001;
		try{
			PrimeMessage m4 = restTemplate.getForObject(url + test4, PrimeMessage.class);
		}

		catch(Exception e) {
			Assertions.assertThat(e).hasMessage("400 : [System only accepts a maximum value of 10 million]");
		}
	}

}
