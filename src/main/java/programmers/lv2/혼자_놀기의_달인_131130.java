package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */
public class 혼자_놀기의_달인_131130 {
	private boolean[] visited;
	private List<Integer> list;

	public int solution(int[] cards) {
		visited = new boolean[cards.length];
		list = new ArrayList<>();

		for (int card : cards) {
			if (visited[card - 1]) {
				continue;
			}
			visited[card - 1] = true;
			dfs(cards, card - 1, 1);
		}

		if (list.size() < 2) {
			return 0;
		}
		list.sort(Collections.reverseOrder());

		return list.get(0) * list.get(1);
	}

	private void dfs(final int[] cards, final int index, final int count) {
		int next = cards[index];
		if (visited[next - 1]) {
			list.add(count);
			return;
		}
		visited[next - 1] = true;

		dfs(cards, next - 1, count + 1);
	}
}
