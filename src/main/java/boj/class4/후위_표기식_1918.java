package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//TODO
public class 후위_표기식_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String infix = br.readLine();
		Stack<Character> operation = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else if (c == '(') {
				operation.add(c);
			} else if (c == ')') {
				while (!operation.isEmpty() && operation.peek() != '(') {
					sb.append(operation.pop());
				}
				operation.pop();
			} else {
				while (!operation.isEmpty() && priority(operation.peek()) >= priority(c)) {
					sb.append(operation.pop());
				}
				operation.add(c);
			}
		}

		while (!operation.isEmpty()) {
			sb.append(operation.pop());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int priority(final Character character) {
		if (character == '(') {
			return 0;
		}
		if (character == '+' || character == '-') {
			return 1;
		}
		return 2;
	}
}
