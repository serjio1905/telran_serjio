package telran.expressions;

public class StringExpressions {
	
	static public String getRegexPositiveLessThan1000() {
		return "^\\d{1,3}$";
	}
	
	static public String getRegex0_255() {
		return "([0-1]?\\d?\\d)|(2[0-4]\\d)|(25[0-5])";
	}
	
	static public String getIpRegex() {
		return String.format("((%s)\\.){3}(%s)", getRegex0_255(), getRegex0_255());
	}
	
}
