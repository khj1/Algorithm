package programmers.lv2;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class N진수_게임 {
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		int count = 0;
		while (t > 0) {
			String nDecimal = Integer.toString(i, n);
			for (String c : nDecimal.split("")) {
				if (count % m + 1 == p) {
					sb.append(c.toUpperCase());
					t--;

					if (t == 0) {
						break;
					}
				}
				count++;
			}
			i++;
		}
		return sb.toString();
	}
}
