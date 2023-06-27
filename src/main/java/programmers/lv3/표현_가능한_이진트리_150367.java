package programmers.lv3;

public class 표현_가능한_이진트리_150367 {

	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			long number = numbers[i];

			StringBuilder binaryString = new StringBuilder(Long.toBinaryString(number));

			int pow = 1;
			while (binaryString.length() > pow - 1) {
				pow *= 2;
			}

			while (binaryString.length() < pow - 1) {
				binaryString.insert(0, "0");
			}

			if (dfs(binaryString.toString())) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	private boolean dfs(final String binaryString) {
		boolean canMakeTree = true;

		int mid = (binaryString.length() - 1) / 2;
		char root = binaryString.charAt(mid);
		String left = binaryString.substring(0, mid);
		String right = binaryString.substring(mid + 1);

		if (root == '0' && (left.charAt((left.length() - 1) / 2) == '1'
				|| right.charAt((right.length() - 1) / 2) == '1')) {
			return false;
		}

		if (left.length() >= 3) {
			canMakeTree = dfs(left);
			if (canMakeTree) {
				canMakeTree = dfs(right);
			}
		}
		return canMakeTree;
	}
}
