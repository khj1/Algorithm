package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌_세상_4949 {
	private static char SQUARE_BRACKET_OPEN = '[';
	private static char SQUARE_BRACKET_CLOSE = ']';
	private static char ROUND_BRACKET_OPEN = '(';
	private static char ROUND_BRACKET_CLOSE = ')';

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String sentence = br.readLine();
			if (sentence.equals(".")) {
				break;
			}

			Stack<Character> openBrackets = new Stack<>();

			String result = "yes";
			for (char c : sentence.toCharArray()) {
				if (c == SQUARE_BRACKET_OPEN || c == ROUND_BRACKET_OPEN) {
					openBrackets.add(c);
				}
				if (c == SQUARE_BRACKET_CLOSE && (openBrackets.isEmpty()
						|| openBrackets.pop() != SQUARE_BRACKET_OPEN)) {
					result = "no";
					break;
				}
				if (c == ROUND_BRACKET_CLOSE && (openBrackets.isEmpty() || openBrackets.pop() != ROUND_BRACKET_OPEN)) {
					result = "no";
					break;
				}
			}
			if (result.equals("yes") && !openBrackets.isEmpty()) {
				result = "no";
			}
			sb.append(result).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}
