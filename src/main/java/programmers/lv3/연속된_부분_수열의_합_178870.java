package programmers.lv3;

public class 연속된_부분_수열의_합_178870 {

	public int[] solution(int[] sequence, int k) {
		int start = 0;
		int sum = 0;
		int size = sequence.length;
		int[] answer = new int[2];

		for (int end = 0; end < sequence.length; end++) {
			sum += sequence[end];

			while (sum > k) {
				sum -= sequence[start];
				start++;
			}
			if (sum == k) {
				if (size > end - start) {
					size = end - start;
					answer[0] = start;
					answer[1] = end;
				} else if (size == end - start) {
					answer[0] = Math.min(answer[0], start);
					answer[1] = Math.min(answer[1], end);
				}
			}
		}

		return answer;
	}
}
