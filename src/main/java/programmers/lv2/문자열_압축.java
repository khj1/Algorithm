package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class 문자열_압축 {

	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= s.length() / 2; i++) {
			Queue<String> queue = toQueue(s, i + 1);
			StringBuilder sb = new StringBuilder();
			while (!queue.isEmpty()) {
				String poll = queue.poll();
				int count = 1;
				while (!queue.isEmpty() && queue.peek().equals(poll)) {
					queue.poll();
					count++;
				}
				if (count >= 2) {
					sb.append(count).append(poll);
				} else {
					sb.append(poll);
				}
			}
			answer = Math.min(answer, sb.length());
		}
		return answer;
	}

	private Queue<String> toQueue(String s, int i) {
		Queue<String> queue = new LinkedList<>();
		while (!s.isBlank()) {
			if (s.length() < i) {
				queue.add(s);
				break;
			}
			queue.add(s.substring(0, i));
			s = s.substring(i);
		}
		return queue;
	}
}
