package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2048_12100 {

	static int N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		move(board, 0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void move(final int[][] board, final int count) {
		if (count == 5) {
			max = Math.max(max, getBiggest(board));
		} else {
			move(moveUp(board), count + 1);
			move(moveDown(board), count + 1);
			move(moveLeft(board), count + 1);
			move(moveRight(board), count + 1);
		}
	}

	private static int[][] moveUp(final int[][] board) {
		boolean[][] isMerged = new boolean[N][N];
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == 0) {
					continue;
				}

				int k = i - 1;
				while (k > 0 && temp[k][j] == 0) {
					k--;
				}
				if (temp[k][j] == temp[i][j] && !isMerged[k][j]) {
					isMerged[k][j] = true;
					temp[k][j] += temp[i][j];
					temp[i][j] = 0;
				} else if (temp[k][j] == 0) {
					temp[k][j] = temp[i][j];
					temp[i][j] = 0;
				} else if (k != i - 1) {
					temp[k + 1][j] = temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
		return temp;
	}

	private static int[][] moveDown(final int[][] board) {
		boolean[][] isMerged = new boolean[N][N];
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == 0) {
					continue;
				}

				int k = i + 1;
				while (k < N - 1 && temp[k][j] == 0) {
					k++;
				}
				if (temp[k][j] == temp[i][j] && !isMerged[k][j]) {
					isMerged[k][j] = true;
					temp[k][j] += temp[i][j];
					temp[i][j] = 0;
				} else if (temp[k][j] == 0) {
					temp[k][j] = temp[i][j];
					temp[i][j] = 0;
				} else if (k != i + 1) {
					temp[k - 1][j] = temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
		return temp;
	}

	private static int[][] moveLeft(final int[][] board) {
		boolean[][] isMerged = new boolean[N][N];
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (temp[i][j] == 0) {
					continue;
				}

				int k = j - 1;
				while (k > 0 && temp[i][k] == 0) {
					k--;
				}
				if (temp[i][k] == temp[i][j] && !isMerged[i][k]) {
					isMerged[i][k] = true;
					temp[i][k] += temp[i][j];
					temp[i][j] = 0;
				} else if (temp[i][k] == 0) {
					temp[i][k] = temp[i][j];
					temp[i][j] = 0;
				} else if (k != j - 1) {
					temp[i][k + 1] = temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
		return temp;
	}

	private static int[][] moveRight(final int[][] board) {
		boolean[][] isMerged = new boolean[N][N];
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}

		for (int i = 0; i < N; i++) {
			for (int j = N - 2; j >= 0; j--) {
				if (temp[i][j] == 0) {
					continue;
				}

				int k = j + 1;
				while (k < N - 1 && temp[i][k] == 0) {
					k++;
				}
				if (temp[i][k] == temp[i][j] && !isMerged[i][k]) {
					isMerged[i][k] = true;
					temp[i][k] += temp[i][j];
					temp[i][j] = 0;
				} else if (temp[i][k] == 0) {
					temp[i][k] = temp[i][j];
					temp[i][j] = 0;
				} else if (k != j + 1) {
					temp[i][k - 1] = temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
		return temp;
	}

	private static int getBiggest(final int[][] board) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
}
