import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void stringIntroduction() {
		String str = "Hello";
		String str1 = new String("Hello");
		String str2 = String.format("Hello");
		String str3 = new String(new char[] {
			'H', 'e', 'l', 'l', 'o'	
		});
	}

}
