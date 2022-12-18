package programmers;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
public class 점_찍기 {

	public long solution(int k, int d) {
		long answer = 0;

		for (int i = 0; i <= d / k; i++) {
			long x = (long)i * k;
			long y = (long)Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)) / k;
			answer += y + 1;
		}
		return answer;
	}
}
