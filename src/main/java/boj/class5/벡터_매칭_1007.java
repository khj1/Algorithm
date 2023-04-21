package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class 벡터_매칭_1007 {

	static int N;
	static int[][] vectors;
	static boolean[] visited;
	static double minSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			vectors = new int[N][2];
			visited = new boolean[N];
			minSum = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				vectors[j][0] = Integer.parseInt(st.nextToken());
				vectors[j][1] = Integer.parseInt(st.nextToken());
			}

			dfs(0, N / 2);

			bw.write(minSum + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(final int index, final int count) {
		if (count == 0) {
			minSum = Math.min(minSum, getVector());
		} else {
			for (int i = index; i < N; i++) {
				visited[i] = true;
				dfs(i + 1, count - 1);
				visited[i] = false;
			}
		}
	}

	private static double getVector() {
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				x += vectors[i][0];
				y += vectors[i][1];
			} else {
				x -= vectors[i][0];
				y -= vectors[i][1];
			}
		}
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
