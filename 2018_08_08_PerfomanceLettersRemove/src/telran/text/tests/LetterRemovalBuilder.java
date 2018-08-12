package telran.text.tests;

public class LetterRemovalBuilder extends LettersRemoval {

	public LetterRemovalBuilder(String str) {
		super(str);
	}

	@Override
	public String remove(char letter) {
		StringBuilder builder = new StringBuilder(this.str);
		for(int i = 0; i < builder.length(); i++) {
			if(builder.charAt(i) == letter) {
				builder.deleteCharAt(i);
				i--;
			}
		}
		this.str = builder.toString();
		return this.getString();
	}

}
