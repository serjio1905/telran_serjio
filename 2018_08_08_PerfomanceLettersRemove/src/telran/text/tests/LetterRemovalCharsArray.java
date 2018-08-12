package telran.text.tests;

public class LetterRemovalCharsArray extends LettersRemoval {
	private int size;
	private char[] charArr;
	
	public LetterRemovalCharsArray(String str) {
		super(str);
		this.size = str.length();
		this.charArr = this.str.toCharArray();
	}

	@Override
	public String remove(char letter) {
		for(int i = 0; i < this.size; i++) {
			if(this.charArr[i] == letter) {
				deleteCharAt(i);
				i--;
			}
		}
		this.str = "";
		for(int i = 0; i < this.size; i++) {
			this.str += this.charArr[i];
		}
			
		return this.getString();
	}
	
	private void deleteCharAt(int index) {
		for(int i = index + 1; i < this.size; i++) {
			this.charArr[i - 1] = this.charArr[i];
		}
		this.size--;
	}

}
