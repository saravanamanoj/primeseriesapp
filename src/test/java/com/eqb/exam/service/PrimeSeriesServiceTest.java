package com.eqb.exam.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import com.eqb.exam.model.PrimeProcessingException;

@ExtendWith(MockitoExtension.class)
public class PrimeSeriesServiceTest {

	@InjectMocks
	private PrimeSeriesServiceImpl primeSeriesService;

	@Mock
	private MessageSource messageSource;

	@Test
	public void getPrimeNumberSeriesTest() throws PrimeProcessingException {
		String expectedResult = "[2, 3]";
		String actualResult = primeSeriesService.getPrimeNumberSeries(5);
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void getPrimeNumberSeriesExceptionTest() throws PrimeProcessingException {
		try {
			primeSeriesService.getPrimeNumberSeries("abc");
		} catch (Exception e) {
			assertTrue(e instanceof PrimeProcessingException);
		}
	}

}
