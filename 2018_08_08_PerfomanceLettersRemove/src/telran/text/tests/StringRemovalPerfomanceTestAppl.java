package telran.text.tests;

public class StringRemovalPerfomanceTestAppl {
	private static final int N_RUNS = 1000000;
	
	public static void main(String[] args) {
		StringRemovalPerfomanceTest testReplaseAll = new StringRemovalPerfomanceTest(N_RUNS, new LetterRemovalReplaseAll("hello"), "ReplaseAllRemove");
		StringRemovalPerfomanceTest testBuilder = new StringRemovalPerfomanceTest(N_RUNS, new LetterRemovalBuilder("hello"), "BuilderRemove");
		StringRemovalPerfomanceTest testChars = new StringRemovalPerfomanceTest(N_RUNS, new LetterRemovalCharsArray("hello"), "CharsRemove");
		testBuilder.runTest();
		testReplaseAll.runTest();
		testChars.runTest();
	}

}
