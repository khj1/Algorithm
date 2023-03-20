package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13172 {

	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());

		long result = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			int g = gcd(S, N);
			N /= g;
			S /= g;

			result += S * pow(N, MOD - 2) % MOD;
			result %= MOD;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	private static long pow(final int n, final int exp) {
		if (exp == 1) {
			return n;
		}
		if (exp % 2 == 1) {
			return n * pow(n, exp - 1) % MOD;
		}
		long result = pow(n, exp / 2);
		return result * result % MOD;
	}

	private static int gcd(final int a, final int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}
