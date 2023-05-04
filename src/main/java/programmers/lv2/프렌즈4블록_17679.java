package programmers.lv2;

public class 프렌즈4블록_17679 {

	private int M, N;

	public int solution(int m, int n, String[] board) {
		M = m;
		N = n;

		char[][] friends = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				friends[i][j] = board[i].charAt(j);
			}
		}

		char[][] result = new char[m][n];
		for (int i = 0; i < m; i++) {
			result[i] = friends[i].clone();
		}

		boolean isRenewed = true;
		while (isRenewed) {
			isRenewed = false;

			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (bfs(friends, result, i, j)) {
						isRenewed = true;
					}
				}
			}

			if (isRenewed) {
				for (int i = m - 2; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						if (result[i][j] != ' ') {
							downFriends(result, i, j);
						}
					}
				}
				for (int i = 0; i < m; i++) {
					friends[i] = result[i].clone();
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (friends[i][j] == ' ') {
					answer++;
				}
			}
		}

		return answer;
	}

	private boolean bfs(final char[][] friends, final char[][] result, final int r, final int c) {
		if (friends[r][c] == ' ') {
			return false;
		}
		if (friends[r][c] == friends[r][c + 1] &&
				friends[r][c] == friends[r + 1][c] &&
				friends[r][c] == friends[r + 1][c + 1]) {

			result[r][c] = ' ';
			result[r][c + 1] = ' ';
			result[r + 1][c] = ' ';
			result[r + 1][c + 1] = ' ';

			return true;
		}
		return false;
	}

	private void downFriends(final char[][] result, int i, final int j) {
		for (int k = i + 1; k < M; k++) {
			if (result[k][j] == ' ') {
				result[k][j] = result[k - 1][j];
				result[k - 1][j] = ' ';
			}
		}
	}
}
