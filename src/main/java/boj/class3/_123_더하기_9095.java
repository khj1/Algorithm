package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO dp로 해결해보자
public class _123_더하기_9095 {
	private static int[] PARTS = {1, 2, 3};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int[] count = new int[1];
			int target = Integer.parseInt(br.readLine());
			dps(target, count, 0);
			System.out.println(count[0]);
		}
	}

	private static void dps(int target, int[] count, int sum) {
		if (sum == target) {
			count[0]++;
		} else if (sum < target) {
			for (int part : PARTS) {
				dps(target, count, sum + part);
			}
		}
	}
}
