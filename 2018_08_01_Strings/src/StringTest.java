import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void stringIntroduction() {
		String str = "Hello";
		String hello = "Hello";
		String str1 = new String("Hello");
		int a = 10;
		String str2 = String.format("Hello %d", a);
		String str3 = new String(new char[] {
			'H', 'e', 'l', 'l', 'o'	
		});
		String strEmpty = "";
		assertTrue(str == hello);
		assertTrue(str.equals(str1));
		assertTrue(str2.equals("Hello 10"));
	}
	
	@Test
	void stringImmutabale() {
		String str = new String("Hallo");
		String newStr = str.replaceAll("l", "");
		System.out.println(newStr);
	}
	
	@Test
	void regexIntroduction() {
		String str = "abcdef12";
		assertTrue(str.matches("abc.*"));
	}

	@Test
	void nonLettersReplace() {
		String str = "+ -a1 100 * bc";
		String expected = "#a#bc";
		assertEquals(expected, str.replaceAll("[^a-z]{1,}", "#"));
	}
	
	@Test 
	void regexMobile(){
		String regexExp = "^(\\+972|0)(\\d-?){9}$";
		assertTrue("0501234567".matches(regexExp));
		assertFalse("05012345".matches(regexExp));
		assertTrue("+97250-12-34-567".matches(regexExp));
		assertFalse("97250-12-34-567".matches(regexExp));
		assertFalse("+9720501234567".matches(regexExp));
		assertTrue("+972501234567".matches(regexExp));
	}
}
