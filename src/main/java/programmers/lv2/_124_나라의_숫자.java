package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */
public class _124_나라의_숫자 {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int r = n % 3;
			if (r == 0) {
				sb.append(4);
				n--;
			} else {
				sb.append(r);
			}
			n /= 3;
		}
		return sb.reverse().toString();
	}
}
