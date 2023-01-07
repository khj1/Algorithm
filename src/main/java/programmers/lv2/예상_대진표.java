package programmers.lv2;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class 예상_대진표 {
	public int solution(int n, int a, int b) {
		int count = 0;
		while (a != b) {
			a = next(a);
			b = next(b);
			count++;
		}
		return count;
	}

	private int next(int number) {
		if (number == 1) {
			return 1;
		}
		if (number % 2 == 1) {
			return number / 2 + 1;
		}
		return number / 2;
	}
}
