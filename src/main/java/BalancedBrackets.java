import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		String sample1 = "{{[[(())]]}}";
		System.out.println(balanced(sample1));
	}

	private static String balanced(String sample) {
		Stack<String> openingStack = new Stack<>();
		char[] bracketsArray = sample.toCharArray();
		boolean closingBracketFound = false;
		for (int i = 0; i < bracketsArray.length; i++) {
			char c = bracketsArray[i];
			if (openingStack.isEmpty() && !openingBracket(c)) {
				return "NO";
			} else if (openingBracket(c) && !closingBracketFound) {
				openingStack.push(String.valueOf(c));
			} else if (!openingBracket(c)) {
				String lastOpening = openingStack.peek();
				if (String.valueOf(c).equals("}") && lastOpening.equals("{")) {
					openingStack.pop();
					continue;
				} else if (String.valueOf(c).equals(")") && lastOpening.equals("(")) {
					openingStack.pop();
					continue;
				} else if (String.valueOf(c).equals("]") && lastOpening.equals("[")) {
					openingStack.pop();
					continue;
				} else {
					return "NO";
				}
			}
		}
		return openingStack.isEmpty() ? "YES" : "NO";
	}

	private static boolean openingBracket(char c) {
		return String.valueOf(c).equals("{") || String.valueOf(c).equals("(") || String.valueOf(c).equals("[");
	}
}
