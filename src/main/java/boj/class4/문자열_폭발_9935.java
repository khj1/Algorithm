package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//TODO
public class 문자열_폭발_9935 {

	static final String EMPTY_RESULT = "FRULA";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String result = br.readLine();
		String target = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < result.length(); i++) {
			stack.add(result.charAt(i));

			if (stack.size() >= target.length()) {
				boolean contains = true;
				for (int j = 0; j < target.length(); j++) {
					Character c1 = stack.get(stack.size() - target.length() + j);
					Character c2 = target.charAt(j);
					if (c1 != c2) {
						contains = false;
						break;
					}
				}

				if (contains) {
					for (int j = 0; j < target.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		if (stack.isEmpty()) {
			System.out.println(EMPTY_RESULT);
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character character : stack) {
				sb.append(character);
			}
			System.out.println(sb);
		}
	}
}
