package programmers.lv2;

public class 가장_큰_정사각형_찾기_12905 {

	public int solution(int[][] board) {
		if (isAllZero(board)) {
			return 0;
		}
		int n = 1;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
				n = Math.max(n, board[i][j]);
			}
		}
		return n * n;
	}

	private boolean isAllZero(final int[][] board) {
		for (int[] row : board) {
			for (int number : row) {
				if (number == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
