package telran.expressions.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.expressions.StringExpressions.*;

class StringExpressionsTest {

	@Test
	void lessThan1000() {
		assertTrue("100".matches(getRegexPositiveLessThan1000()));
		assertFalse("1000".matches(getRegexPositiveLessThan1000()));
		assertTrue("1".matches(getRegexPositiveLessThan1000()));
		assertFalse("-1".matches(getRegexPositiveLessThan1000()));
	}

	@Test
	void lessThan256() {
		assertTrue("1".matches(getRegex0_255()));
		assertFalse("256".matches(getRegex0_255()));
		assertTrue("1".matches(getRegex0_255()));
		assertTrue("255".matches(getRegex0_255()));
		assertTrue("0".matches(getRegex0_255()));
		assertTrue("05".matches(getRegex0_255()));
		assertTrue("055".matches(getRegex0_255()));
		assertFalse("300".matches(getRegex0_255()));
		assertFalse("-255".matches(getRegex0_255()));
	}
	
	@Test
	void ipV4Address() {
		assertTrue("156.21.5.255".matches(getIpRegex()));
		assertTrue("18.020.007.0".matches(getIpRegex()));
		assertTrue("000.000.000.000".matches(getIpRegex()));
		assertTrue("255.255.255.255".matches(getIpRegex()));
		assertFalse("256.255.255.255".matches(getIpRegex()));
		assertFalse("256.255..255".matches(getIpRegex()));
		assertFalse("18.020.007.0.".matches(getIpRegex()));
	}
}
