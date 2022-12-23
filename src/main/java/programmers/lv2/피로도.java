package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {
	private int maxCount;
	private boolean[] visited;

	public int solution(int k, int[][] dungeons) {
		maxCount = 0;
		visited = new boolean[dungeons.length];

		dfs(0, k, dungeons);

		return maxCount;
	}

	private void dfs(int depth, int currentTiredness, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && dungeons[i][0] <= currentTiredness) {
				visited[i] = true;
				dfs(depth + 1, currentTiredness - dungeons[i][1], dungeons);
				visited[i] = false;
			}
		}
		maxCount = Math.max(maxCount, depth);
	}
}
