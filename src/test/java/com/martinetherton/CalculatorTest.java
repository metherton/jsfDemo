package com.martinetherton;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add2NumbersTogether() {
		
		Calculator calculator = new Calculator();
		
		assertThat(calculator.add(1,2), Matchers.is(3));
		
	}
	
}
