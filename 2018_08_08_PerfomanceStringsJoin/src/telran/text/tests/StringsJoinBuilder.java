package telran.text.tests;

import telran.text.StringsJoin;

public class StringsJoinBuilder extends StringsJoin {

	public StringsJoinBuilder(String[] strings, String delimeter) {
		super(strings, delimeter);
	}

	@Override
	public String join() {
		StringBuilder builder = new StringBuilder("");
		if (strings != null && strings.length != 0) {
			builder = new StringBuilder(strings[0]);
			for (int i = 1; i < strings.length; i++) {
				builder.append(delimeter + strings[i]);
			} 
		}
		return builder.toString();
	}

}
