package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_수열_1874 {

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int current = 0;
		boolean isFail = false;
		for (int i = 0; i < n; i++) {
			int target = Integer.parseInt(br.readLine());
			while ((stack.isEmpty() || stack.peek() != target) && current < n) {
				stack.add(++current);
				sb.append("+").append(System.lineSeparator());
			}
			if (!stack.isEmpty() && current == n && stack.peek() != target) {
				isFail = true;
				break;
			}
			stack.pop();
			sb.append("-").append(System.lineSeparator());
		}

		if (isFail) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}
}
