package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
public class NxN_배열_자르기 {
	public int[] solution(int n, long left, long right) {
		int length = (int)(right - left + 1);
		int[] answer = new int[length];

		for (long i = left; i <= right; i++) {
			int index = (int)(i - left);
			answer[index] = (int)(Math.max(i / n, i % n) + 1);
		}
		return answer;
	}
}
