package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소_힙_1927 {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
