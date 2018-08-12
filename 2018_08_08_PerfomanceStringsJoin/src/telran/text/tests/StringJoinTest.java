package telran.text.tests;

import telran.text.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringJoinTest {

	String[] strings = {"Hello", "Word", "!!!"};
	String expected = "Hello Word !!!";
	StringsJoin stringsJoin;
	
	@BeforeEach
	void setUp() throws Exception {
		stringsJoin = new StringsJoinBuilder(strings, " ");
	}
	
	@Test
	void join() {
		String actual = stringsJoin.join();
		assertEquals(expected, actual);
	}

}
