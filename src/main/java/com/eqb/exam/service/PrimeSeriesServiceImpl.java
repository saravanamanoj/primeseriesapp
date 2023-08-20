package com.eqb.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.eqb.exam.constants.PrimeAppConstants;
import com.eqb.exam.model.PrimeProcessingException;
import com.eqb.exam.model.Response;
import com.eqb.exam.util.DataValidator;

/**
 * @author Saravana Manoj Jaganathan
 * Class	:	PrimeSeriesServiceImpl
 * Purpose	:	To generate the prime number series lesser than the incoming input number 
 */
@Service
public class PrimeSeriesServiceImpl implements PrimeSeriesService {

	@Autowired
	private MessageSource messageSource;

	/**
	 * To generate the prime series
	 */
	@Override
	public String getPrimeNumberSeries(Object input) throws PrimeProcessingException {
		Integer limit = null;
		List<Integer> series = new ArrayList<>();
		Response response = new Response();
		validateInput(String.valueOf(input));

		limit = DataValidator.getIntValue(String.valueOf(input));
		generatePrimeSeries(limit, series);
		response.setOutput(series.toString());
		return response.getOutput();
	}

	/**
	 * To validate the incoming number.
	 * @param value
	 * @throws PrimeProcessingException
	 */
	private void validateInput(String value) throws PrimeProcessingException {
		if (!DataValidator.isNotNull(value)) {
			throw new PrimeProcessingException(messageSource.getMessage(PrimeAppConstants.ERROR_EMPTY_INPUT.getValue(), null, Locale.getDefault()));
		} else if (!DataValidator.isNumeric(value)) {
			throw new PrimeProcessingException(messageSource.getMessage(PrimeAppConstants.ERROR_NOT_VALID_INPUT.getValue(), new Object[] {value}, Locale.getDefault()));
		}else if (DataValidator.getIntValue(value)<=2) {
			throw new PrimeProcessingException(messageSource.getMessage(PrimeAppConstants.ERROR_NOT_A_PRIME_NUMBER.getValue(), new Object[] {value}, Locale.getDefault()));
		}

	}

	/**
	 * Generates the prime number series using Sieve of Eratosthenes algorithm
	 * @param limit
	 * @param series
	 */
	private void generatePrimeSeries(Integer limit, List<Integer> series) {
		boolean[] isPrime = new boolean[limit + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i * i <= limit; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= limit; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i < limit; i++) {
			if (isPrime[i]) {
				series.add(i);
			}
		}

	}

}
