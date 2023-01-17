package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수_정렬하기2_2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			queue.add(number);
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.poll()).append(System.lineSeparator());
		}

		System.out.println(sb);
	}
}
