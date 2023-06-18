package programmers.lv3;

public class 자물쇠와_열쇠_60059 {

	private int n;
	private int m;
	private int offset;
	private int t;

	private boolean result = false;

	public boolean solution(int[][] key, int[][] lock) {
		n = key.length;
		m = lock.length;
		offset = n - 1;
		t = 2 * offset + m;

		int[][] map = new int[t][t];
		for (int i = offset; i < offset + m; i++) {
			for (int j = offset; j < offset + m; j++) {
				map[i][j] = lock[i - offset][j - offset];
			}
		}

		dfs(map, key, 0, 0);

		return result;
	}

	private void dfs(final int[][] map, final int[][] key, final int r, final int c) {
		if (result || r > t - n) {
			return;
		}

		int[][] cloneOfKey = getClone(key);

		for (int k = 0; k < 4; k++) {
			cloneOfKey = rotate(cloneOfKey);
			int[][] cloneOfMap = getClone(map);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cloneOfMap[i + r][j + c] += cloneOfKey[i][j];
				}
			}

			if (isMatched(cloneOfMap)) {
				result = true;
				return;
			}
		}
		int newR = r;
		int newC = c + 1;
		if (newC > t - n) {
			newR++;
			newC = 0;
		}
		dfs(map, key, newR, newC);
	}

	private int[][] rotate(final int[][] key) {
		int[][] rotated = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotated[i][j] = key[n - 1 - j][i];
			}
		}
		return rotated;
	}

	private boolean isMatched(final int[][] map) {
		for (int i = n - 1; i < n - 1 + m; i++) {
			for (int j = n - 1; j < n - 1 + m; j++) {
				if (map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private int[][] getClone(final int[][] arr) {
		int length = arr.length;
		int[][] cloneOfKey = new int[length][length];
		for (int i = 0; i < length; i++) {
			cloneOfKey[i] = arr[i].clone();
		}
		return cloneOfKey;
	}
}
