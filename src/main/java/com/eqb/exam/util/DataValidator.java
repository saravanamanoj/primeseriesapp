package com.eqb.exam.util;

import java.util.regex.Pattern;

import com.eqb.exam.constants.PrimeAppConstants;

/**
 * @author Saravana Manoj Jaganathan
 * Class	:	DataValidator
 * Purpose	: 	Utility class to hold the commonly used methods.
 *
 */
public class DataValidator {
	/**
	 * To validate incoming value is not null
	 * @param input
	 * @return boolean result
	 */
	public static boolean isNotNull(Object input) {
		boolean result = false;
		if (input != null && !String.valueOf(input).trim().contentEquals(PrimeAppConstants.EMPTY_STRING.getValue())
				&& !String.valueOf(input).equalsIgnoreCase(PrimeAppConstants.NULL_STRING.getValue()))
			result = true;
		return result;
	}

	/**
	 * To validate incoming value is numeric
	 * @param input
	 * @return boolean result
	 */
	public static boolean isNumeric(String input) {
		boolean result = false;
		Pattern pattern = Pattern.compile(PrimeAppConstants.REGEX_NUMBER.getValue());
		if (isNotNull(input)) {
			result = pattern.matcher(input).matches();
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * To convert the incoming number to integer
	 * @param number
	 * @return Integer number
	 */
	public static Integer getIntValue(String number) {
		Integer result = null;
		if (isNumeric(number))
			result = (int) Double.parseDouble(number);
		return result;
	}
}
