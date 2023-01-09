package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */
public class _2xn_타일링 {
	public int solution(int n) {
		int prev = 0;
		int current = 1;
		while (n-- > 0) {
			int temp = current;
			current += prev;
			current %= 1_000_000_007;
			prev = temp;
		}
		return current;
	}
}
