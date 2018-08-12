package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lettersRemovalTest {
	String hello = "hello";
	String expected = "heo";
	LettersRemoval lettersRemoval;
	char letter = 'l';
	
	@BeforeEach
	void setUp() throws Exception{
//		lettersRemoval = new LetterRemovalReplaseAll(hello);
//		lettersRemoval = new LetterRemovalBuilder(hello);
		lettersRemoval = new LetterRemovalCharsArray(hello);
		
	}
	
	@Test
	void test() {
		lettersRemoval.remove(letter);
		assertEquals(expected, lettersRemoval.getString());
	}

}
