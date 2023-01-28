package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최대_힙_11279 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(command);
			}
		}
	}
}
