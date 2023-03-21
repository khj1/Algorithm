package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
//DP 풀이 확인
public class 파이프_옮기기_1_17070 {

	static int N;
	static int[][] home;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		home = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new Pipe(1, 2, Status.HORIZONTAL));

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(final Pipe pipe) {
		int currentRow = pipe.row;
		int currentCol = pipe.col;
		Status status = pipe.status;

		if (currentRow == N && currentCol == N) {
			count++;
		} else {
			if (status == Status.HORIZONTAL) {
				moveHorizontally(currentRow, currentCol);
				moveDiagonally(currentRow, currentCol);
			} else if (status == Status.DIAGONAL) {
				moveHorizontally(currentRow, currentCol);
				moveDiagonally(currentRow, currentCol);
				moveVertically(currentRow, currentCol);
			} else if (status == Status.VERTICAL) {
				moveVertically(currentRow, currentCol);
				moveDiagonally(currentRow, currentCol);
			}
		}
	}

	private static void moveHorizontally(final int currentRow, final int currentCol) {
		int nextCol = currentCol + 1;
		if (nextCol > N) {
			return;
		}
		if (home[currentRow][nextCol] == 1) {
			return;
		}
		dfs(new Pipe(currentRow, nextCol, Status.HORIZONTAL));
	}

	private static void moveDiagonally(final int currentRow, final int currentCol) {
		int nextRow = currentRow + 1;
		int nextCol = currentCol + 1;
		if (nextRow > N || nextCol > N) {
			return;
		}
		if (home[currentRow][nextCol] == 1 || home[nextRow][currentCol] == 1 || home[nextRow][nextCol] == 1) {
			return;
		}
		dfs(new Pipe(nextRow, nextCol, Status.DIAGONAL));
	}

	private static void moveVertically(final int currentRow, final int currentCol) {
		int nextRow = currentRow + 1;
		if (nextRow > N) {
			return;
		}
		if (home[nextRow][currentCol] == 1) {
			return;
		}
		dfs(new Pipe(nextRow, currentCol, Status.VERTICAL));
	}

	enum Status {
		VERTICAL, DIAGONAL, HORIZONTAL
	}

	static class Pipe {
		int row;
		int col;
		Status status;

		public Pipe(final int row, final int col, final Status status) {
			this.row = row;
			this.col = col;
			this.status = status;
		}
	}

}
