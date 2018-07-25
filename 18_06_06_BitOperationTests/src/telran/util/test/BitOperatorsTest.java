package telran.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import telran.util.BitOperators;

public class BitOperatorsTest {

//	@Test
//	public void testGetBitValue() {
//		int a = 0x100823;
//		assertEquals(1, BitOperators.getBitValue(a, 0));
//		assertEquals(1, BitOperators.getBitValue(a, 5));
//		assertEquals(1, BitOperators.getBitValue(a, 4));
//		assertEquals(1, BitOperators.getBitValue(a, 6));
//	}
	
//	@Test
//	public void setBit() {
//		assertEquals(123, BitOperators.setBit(a, 0));
//		assertEquals(127, BitOperators.setBit(a, 2));
//		assertEquals(-1, BitOperators.setBit(a, 50));
//	}
	
//	@Test
//	public void resetBit() {
//		assertEquals(115, BitOperators.resetBit(a, 3));
//		assertEquals(123, BitOperators.resetBit(a, 2));
//		assertEquals(-1, BitOperators.resetBit(a, -5));
//	}
	
//	@Test
//	public void fastMultiply10() {
//		assertEquals(1000, BitOperators.fastMultiply10(100));
//		assertEquals(80, BitOperators.fastMultiply10(8));
//		assertEquals(1250, BitOperators.fastMultiply10(125));
//	}
	
	@Test
	public void isNbitsSum() {
		long number = 0xc000000000000000L;
		assertTrue(BitOperators.isNbitsSum(25L, 7));
		assertTrue(BitOperators.isNbitsSum(0x5, 2));
		assertTrue(BitOperators.isNbitsSum(1000000000000000000L, 80));
		assertTrue(BitOperators.isNbitsSum(2589631L, 10008));
	}

}
