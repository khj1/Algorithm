package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 단지번호붙이기_2667 {

	private static int[] nX = {-1, 0, 1, 0};
	private static int[] nY = {0, -1, 0, 1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = getMap(br, N);
		visited = new boolean[N][N];
		Map<Integer, Integer> complexes = new HashMap<>();

		int complexNumber = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j] == 0) {
					continue;
				}
				dfs(complexes, N, i, j, complexNumber++);
			}
		}

		List<Integer> result = complexes.values()
				.stream().sorted()
				.collect(Collectors.toList());

		System.out.println(complexes.size());
		for (Integer count : result) {
			System.out.println(count);
		}
	}

	private static int[][] getMap(BufferedReader br, int N) throws IOException {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		return map;
	}

	private static void dfs(Map<Integer, Integer> complexes, int N, int i, int j, int complexNumber) {
		visited[i][j] = true;
		complexes.put(complexNumber, complexes.getOrDefault(complexNumber, 0) + 1);

		for (int m = 0; m < 4; m++) {
			int nextX = i + nX[m];
			int nextY = j + nY[m];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}
			if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
				continue;
			}
			dfs(complexes, N, nextX, nextY, complexNumber);
		}
	}
}
