
public class GFG {
	
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
	
	/*static int intToBits(int x) { }*/
	
	static void findNBitInInt(int x, int n) {
		int m = 1;
		m<<=n;
		System.out.println(((x&m)==0?0:1));
	}
    
    public static void main(String[] args)
    {
    	/*int arr[] = new int[]{ 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
    	System.out.println(getOddOccurrence(arr));*/
    	findNBitInInt(32, 5);
    }
}
