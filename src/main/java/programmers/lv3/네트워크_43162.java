package programmers.lv3;

public class 네트워크_43162 {

	public int solution(int n, int[][] computers) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					continue;
				}
				for (int k = 0; k < n; k++) {
					if (computers[i][k] == 1 && computers[k][j] == 1) {
						computers[i][j] = 1;
						computers[j][i] = 1;
						break;
					}
				}
			}
		}

		int countOfNetwork = n;

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;

			for (int j = i + 1; j < n; j++) {
				if (computers[i][j] == 1) {
					countOfNetwork--;
					visited[j] = true;
				}
			}
		}

		return countOfNetwork;
	}
}
