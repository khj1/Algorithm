package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 곱셈_1629 {

	static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(pow(A, B));
	}

	private static long pow(long A, long B) {
		if (B == 0) {
			return 1;
		}
		long n = pow(A, B / 2);
		if (B % 2 == 0) {
			return n * n % C;
		}
		return (n * n % C) * A % C;
	}
}
