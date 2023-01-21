package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class Hashing_15829 {

	private static final int R = 31;
	private static final int M = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		String word = br.readLine();
		char[] chars = word.toCharArray();

		long H = 0;
		long pow = 1;
		for (int i = 0; i < L; i++) {
			H += ((chars[i] - 'a' + 1) * pow) % M;
			pow = (pow * R) % M;
		}
		System.out.print(H % M);
	}
}
