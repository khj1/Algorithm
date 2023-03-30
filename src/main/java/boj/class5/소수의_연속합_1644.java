package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 소수의_연속합_1644 {

	static int N;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		for (int i = 0; i < primes.size(); i++) {
			find(primes, i);
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();

	}

	private static void find(final List<Integer> primes, final int start) {
		int result = 0;

		for (int i = start; i < primes.size(); i++) {
			result += primes.get(i);
			if (result >= N) {
				break;
			}
		}

		if (result == N) {
			count++;
		}
	}

	private static boolean isPrime(final int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
