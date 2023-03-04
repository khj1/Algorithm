package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 행렬_제곱_10830 {

	static final int MOD = 1_000;
	static int N;
	static int[][] origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Long B = Long.parseLong(st.nextToken());

		initOrigin(br);

		int[][] result = pow(origin, B);

		System.out.print(matrixToString(result));
	}

	private static void initOrigin(BufferedReader br) throws IOException {
		origin = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
	}

	private static int[][] pow(int[][] A, Long exp) {
		if (exp == 1) {
			return A;
		}
		int[][] result = pow(A, exp / 2);
		result = matrixMultiply(result, result);

		if (exp % 2 == 1) {
			result = matrixMultiply(result, origin);
		}
		return result;
	}

	private static int[][] matrixMultiply(int[][] o1, int[][] o2) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += (o1[i][k] * o2[k][j]) % MOD;
				}
			}
		}
		return result;
	}

	private static StringBuilder matrixToString(int[][] result) {
		StringBuilder sb = new StringBuilder();
		for (int[] ints : result) {
			for (int anInt : ints) {
				sb.append(anInt % MOD).append(" ");
			}
			sb.append(System.lineSeparator());
		}
		return sb;
	}
}
