package telran.text;

import telran.text.StringsJoin;

public class StringsJoinStrings extends StringsJoin {
	
	public StringsJoinStrings(String[] strings, String delimeter) {
		super(strings, delimeter);

	}

	@Override
	public String join() {
		String res = "";
		if (this.strings != null && this.strings.length != 0) {
			res = this.strings[0];
			for (int i = 1; i < this.strings.length; i++) {
				res += this.delimeter + this.strings[i];
			} 
		}
		return res;
	}

}
