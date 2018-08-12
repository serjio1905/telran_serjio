package telran.text.tests;

public abstract class LettersRemoval {
	protected String str;

	public LettersRemoval(String str) {
		this.str = str;
	}
	
	abstract public String remove(char letter);
	
	public String getString() {
		return str;
	}
	
}
