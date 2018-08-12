package telran.text.tests;

public class LetterRemovalReplaseAll extends LettersRemoval {

	public LetterRemovalReplaseAll(String strings) {
		super(strings);
	}

	@Override
	public String remove(char letter) {
		this.str = this.str.replaceAll(String.valueOf(letter), "");
		return this.getString();
	}

}
