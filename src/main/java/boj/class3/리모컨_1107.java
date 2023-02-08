package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 리모컨_1107 {

	static boolean[] isBroken = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int current = 100;
		int diff = Math.abs(target - current);
		int minCount = Integer.MAX_VALUE;

		for (int i = 0; i <= 999_999; i++) {
			String currentString = String.valueOf(i);
			int length = currentString.length();

			boolean hasBrokenNumber = false;
			for (String s : currentString.split("")) {
				if (isBroken[Integer.parseInt(s)]) {
					hasBrokenNumber = true;
					break;
				}
			}
			if (hasBrokenNumber) {
				continue;
			}
			minCount = Math.min(minCount, Math.abs(target - i) + length);
		}
		minCount = Math.min(minCount, diff);
		System.out.println(minCount);
	}
}
