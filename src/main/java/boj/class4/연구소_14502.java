package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 연구소_14502 {

	static int[] nR = {-1, 0, 1, 0};
	static int[] nC = {0, -1, 0, 1};

	static int N, M;
	static int[][] map;
	static Queue<Node> viruses = new LinkedList<>();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 2) {
					viruses.add(new Node(i, j));
				}
				map[i][j] = value;
			}
		}

		buildWall(0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void buildWall(final int wallCount) {
		if (wallCount == 3) {
			max = Math.max(max, bfs());
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						buildWall(wallCount + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<>(viruses);

		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
					continue;
				}
				if (copyMap[newR][newC] != 0) {
					continue;
				}
				copyMap[newR][newC] = 2;
				queue.add(new Node(newR, newC));
			}
		}
		return countSafeZone(copyMap);
	}

	private static int countSafeZone(final int[][] map) {
		int count = 0;
		for (int[] rows : map) {
			for (int value : rows) {
				if (value == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static class Node {
		int r;
		int c;

		public Node(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}
}
