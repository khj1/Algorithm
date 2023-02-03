package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값_힙_11286 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int absO1 = Math.abs(o1);
			int absO2 = Math.abs(o2);
			if (absO1 == absO2) {
				return o1 - o2;
			}
			return absO1 - absO2;
		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append(System.lineSeparator());
				} else {
					sb.append(queue.poll()).append(System.lineSeparator());
				}
			} else {
				queue.add(command);
			}
		}
		System.out.println(sb);
	}
}
