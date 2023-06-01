package programmers.lv2;

public class 거리두기_확인하기_81302 {
	private int[] nR = {-1, 0, 1, 0};
	private int[] nC = {0, -1, 0, 1};

	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int k = 0; k < places.length; k++) {
			String[] place = places[k];
			char[][] map = new char[place.length][place[0].length()];

			for (int i = 0; i < place.length; i++) {
				for (int j = 0; j < place[0].length(); j++) {
					map[i][j] = place[i].charAt(j);
				}
			}
			answer[k] = checkDistance(map);
		}

		return answer;
	}

	private int checkDistance(final char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'O') {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int newR = i + nR[k];
						int newC = j + nC[k];

						if (newR < 0 || newC < 0) {
							continue;
						}
						if (newR >= map.length || newC >= map[0].length) {
							continue;
						}
						if (map[newR][newC] == 'P') {
							count++;
						}
					}

					if (count >= 2) {
						return 0;
					}
				}
				if (map[i][j] == 'P') {
					for (int k = 0; k < 4; k++) {
						int newR = i + nR[k];
						int newC = j + nC[k];

						if (newR < 0 || newC < 0) {
							continue;
						}
						if (newR >= map.length || newC >= map[0].length) {
							continue;
						}
						if (map[newR][newC] == 'P') {
							return 0;
						}
					}
				}
			}
		}
		return 1;
	}

}
