package programmers.lv3;

public class 징검다리_건너기_64062 {

	public int solution(int[] stones, int k) {
		int start = 0;
		int end = 200_000_001;
		while (start < end) {
			int mid = (start + end) / 2;
			if (canCross(stones, k, mid)) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

	private boolean canCross(final int[] stones, final int target, final int current) {
		int consecutiveCount = 0;
		for (int stone : stones) {
			if (stone - current <= 0) {
				consecutiveCount++;
				if (consecutiveCount == target) {
					return false;
				}
			} else {
				consecutiveCount = 0;
			}
		}
		return true;
	}
}
