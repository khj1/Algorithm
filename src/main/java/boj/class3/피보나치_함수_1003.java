package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class 피보나치_함수_1003 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] fibonacci0 = new int[41];
			int[] fibonacci1 = new int[41];
			fibonacci0[0] = 1;
			fibonacci0[1] = 0;
			fibonacci1[0] = 0;
			fibonacci1[1] = 1;
			for (int j = 2; j <= N; j++) {
				fibonacci0[j] = fibonacci0[j - 1] + fibonacci0[j - 2];
				fibonacci1[j] = fibonacci1[j - 1] + fibonacci1[j - 2];
			}
			System.out.println(fibonacci0[N] + " " + fibonacci1[N]);
		}
	}
}
