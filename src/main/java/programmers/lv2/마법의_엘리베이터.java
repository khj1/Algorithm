package programmers.lv2;

import java.util.stream.Stream;

/*
/TODO
https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */
public class 마법의_엘리베이터 {
	public int solution(int storey) {
		int p = findProximityLarger(storey);
		int count = 0;

		while (p >= 2) {
			int big = (int)Math.pow(10, p);
			int small = (int)Math.pow(10, p - 1);
			int tiny = (int)Math.pow(10, p - 2);

			if (storey < small) {
				p--;
				continue;
			}
			if (storey > 5 * small + 5 * tiny) {
				storey = big - storey;
				count++;
			}
			if (storey % small > 5 * tiny) {
				count += storey / small + 1;
				storey = small - (storey % small);
			} else {
				count += storey / small;
				storey = storey % small;
			}
		}
		return count + Math.min(storey, 11 - storey);
	}

	private int findProximityLarger(int storey) {
		return Stream.iterate(-1, c -> c + 1)
				.filter(c -> Math.pow(10, c) >= storey)
				.findFirst()
				.get();
	}
}
