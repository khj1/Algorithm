package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class 조이스틱 {
	public int solution(String name) {
		int count = 0;
		int length = name.length();
		int move = length - 1;

		for (int i = 0; i < length; i++) {
			char target = name.charAt(i);
			count += Math.min(target - 'A', 'Z' - target + 1);

			int nextIndex = i + 1;
			while (nextIndex < length && name.charAt(nextIndex) == 'A') {
				nextIndex++;
			}
			move = Math.min(move, i * 2 + length - nextIndex);
			move = Math.min(move, (length - nextIndex) * 2 + i);
		}
		return count + move;
	}
}
