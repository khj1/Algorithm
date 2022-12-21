package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class 두_큐_합_같게_만들기 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		Queue<Integer> q1 = toQueue(queue1);
		Queue<Integer> q2 = toQueue(queue2);

		long sum1 = calculateSum(q1);
		long sum2 = calculateSum(q2);
		if ((sum1 + sum2) % 2 != 0) {
			return -1;
		}

		long half = (sum1 + sum2) / 2;
		int limit = queue1.length * 3;

		while (sum1 != half) {
			if (answer > limit) {
				return -1;
			}
			if (sum1 > half) {
				int polled = q1.poll();
				q2.add(polled);
				sum1 -= polled;
			} else {
				int polled = q2.poll();
				q1.add(polled);
				sum1 += polled;
			}
			answer++;
		}
		return answer;
	}

	private int calculateSum(Queue<Integer> newQueue1) {
		return newQueue1.stream()
				.reduce(Integer::sum)
				.get();
	}

	private Queue<Integer> toQueue(int[] queue) {
		Queue<Integer> q = new LinkedList<>();
		for (int queueNumber : queue) {
			q.add(queueNumber);
		}
		return q;
	}
}
