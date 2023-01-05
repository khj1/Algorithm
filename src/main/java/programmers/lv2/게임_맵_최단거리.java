package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임_맵_최단거리 {

	private static int[] DX = {1, 0, -1, 0};
	private static int[] DY = {0, 1, 0, -1};

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		return bfs(maps, visited, n, m);
	}

	private int bfs(int[][] maps, boolean[][] visited, int n, int m) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!nodes.isEmpty()) {
			Node node = nodes.poll();

			if (node.isComplete(n, m)) {
				return node.moveCount;
			}
			for (int i = 0; i < 4; i++) {
				int cx = node.x + DX[i];
				int cy = node.y + DY[i];

				if (cx < 0 || cy < 0 || cx >= maps.length || cy >= maps[0].length) {
					continue;
				}
				if (visited[cx][cy] || maps[cx][cy] == 0) {
					continue;
				}
				visited[cx][cy] = true;
				nodes.add(new Node(cx, cy, node.moveCount + 1));
			}
		}
		return -1;
	}

	static class Node {

		int x;
		int y;
		int moveCount;

		public Node(int x, int y, int moveCount) {
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
		}

		public boolean isComplete(int n, int m) {
			return x == n - 1 && y == m - 1;
		}
	}
}
