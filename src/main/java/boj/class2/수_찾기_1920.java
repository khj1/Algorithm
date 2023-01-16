package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 수_찾기_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(numbers);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			int min = 0;
			int max = N - 1;

			int answer = 0;
			while (min <= max) {
				int mid = (min + max) / 2;
				int find = numbers.get(mid);
				if (find == number) {
					answer = 1;
					break;
				} else if (find > number) {
					max = mid - 1;
				} else {
					min = mid + 1;
				}
			}
			sb.append(answer).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}
