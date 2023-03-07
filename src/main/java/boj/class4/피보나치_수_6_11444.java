package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class 피보나치_수_6_11444 {

	static final int MOD = 1_000_000_007;
	static final long[][] ORIGIN = {{1, 1}, {1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long[][] A = {{1, 1}, {1, 0}};
		long[][] result = pow(A, n - 1);

		System.out.println(result[0][0] % MOD);
	}

	static long[][] pow(long[][] A, long exp) {
		if (exp == 1 || exp == 0) {
			return A;
		}

		long[][] half = pow(A, exp / 2);
		long[][] result = multiply(half, half);

		if (exp % 2 == 1) {
			result = multiply(result, ORIGIN);
		}
		return result;
	}

	private static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] result = new long[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] += o1[i][k] * o2[k][j];
					result[i][j] %= MOD;
				}
			}
		}
		return result;
	}
}
