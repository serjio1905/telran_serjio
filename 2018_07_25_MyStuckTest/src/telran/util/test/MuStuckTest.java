package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.util.MyStuck;

class MuStuckTest {

	MyStuck ms = new MyStuck();
	
	@Test
	void test() {
		assertNull(ms.getMax());
		ms.pushNumber(23);
		assertEquals((Integer)23, ms.getMax());
		ms.pushNumber(-1);
		assertEquals((Integer)23, ms.getMax());
		ms.pushNumber(15);
		assertEquals((Integer)23, ms.getMax());
		ms.pushNumber(48);
		assertEquals((Integer)48, ms.getMax());
		ms.pushNumber(50);
		assertEquals((Integer)50, ms.getMax());
		ms.pushNumber(-2);
		assertEquals((Integer)50, ms.getMax());
		
		ms.popNumber();
		assertEquals((Integer)50, ms.getMax());
		ms.popNumber();
		assertEquals((Integer)48, ms.getMax());
		ms.popNumber();
		assertEquals((Integer)23, ms.getMax());
		ms.popNumber();
		assertEquals((Integer)23, ms.getMax());
		ms.popNumber();
		assertEquals((Integer)23, ms.getMax());
		ms.popNumber();
		assertNull(ms.getMax());
	}

}
