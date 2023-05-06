package programmers.lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근_지수_12927 {
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int work : works) {
			pq.add(work);
		}

		while (n > 0 && pq.peek() > 0) {
			pq.add(pq.poll() - 1);
			n--;
		}

		long answer = 0;
		while (!pq.isEmpty()) {
			answer += Math.pow(pq.poll(), 2);
		}

		return answer;
	}
}
