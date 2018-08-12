package telran.text.tests;

import telran.text.StringsJoin;
import telran.text.StringsJoinStrings;

public class StringsJoinPerfomanceTestAppl {

	private static final int N_STRINGS = 10000;
	private static final int N_RUNS = 1000;

	public static void main(String[] args) {
		StringsJoinPerfomanceTest testString = new StringsJoinPerfomanceTest(N_STRINGS, N_RUNS, new StringsJoinStrings(null, null), "StringsJoin");
		StringsJoinPerfomanceTest testBuilder = new StringsJoinPerfomanceTest(N_STRINGS, N_RUNS, new StringsJoinBuilder(null, null), "StringsBuilder");
		testBuilder.runTest();
		testString.runTest();
	}

}
