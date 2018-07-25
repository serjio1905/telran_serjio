import java.util.Comparator;

public class StringsCompLength implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int l1 = o1.length();
		int l2 = o2.length();
		return l1 - l2;
	}

}
