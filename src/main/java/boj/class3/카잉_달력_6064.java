package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 카잉_달력_6064 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int leastCommonMultiple = M * N / gcd(M, N);
			int ix = 0;
			int iy = 0;
			while (true) {
				int tempX = M * ix + x;
				int tempY = N * iy + y;

				if (tempY > leastCommonMultiple || tempX > leastCommonMultiple) {
					sb.append(-1).append("\n");
					break;
				}
				if (tempX == tempY) {
					sb.append(tempX).append("\n");
					break;
				}
				if (tempX < tempY) {
					ix++;
				} else {
					iy++;
				}
			}
		}
		System.out.print(sb);
	}

	private static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}
		return gcd(n, m % n);
	}
}
