package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숫자카드_2_10816 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		Map<Integer, Integer> numbers = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st1.nextToken());
			numbers.put(number, numbers.getOrDefault(number, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

		Queue<Integer> targets = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			targets.add(Integer.parseInt(st2.nextToken()));
		}

		while (!targets.isEmpty()) {
			int result = 0;
			Integer target = targets.poll();
			if (numbers.containsKey(target)) {
				result = numbers.get(target);
			}
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}
}
