package programmers.lv2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더_맵게 {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		Queue<Integer> queue = new PriorityQueue<>();
		for (int number : scoville) {
			queue.add(number);
		}
		while (!queue.isEmpty()) {
			Integer leastSpicy = queue.poll();
			if (leastSpicy >= K) {
				break;
			}
			if (queue.isEmpty()) {
				answer = -1;
				break;
			}
			int newScovile = leastSpicy + queue.poll() * 2;
			queue.add(newScovile);
			answer++;
		}
		return answer;
	}
}
