package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] video = getVideo(br, N);

		dnq(video, 1, 1, N);
		System.out.println(sb);
	}

	private static int[][] getVideo(BufferedReader br, int N) throws IOException {
		int[][] video = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			for (int j = 1; j <= N; j++) {
				String[] split = row.split("");
				video[i][j] = Integer.parseInt(split[j - 1]);
			}
		}
		return video;
	}

	private static void dnq(int[][] video, int r, int c, int length) {
		if (isAllSame(video, r, c, length)) {
			sb.append(video[r][c]);
		} else {
			int newLength = length / 2;
			sb.append("(");

			dnq(video, r, c, newLength);
			dnq(video, r, c + newLength, newLength);
			dnq(video, r + newLength, c, newLength);
			dnq(video, r + newLength, c + newLength, newLength);

			sb.append(")");
		}
	}

	private static boolean isAllSame(int[][] video, int r, int c, int length) {
		int initial = video[r][c];
		for (int i = r; i < r + length; i++) {
			for (int j = c; j < c + length; j++) {
				if (initial != video[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
