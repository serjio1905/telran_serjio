package telran.util;

public class BitOperators {
	final static int MAX_BIT_NUMBER = 64;
	final static long ONE = 1L;
	
	
	static int multiplyWith3Point5(int x) {
		int halfX = x>>1;
		int res = x<<1 + x;
		
		for (int g = 0; g < halfX; g++) {
			res = (-(~x));
		}		
		return res;
    }
	
 	static int addOne(int x) {
        int m = 1;
        while( (int)(x & m) == m)
        {
            x = x ^ m;
            m <<= 1;
        }
        x = x ^ m;
        return x;
    }
 	
	static int rightmostUnset(int x) {
		int m = 1;
		while((x & m) != m) m<<=1;
		x^=m;
		return x;
	}
	
	static int getOddOccurrence(int arr[]) {
        int arr_size = arr.length;
        int i;
        for (i = 0; i < arr_size; i++) {
            int count = 0;
            for (int j = 0; j < arr_size; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count % 2 != 0)
                return arr[i];
        }
        return -1;
    }
	
	public static String getBitView(long history) {
		int m = 1; 
		m<<=30;
		String res = "";
		for(int i = 0; i<=30; i++) {
			if((history&m)==0)
				res = res + "0";
			else
				res = res + "1";
			
			m>>=1;
		}
		return res;
	}
	
	public static long getBitValue(long number, int nBit) {
		/**
		 * 
		 * @param number
		 * @param nBit - sequential number of bit
		 * @return bit value(0,1); -1 in the case of wrong bit`s number
		 */
		if(nBit<0 || nBit>MAX_BIT_NUMBER) return -1;
		return (((number&(1<<nBit))==0?0:1));
	}
	
	public static boolean isBitSet(long number, int nBit) {
		/**
		 * 
		 * @param number
		 * @param nBit - sequential number of bit
		 * @return bit value(0,1); -1 in the case of wrong bit`s number
		 */
		if(nBit<0 || nBit>MAX_BIT_NUMBER) return false;
		return (number&(ONE<<nBit))==ONE<<nBit?true:false;
	}
	
	/**
	 * @param number
	 * @param nBit - sequential number of bit
	 * @return new number with 1 in the bit of nBit number
	 * 			-1 in the case of wrong bit number
	 */
	public static long setBit(long number, int nBit) {
		if(nBit < 0 || nBit >= MAX_BIT_NUMBER) return -1;
		return (number|(ONE<<nBit));
	}
	
	/**
	 * @param number
	 * @param nBit - sequential number of bit
	 * @return new number with 1 in the bit of nBit number
	 * 			-1 in the case of wrong bit number
	 */
	public static long toggleBit(long number, int nBit) {
		if(nBit < 0 || nBit >= MAX_BIT_NUMBER) return -1;
		return (number^(1<<nBit));
	}
	
	/**
	 * @param number
	 * @param nBit - sequential number of bit
	 * @return new number with un.. in the bit of nBit number
	 * 			-1 in the case of wrong bit number
	 */
	public static long resetBit(long number, int nBit) {
		if(nBit < 0 || nBit >= MAX_BIT_NUMBER) return -1;
		return number&(~(1<<nBit));
	}
	
	/**
	 * @param number
	 * @return new number number*10 - once operator '+' and without loops and '*' or '/'
	 */
	public static int fastMultiply10(int number) {
		return (number<<3)+(number<<1);
	}
	
	/**
	 * @param number
	 * @return new number number/10 - once operator '+' and without loops and '*' or '/'
	 */
	public static int fastDivision10(int number) {
		return 0;
	}
	
	public static boolean isNbitsSum(long number, int sum) {
		if(sum > 123 || sum < 1) return false;
		if (sum <= 63) {
			int i = 0;
			while(i < 63) {
				if((sum-i)<i) return false;
				if(isBitSet(number, i) && isBitSet(number, (sum-i))) return true;
				i++;
			}
			return false;
		} else {
			int i = 63;
			while(i > 0) {
				if((sum-i)>i) return false;
				if(isBitSet(number, i) && isBitSet(number, (sum-i))) return true;
				i--;
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) {
    	System.out.println(isNbitsSum(25, 7));
    }
	
}
