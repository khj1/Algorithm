package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의_개수_1780 {

	static int minusCount = 0;
	static int zeroCount = 0;
	static int plusCount = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		paper = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count(1, 1, N);

		System.out.println(minusCount);
		System.out.println(zeroCount);
		System.out.println(plusCount);
	}

	private static void count(int r, int c, int paperLength) {
		if (isAllSame(r, c, paperLength)) {
			addCount(r, c);
		} else {
			int newLength = paperLength / 3;
			count(r, c, newLength);
			count(r, c + newLength, newLength);
			count(r, c + newLength * 2, newLength);
			count(r + newLength, c, newLength);
			count(r + newLength, c + newLength, newLength);
			count(r + newLength, c + newLength * 2, newLength);
			count(r + newLength * 2, c, newLength);
			count(r + newLength * 2, c + newLength, newLength);
			count(r + newLength * 2, c + newLength * 2, newLength);
		}
	}

	private static boolean isAllSame(int r, int c, int paperLength) {
		int initial = paper[r][c];
		for (int i = r; i < r + paperLength; i++) {
			for (int j = c; j < c + paperLength; j++) {
				if (paper[i][j] != initial) {
					return false;
				}
			}
		}
		return true;
	}

	private static void addCount(int r, int c) {
		int value = paper[r][c];
		if (value == -1) {
			minusCount++;
		}
		if (value == 0) {
			zeroCount++;
		}
		if (value == 1) {
			plusCount++;
		}
	}

}
