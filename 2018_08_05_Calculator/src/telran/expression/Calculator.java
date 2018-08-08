package telran.expression;

import java.util.Arrays;

public class Calculator {
	public static Float calculateExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		expression = expression.replaceAll("\\,+", "\\.");
		if(expression.matches("^[\\+\\-].*"))
			expression = "0" + expression;
		System.out.println(expression.matches("^([0-9]+(\\.[0-9]+)?[\\+\\-\\*\\/]){1,}([0-9]+(\\.[0-9]+)?)$"));
		String[] numArr = expression.split("[\\+\\-\\*\\/]");
		String[] operArr = expression.split("[0-9]+(\\.[0-9]+)?");
		if(numArr.length != operArr.length) 
			return null;
		Float res = Float.parseFloat(numArr[0]);
		for(int i = 1; i < numArr.length; i++) {
			switch(operArr[i]) {
				case "+":
					res += Float.parseFloat(numArr[i]);
					break;
				case "-":
					res -= Float.parseFloat(numArr[i]);
					break;
				case "*":
					res *= Float.parseFloat(numArr[i]);
					break;
				case "/":
					res /= Float.parseFloat(numArr[i]);
					break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(calculateExpression("1,5+2*3/4"));
	}
}
