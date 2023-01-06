package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class 뉴스_클러스터링 {
	public int solution(String str1, String str2) {

		Queue<String> q1 = getMultiple(str1.toUpperCase());
		Queue<String> q2 = getMultiple(str2.toUpperCase());

		int totalCount = q1.size() + q2.size();
		int intersectionCount = calculateIntersectionCount(q1, q2);
		int unionCount = totalCount - intersectionCount;
		if (unionCount == 0) {
			return 65536;
		}
		return jaccard(intersectionCount, unionCount);
	}

	private int calculateIntersectionCount(Queue<String> q1, Queue<String> q2) {
		int intersectionCount = 0;
		while (!q1.isEmpty()) {
			String p1 = q1.poll();
			for (int i = 0; i < q2.size(); i++) {
				String p2 = q2.poll();
				if (p1.equals(p2)) {
					intersectionCount++;
					break;
				}
				q2.add(p2);
			}
		}
		return intersectionCount;
	}

	private int jaccard(int intersectionCount, int unionCount) {
		double j = (double)intersectionCount / unionCount;
		return (int)(Math.floor(j * 65536));
	}

	private Queue<String> getMultiple(String str) {
		return IntStream.range(0, str.length() - 1)
				.mapToObj(i -> str.substring(i, i + 2))
				.filter(this::isValid)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	private boolean isValid(String substring) {
		for (char c : substring.toCharArray()) {
			if (c < 'A' || c > 'Z') {
				return false;
			}
		}
		return true;
	}
}
