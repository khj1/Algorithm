package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와_최소공배수_2609 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int numberA = Integer.parseInt(st.nextToken());
		int numberB = Integer.parseInt(st.nextToken());

		int divisor = Math.min(numberA, numberB);
		int multiple = Math.max(numberA, numberB);
		int bigger = multiple;

		int commonDivisor = -1;
		int commonMultiple = -1;

		while (commonDivisor == -1 && divisor > 0) {
			if (numberA % divisor == 0 && numberB % divisor == 0) {
				commonDivisor = divisor;
			}
			divisor--;
		}

		int multiplier = 1;
		while (commonMultiple == -1) {
			if (multiple % numberA == 0 && multiple % numberB == 0) {
				commonMultiple = multiple;
			}
			multiplier++;
			multiple = bigger * multiplier;
		}
		sb.append(commonDivisor).append(System.lineSeparator()).append(commonMultiple);
		System.out.println(sb);
	}
}
