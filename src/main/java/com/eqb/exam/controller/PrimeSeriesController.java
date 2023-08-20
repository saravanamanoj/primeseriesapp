package com.eqb.exam.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eqb.exam.constants.PrimeAppConstants;
import com.eqb.exam.model.PrimeProcessingException;
import com.eqb.exam.model.Request;
import com.eqb.exam.service.PrimeSeriesService;

/**
 * @author Saravana Manoj Jaganathan Class : PrimeSeriesController Purpose :
 *         Controller class serves the incoming requests.
 */
@RestController
@CrossOrigin
public class PrimeSeriesController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PrimeSeriesService primeSeriesService;

	/**
	 * To show the welcome message when the API is invoked using HTTP GET method
	 * 
	 * @return response as String
	 */
	@GetMapping("/apps/primeseries")
	String showWelcomeMessage() {
		return messageSource.getMessage(PrimeAppConstants.WELCOME_MSG.getValue(), null, Locale.getDefault());
	}

	/**
	 * To process the incoming input number and return the prime numbers series
	 * lesser than the incoming number
	 * 
	 * @param request
	 * @return Prime number series as response
	 */
	@PostMapping("/apps/primeseries")
	String getPrimeSeries(@RequestBody Request request) {
		String response = null;
		try {
			response = primeSeriesService.getPrimeNumberSeries(request.getInput());
		} catch (PrimeProcessingException exception) {
			response = exception.getMessage();
		}
		return response;
	}

}
