package com.eqb.exam.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DataValidatorTest {

	@Test
	public void isNotNullTest1() {
		String input="";
		assertFalse(DataValidator.isNotNull(input));
	}
	
	@Test
	public void isNotNullTest2() {
		String input="5";
		assertTrue(DataValidator.isNotNull(input));
	}
	
	@Test
	public void isNumericTest1() {
		String input="abc";
		assertFalse(DataValidator.isNumeric(input));
	}
	
	@Test
	public void isNumericTest2() {
		String input="5";
		assertTrue(DataValidator.isNumeric(input));
	}
	
	@Test
	public void getIntValueTest1() {
		String input="5";
		assertEquals(5, DataValidator.getIntValue(input));
	}
	
	@Test
	public void getIntValueTest2() {
		String input="abc";
		assertNull(DataValidator.getIntValue(input));
	}
	
}
