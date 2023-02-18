package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 조합_2407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger answer = BigInteger.ONE;
		int count = 0;
		while (count < m) {
			answer = answer.multiply(new BigInteger(String.valueOf(n - count)));
			count++;
		}

		while (count > 0) {
			answer = answer.divide(new BigInteger(String.valueOf(count)));
			count--;
		}

		System.out.println(answer);
	}
}
