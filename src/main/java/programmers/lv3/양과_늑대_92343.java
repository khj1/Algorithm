package programmers.lv3;

public class 양과_늑대_92343 {
	private int[] gInfo;
	private int[][] gEdges;

	private int max = Integer.MIN_VALUE;

	public int solution(int[] info, int[][] edges) {
		gInfo = info;
		gEdges = edges;
		boolean[] visited = new boolean[info.length];

		dfs(visited, 0, 0, 0);

		return max;
	}

	private void dfs(final boolean[] visited, final int current, final int sheep, final int wolf) {
		visited[current] = true;

		int newSheep = sheep;
		int newWolf = wolf;
		if (gInfo[current] == 0) {
			newSheep++;
			max = Math.max(max, newSheep);
		}
		if (gInfo[current] == 1) {
			newWolf++;
		}

		if (newSheep <= newWolf) {
			return;
		}

		for (int[] edge : gEdges) {
			if (visited[edge[0]] && !visited[edge[1]]) {
				dfs(visited.clone(), edge[1], newSheep, newWolf);
			}
		}
	}
}
