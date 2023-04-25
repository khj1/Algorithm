package programmers.lv3;

public class 최고의_집합_12938 {

	public int[] solution(int n, int s) {
		if (n > s) {
			return new int[] {-1};
		}
		int[] answer = new int[n];
		int index = 0;
		while (n > 0) {
			int next = s / n;
			answer[index++] = next;
			s -= next;
			n--;
		}
		return answer;
	}

}
