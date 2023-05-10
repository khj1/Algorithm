package programmers.lv2;

public class 쿼드압축_후_개수_세기_68936 {

	private int[] answer = new int[2];

	public int[] solution(int[][] arr) {
		compress(arr, 0, 0, arr.length);

		return answer;
	}

	private void compress(final int[][] arr, final int r, final int c, final int length) {
		if (isAllSame(arr, r, c, length)) {
			answer[arr[r][c]]++;
		} else {
			int newLength = length / 2;
			compress(arr, r, c, newLength);
			compress(arr, r, c + newLength, newLength);
			compress(arr, r + newLength, c, newLength);
			compress(arr, r + newLength, c + newLength, newLength);
		}
	}

	private boolean isAllSame(final int[][] arr, final int r, final int c, final int length) {
		for (int i = r; i < r + length; i++) {
			for (int j = c; j < c + length; j++) {
				if (arr[i][j] != arr[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}
