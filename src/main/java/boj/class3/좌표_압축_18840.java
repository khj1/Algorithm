package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 좌표_압축_18840 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> unique = new HashSet<>();
		for (int number : numbers) {
			unique.add(number);
		}
		List<Integer> sorted = new ArrayList<>(unique);
		Collections.sort(sorted);

		for (int number : numbers) {
			int lowerCount = find(sorted, number);
			sb.append(lowerCount).append(" ");
		}
		System.out.println(sb);
	}

	private static int find(List<Integer> unique, int target) {
		int start = 0;
		int end = unique.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int current = unique.get(mid);
 
			if (current < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
}
