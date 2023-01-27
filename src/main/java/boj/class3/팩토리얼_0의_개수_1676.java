package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼_0의_개수_1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		if (N == 0) {
			N = 1;
		}

		int count = 0;
		for (long i = N - 1; i >= 1; i--) {
			N *= i;
			long temp = N % 1_000_000_000;
			if (temp == 0) {
				count += 9;
				N /= 1_000_000_000;
			} else {
				N = temp;
			}
		}
		String word = String.valueOf(N);

		for (int i = word.length() - 1; i >= 0; i--) {
			if (word.charAt(i) != '0') {
				break;
			}
			count++;
		}
		System.out.println(count);
	}
}
