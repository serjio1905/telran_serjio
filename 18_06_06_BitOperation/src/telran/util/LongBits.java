package telran.util;

public class LongBits {

	private long number;

	public LongBits(long number) {
		super();
		this.number = number;
	}

	public boolean isBitSet(int nBit) {
		return BitOperators.isBitSet(this.number, nBit);
	}
	
	public void setBit(int nBit) {
		this.number = BitOperators.setBit(number, nBit);
	}
	
	public void toggleBit(int nBit) {
		this.number = BitOperators.toggleBit(number, nBit);
	}
	
	public void togglresetBiteBit(int nBit) {
		this.number = BitOperators.resetBit(number, nBit);
	}
}
