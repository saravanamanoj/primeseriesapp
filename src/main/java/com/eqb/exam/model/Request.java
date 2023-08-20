package com.eqb.exam.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Request {
	private Object input;

	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	}
	
	
}
