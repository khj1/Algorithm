package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어_16236 {

	static int[] nR = {-1, 0, 0, 1};
	static int[] nC = {0, -1, 1, 0};
	static int[][] ocean;
	static int N;
	static int min = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ocean = new int[N][N];
		Queue<BabyShark> sharkQueue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int fish = Integer.parseInt(st.nextToken());
				if (fish == 9) {
					sharkQueue.add(new BabyShark(i, j, 0, 2, 0));
				}
				ocean[i][j] = fish;
			}
		}
		eatFishes(sharkQueue);
		System.out.println(min);
	}

	private static void eatFishes(Queue<BabyShark> sharkQueue) {
		while (!sharkQueue.isEmpty()) {
			BabyShark babyShark = sharkQueue.poll();
			min = babyShark.move;
			bfs(sharkQueue, babyShark);
		}
	}

	private static void bfs(Queue<BabyShark> sharkQueue, BabyShark babyShark) {
		boolean[][] visited = new boolean[N][N];
		visited[babyShark.r][babyShark.c] = true;
		ocean[babyShark.r][babyShark.c] = 0;

		Queue<BabyShark> queue = new LinkedList<>();
		queue.add(babyShark);

		PriorityQueue<BabyShark> nextSharks = new PriorityQueue<>((o1, o2) -> {
			if (o1.move == o2.move) {
				if (o1.r == o2.r) {
					return o1.c - o2.c;
				}
				return o1.r - o2.r;
			}
			return o1.move - o2.move;
		});

		while (!queue.isEmpty()) {
			BabyShark current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newR = current.r + nR[i];
				int newC = current.c + nC[i];

				if (newR < 0 || newC < 0 || newR >= N || newC >= N) {
					continue;
				}
				if (visited[newR][newC] || current.size < ocean[newR][newC]) {
					continue;
				}
				if (ocean[newR][newC] != 0 && current.size > ocean[newR][newC]) {
					nextSharks.add(new BabyShark(newR, newC, current.move + 1, current.size, current.stomach));
					continue;
				}
				visited[newR][newC] = true;
				queue.add(new BabyShark(newR, newC, current.move + 1, current.size, current.stomach));
			}
		}

		if (!nextSharks.isEmpty()) {
			BabyShark next = nextSharks.poll();
			next.eat();
			ocean[next.r][next.c] = 0;
			sharkQueue.add(new BabyShark(next.r, next.c, next.move, next.size, next.stomach));
		}
	}

	private static class BabyShark {
		int r;
		int c;
		int move;
		int size;
		int stomach;

		public BabyShark(int r, int c, int move, int size, int stomach) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.size = size;
			this.stomach = stomach;
		}

		public void eat() {
			stomach++;
			if (stomach == size) {
				size++;
				stomach = 0;
			}
		}
	}
}
