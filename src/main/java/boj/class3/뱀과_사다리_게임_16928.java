package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class 뱀과_사다리_게임_16928 {

	static int[] ans = new int[101];
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		initBoard();
		putLadderAndSnake(br, N);
		putLadderAndSnake(br, M);

		bfs();
	}

	private static void putLadderAndSnake(BufferedReader br, int N) throws IOException {
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int installation = Integer.parseInt(st2.nextToken());
			int next = Integer.parseInt(st2.nextToken());
			board[installation] = next;
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == 100) {
				System.out.println(ans[current]);
				return;
			}
			for (int i = 1; i <= 6; i++) {
				int next = current + i;
				if (next <= 100 && !visited[board[next]]) {
					visited[board[next]] = true;
					ans[board[next]] = ans[current] + 1;
					queue.add(board[next]);
				}
			}
		}
	}

	private static void initBoard() {
		for (int i = 1; i <= 100; i++) {
			board[i] = i;
		}
	}
}
