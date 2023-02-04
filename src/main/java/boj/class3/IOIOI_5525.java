package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class IOIOI_5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();

		int count = 0;
		int result = 0;
		for (int i = 1; i < M - 1; i++) {
			if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				count++;

				if (count == N) {
					result++;
					count--;
				}
				i++;
			} else {
				count = 0;
			}
		}
		System.out.println(result);
	}
}
