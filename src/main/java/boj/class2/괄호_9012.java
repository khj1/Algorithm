package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String result = "NO";
			if (isVPS(br.readLine())) {
				result = "YES";
			}
			sb.append(result).append(System.lineSeparator());
		}
		System.out.println(sb);
	}

	private static boolean isVPS(String bracket) {
		int open = 0;
		int close = 0;

		for (char c : bracket.toCharArray()) {
			if (c == '(') {
				open++;
			} else {
				close++;
			}

			if (close > open) {
				return false;
			}
		}
		return open == close;
	}
}
