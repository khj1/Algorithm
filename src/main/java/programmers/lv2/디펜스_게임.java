package programmers.lv2;

import java.util.PriorityQueue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/142085#
 */
public class 디펜스_게임 {
	public int solution(int n, int k, int[] enemy) {
		int left = 0;
		int right = enemy.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (isDefensible(n, k, mid, enemy)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private boolean isDefensible(int n, int k, int mid, int[] enemy) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= mid; i++) {
			pq.add(enemy[i]);
		}
		while (!pq.isEmpty()) {
			Integer enemyCount = pq.poll();
			if (n >= enemyCount) {
				n -= enemyCount;
				continue;
			}

			pq.add(enemyCount);

			return pq.size() <= k;
		}
		return true;
	}
}
