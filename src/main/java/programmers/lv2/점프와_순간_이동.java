package programmers.lv2;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class 점프와_순간_이동 {

	public int solution(int n) {
		int k = 0;
		while (n > 0) {
			if (n % 2 != 0) {
				n -= 1;
				k++;
			}
			n /= 2;
		}
		return k;
	}
}
