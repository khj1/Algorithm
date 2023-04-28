package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드_49189 {
	public int solution(int n, int[][] edge) {
		List<List<Path>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		int[] minCount = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Path> queue = new LinkedList<>();

		for (int[] e : edge) {
			int start = e[0];
			int end = e[1];

			graph.get(start).add(new Path(end, 1));
			graph.get(end).add(new Path(start, 1));

			if (start == 1) {
				queue.add(new Path(end, 1));
				minCount[end] = 1;
			}
			if (end == 1) {
				queue.add(new Path(start, 1));
				minCount[start] = 1;
			}
		}

		visited[1] = true;
		while (!queue.isEmpty()) {
			Path path = queue.poll();
			int current = path.end;
			int count = path.count;

			for (Path next : graph.get(current)) {
				if (visited[next.end]) {
					continue;
				}
				visited[next.end] = true;
				if (minCount[next.end] == 0) {
					minCount[next.end] = count + 1;
				}
				queue.add(new Path(next.end, count + 1));
			}
		}

		Arrays.sort(minCount);

		int farthestCount = 0;
		int max = minCount[n];
		while (minCount[n] == max) {
			n--;
			farthestCount++;
		}

		return farthestCount;
	}

	private class Path {
		int end;
		int count;

		public Path(final int end, final int count) {
			this.end = end;
			this.count = count;
		}
	}
}
