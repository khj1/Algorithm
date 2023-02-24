package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 가장_긴_바이토닉_부분_수열_11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int[] increaseDp = new int[N + 1];
		int[] decreaseDp = new int[N + 1];
		increaseDp[1] = 1;
		decreaseDp[N] = 1;

		for (int i = 2; i <= N; i++) {
			increaseDp[i] = 1;
			for (int j = 1; j <= i - 1; j++) {
				if (numbers[i] > numbers[j] && increaseDp[i] <= increaseDp[j]) {
					increaseDp[i] = increaseDp[j] + 1;
				}
			}
		}

		for (int i = N - 1; i >= 1; i--) {
			decreaseDp[i] = 1;
			for (int j = N; j >= i + 1; j--) {
				if (numbers[i] > numbers[j] && decreaseDp[i] <= decreaseDp[j]) {
					decreaseDp[i] = decreaseDp[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, increaseDp[i] + decreaseDp[i] - 1);
		}
		System.out.println(max);
	}
}
