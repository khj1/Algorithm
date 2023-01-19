package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터_큐_1966 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int countOfCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < countOfCase; i++) {
			Queue<Integer> queue = new LinkedList<>();

			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int countOfPaper = Integer.parseInt(st1.nextToken());
			int targetIndex = Integer.parseInt(st1.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			while (st2.hasMoreTokens()) {
				queue.add(Integer.parseInt(st2.nextToken()));
			}

			int count = 0;
			while (!queue.isEmpty()) {
				if (isPrior(queue)) {
					count++;
					queue.poll();
					if (targetIndex == 0) {
						sb.append(count).append(System.lineSeparator());
						break;
					}
				} else {
					queue.add(queue.poll());
				}
				targetIndex--;
				if (targetIndex < 0) {
					targetIndex = queue.size() - 1;
				}
			}
		}
		System.out.println(sb);
	}

	private static boolean isPrior(Queue<Integer> queue) {
		Integer peek = queue.peek();
		for (Integer number : queue) {
			if (number > peek) {
				return false;
			}
		}
		return true;
	}
}
