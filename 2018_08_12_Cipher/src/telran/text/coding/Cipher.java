package telran.text.coding;

public class Cipher {
	private String secret;
	final static int MAX_CHAR_CODE = 128;
	
	
	public Cipher(String secret) {
		this.secret = secret;
	}

	public String getCipher(String plainText) {
		String res = "";
		String chiperChar;
		for(int i = 0; i < plainText.length(); i++) {
			chiperChar = getChiperCode(plainText.charAt(i));
			chiperChar = getChiper(chiperChar);
			chiperChar = updateCountChar(chiperChar);
			res += chiperChar;
		}
		return res;
	}
	
	private String updateCountChar(String chiperChar) {
		for(int i = chiperChar.length(); i < getBlockSize(); i++) {
			chiperChar = Character.toString(this.secret.charAt(0)) + chiperChar;
		}
		return chiperChar;
	}
	
	private String getChiper(String chiperCharIndex) {
		String res = "";
		int index;
		for(int i = 0; i < chiperCharIndex.length(); i++) {
			index = Integer.parseInt(Character.toString(chiperCharIndex.charAt(i)));
			res += this.secret.charAt(index);
		}
		return res;
	}
	
	private String getChiperCode(int charCode) {
		String res = "";
		while(charCode > 0) {
			res += charCode % secret.length();
			charCode /= secret.length();
		}
		char[] result = new char[res.length()];
		int ii = 0;
		for(int i = res.length() - 1; i >= 0; i--) {
			result[ii] = res.charAt(i);
			ii++;
		}
		return String.valueOf(result);
	}

	public String getPlainText(String cipher) {
		int i = 0;
		int blockSize = this.getBlockSize();
		String res = "";
		while(i < cipher.length()) {
			String block = cipher.substring(i, i + blockSize);
			res += Character.toString((char)getPlainCharCode(block));
			i += blockSize;
		}
		return res;
	}
	
	private int getPlainCharCode(String chiperBlock) {
		int res = 0;
		for(int i = 0; i < chiperBlock.length(); i++) {
			res = res * this.secret.length() + 
					this.secret.indexOf(Character.toString(chiperBlock.charAt(i)));
		}
		return res;
	}
	
	private int getBlockSize() {
		int res = 0;
		int code = MAX_CHAR_CODE;
		while(code > 0) {
			code /= this.secret.length();
			res++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Cipher cipher = new Cipher("ab47gj");
		System.out.println(cipher.getCipher("re2"));
		System.out.println(cipher.getPlainText(cipher.getCipher("re2")));
	}

}
