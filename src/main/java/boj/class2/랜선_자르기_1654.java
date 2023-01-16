package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 랜선_자르기_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<Integer> lanLines = new ArrayList<>();
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < K; i++) {
			int value = Integer.parseInt(br.readLine());
			max = Math.max(max, value);
			lanLines.add(value);
		}

		long min = 1;
		while (min <= max) {
			long count = 0;
			long mid = (max + min) / 2;
			for (Integer lanLine : lanLines) {
				count += lanLine / mid;
			}
			if (count < N) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println((max + min) / 2);
	}
}
