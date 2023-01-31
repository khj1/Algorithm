package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class Z_1074 {

	static int N, R, C, ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		solve(0, 0, (int)Math.pow(2, N));
	}

	private static void solve(int r, int c, int size) {
		if (size == 1) {
			System.out.println(ans);
			return;
		}
		int newSize = size / 2;
		if (R < r + newSize && C < c + newSize) {
			solve(r, c, newSize);
		}
		if (R < r + newSize && C >= c + newSize) {
			ans += (size * size) / 4;
			solve(r, c + newSize, newSize);
		}
		if (R >= r + newSize && C < c + newSize) {
			ans += ((size * size) / 4) * 2;
			solve(r + newSize, c, newSize);
		}
		if (R >= r + newSize && C >= c + newSize) {
			ans += ((size * size) / 4) * 3;
			solve(r + newSize, c + newSize, newSize);
		}
	}
}
