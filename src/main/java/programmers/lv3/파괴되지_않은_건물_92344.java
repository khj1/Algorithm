package programmers.lv3;

//TODO
public class 파괴되지_않은_건물_92344 {

	public static final int ATTACK = 1;
	public static final int HEAL = 2;

	public int solution(int[][] board, int[][] skills) {
		int r = board.length;
		int c = board[0].length;
		int[][] sum = new int[r + 1][c + 1];

		for (int[] skill : skills) {
			int type = skill[0];
			int r1 = skill[1];
			int c1 = skill[2];
			int r2 = skill[3];
			int c2 = skill[4];
			int degree = skill[5];

			if (type == ATTACK) {
				sum[r1][c1] -= degree;
				sum[r2 + 1][c1] += degree;
				sum[r1][c2 + 1] += degree;
				sum[r2 + 1][c2 + 1] -= degree;
			}
			if (type == HEAL) {
				sum[r1][c1] += degree;
				sum[r2 + 1][c1] -= degree;
				sum[r1][c2 + 1] -= degree;
				sum[r2 + 1][c2 + 1] += degree;
			}
		}

		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				sum[i + 1][j] += sum[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum[i][j + 1] += sum[i][j];
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[i][j] += sum[i][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] > 0) {
					answer++;
				}
			}
		}
		return answer;
	}
}
