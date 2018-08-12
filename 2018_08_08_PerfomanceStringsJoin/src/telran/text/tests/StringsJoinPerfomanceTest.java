package telran.text.tests;

import telran.text.StringsJoin;

public class StringsJoinPerfomanceTest {

	private static final String DELIMETER = " ";
	private static final String STRING = "string";
	int nStrings;
	int nRuns;
	StringsJoin stringsJoin;
	String testName;
	
	public StringsJoinPerfomanceTest(int nStrings, int nRuns, StringsJoin stringsJoin, String testName) {
		super();
		this.nStrings = nStrings;
		this.nRuns = nRuns;
		this.stringsJoin = stringsJoin;
		this.testName = testName;
	}

	public void runTest() {
		String[] strings = getStrings();
		stringsJoin.setString(strings);
		stringsJoin.setDelimeter(DELIMETER);
		long start = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			stringsJoin.join();
		}
		long finish = System.currentTimeMillis();
		System.out.printf("%s running time: %d", testName, (finish-start));
	}

	private String[] getStrings() {
		String[] res = new String[nStrings];
		for(int i = 0; i < res.length; i++) {
			res[i] = STRING;
		}
		return res;
	}
	
}
