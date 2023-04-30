package programmers.lv3;

public class 가장_긴_팰린드롬_12904 {
	public int solution(String s) {
		int answer = 1;

		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > i; j--) {
				int start = i;
				int end = j;

				if (answer > j - i + 1) {
					break;
				}
				if (s.charAt(start) != s.charAt(end)) {
					continue;
				}
				while (start < end && s.charAt(start) == s.charAt(end)) {
					start++;
					end--;
				}
				if (start >= end) {
					answer = Math.max(answer, j - i + 1);
				}
			}
		}
		return answer;
	}
}
