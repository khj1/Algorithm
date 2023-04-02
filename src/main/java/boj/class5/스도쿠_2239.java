package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//TODO
public class 스도쿠_2239 {

	static int[][] sudoku = new int[9][9];
	static boolean end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			String row = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Character.getNumericValue(row.charAt(j));
			}
		}

		dfs(0);

		for (int[] row : sudoku) {
			for (int number : row) {
				sb.append(number);
			}
			sb.append(System.lineSeparator());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(final int depth) {
		if (depth == 81) {
			end = true;
			return;
		}

		int r = depth / 9;
		int c = depth % 9;

		if (sudoku[r][c] != 0) {
			dfs(depth + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!isValid(r, c, i)) {
					continue;
				}

				sudoku[r][c] = i;
				dfs(depth + 1);
				if (end) {
					return;
				}
				sudoku[r][c] = 0;
			}
		}
	}

	private static boolean isValid(final int r, final int c, final int n) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[r][i] == n || sudoku[i][c] == n) {
				return false;
			}
		}

		int nR = r / 3 * 3;
		int nC = c / 3 * 3;
		for (int j = nR; j < nR + 3; j++) {
			for (int k = nC; k < nC + 3; k++) {
				if (sudoku[j][k] == n) {
					return false;
				}
			}
		}
		return true;
	}
}
