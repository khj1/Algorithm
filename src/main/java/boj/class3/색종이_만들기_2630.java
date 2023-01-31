package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기_2630 {

	static int blueCount = 0;
	static int whiteCount = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		paper = readPaper(br, N);

		cuttingPaper(0, 0, N);

		sb.append(whiteCount).append("\n").append(blueCount);
		System.out.println(sb);
	}

	private static void cuttingPaper(int startRow, int startCol, int length) {
		if (isAllBlue(startRow, startCol, length)) {
			blueCount++;
		} else if (isAllWhite(startRow, startCol, length)) {
			whiteCount++;
		} else {
			int midRow = startRow + length / 2;
			int midCol = startCol + length / 2;
			length /= 2;

			if (length == 0) {
				return;
			}

			cuttingPaper(startRow, startCol, length);
			cuttingPaper(startRow, midCol, length);
			cuttingPaper(midRow, startCol, length);
			cuttingPaper(midRow, midCol, length);
		}
	}

	private static int[][] readPaper(BufferedReader br, int N) throws IOException {
		int[][] paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		return paper;
	}

	private static boolean isAllBlue(int startRow, int startCol, int length) {
		for (int i = startRow; i < startRow + length; i++) {
			for (int j = startCol; j < startCol + length; j++) {
				if (paper[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAllWhite(int startRow, int startCol, int length) {
		for (int i = startRow; i < startRow + length; i++) {
			for (int j = startCol; j < startCol + length; j++) {
				if (paper[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
