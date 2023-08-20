package com.eqb.exam.constants;

/**
 * @author Saravana Manoj Jaganathan
 * enum	:	PrimeAppConstants
 * Purpose : To hold the constant literals used in the project
 */
public enum PrimeAppConstants {

	WELCOME_MSG("app.info.msg"),
	ERROR_EMPTY_INPUT("app.err.input.empty"),
	ERROR_NOT_VALID_INPUT("app.err.input.notnumber"),
	ERROR_NOT_A_PRIME_NUMBER("app.err.input.notprimenumber"),
	REGEX_NUMBER("^[+-]?\\d+(\\.\\d+)?"),
	EMPTY_STRING(""),
	NULL_STRING("null");
	private String value;

	public String getValue() {
		return value;
	}

	private PrimeAppConstants(String value) {
		this.value = value;
	}
	
	
	
}
