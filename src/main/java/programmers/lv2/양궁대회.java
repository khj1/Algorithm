package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
public class 양궁대회 {
	private static int maxArrow;
	private static int[] apeach;
	private static int[] ryanMax;
	private static int maxDiff = 0;

	public int[] solution(int n, int[] info) {
		maxArrow = n;
		apeach = info.clone();
		int[] ryan = new int[11];
		int[] unwinnable = {-1};

		dfs(0, ryan, -1);

		if (maxDiff > 0) {
			return ryanMax;
		}
		return unwinnable;
	}

	private void dfs(int usedArrow, int[] ryan, int index) {
		if (usedArrow == maxArrow) {
			int ryanScore = 0;
			int apeachScore = 0;
			for (int i = 0; i < 11; i++) {
				if (ryan[i] > apeach[i]) {
					ryanScore += 10 - i;
				} else if (apeach[i] != 0) {
					apeachScore += 10 - i;
				}
			}
			int diff = ryanScore - apeachScore;
			if (maxDiff < diff) {
				maxDiff = diff;
				ryanMax = ryan.clone();
			}
			if (maxDiff > 0 && maxDiff == diff) {
				for (int i = 10; i >= 0; i--) {
					if (ryan[i] > ryanMax[i]) {
						ryanMax = ryan.clone();
					}
					if (ryanMax[i] > ryan[i]) {
						return;
					}
				}
			}
		}
		for (int i = index + 1; i < 11; i++) {
			int[] nextRyan = ryan.clone();
			if (i == 10) {
				nextRyan[i] += maxArrow - usedArrow;
				dfs(maxArrow, nextRyan, i);
			} else if (maxArrow - usedArrow >= apeach[i] + 1) {
				nextRyan[i] += apeach[i] + 1;
				dfs(usedArrow + apeach[i] + 1, nextRyan, i);
			}
		}
	}
}
