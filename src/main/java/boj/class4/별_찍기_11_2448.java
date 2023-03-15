package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 별_찍기_11_2448 {

	static int N;
	static String[][] stars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		stars = new String[N][N * 2 - 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], " ");
		}

		addStars(0, N - 1, N);

		for (String[] star : stars) {
			for (String s : star) {
				sb.append(s);
			}
			sb.append(System.lineSeparator());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void addStars(final int row, final int col, final int n) {
		if (n == 3) {
			addStar(row, col);
		} else {
			int half = n / 2;
			addStars(row, col, half);
			addStars(row + half, col + half, half);
			addStars(row + half, col - half, half);
		}
	}

	private static void addStar(final int row, final int col) {
		stars[row][col] = "*";

		stars[row + 1][col - 1] = "*";
		stars[row + 1][col + 1] = "*";

		stars[row + 2][col - 2] = "*";
		stars[row + 2][col - 1] = "*";
		stars[row + 2][col] = "*";
		stars[row + 2][col + 1] = "*";
		stars[row + 2][col + 2] = "*";
	}
}
