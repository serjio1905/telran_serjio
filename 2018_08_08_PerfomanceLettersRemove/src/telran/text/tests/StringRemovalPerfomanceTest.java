package telran.text.tests;

public class StringRemovalPerfomanceTest {
	private static final char CHAR = 'l';
	int nRuns;
	LettersRemoval letterRemoval;
	String testName;
	
	public StringRemovalPerfomanceTest(int nRuns, LettersRemoval letterRemoval, String testName) {
		super();
		this.nRuns = nRuns;
		this.letterRemoval = letterRemoval;
		this.testName = testName;
	}
	
	public void runTest() {
		long start = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			letterRemoval.remove(CHAR);
		}
		long finish = System.currentTimeMillis();
		System.out.printf("%s running time: %d\n", testName, (finish-start));
	}
}
