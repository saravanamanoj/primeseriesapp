package com.eqb.exam.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PrimeProcessingException extends Exception {
	
	public PrimeProcessingException(String errorMessage) {
		super(errorMessage);
	}
}
