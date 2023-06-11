package programmers.test.lv3;

//12971#
public class Problem_1 {

	public int solution(int sticker[]) {
		int answer = 0;
		int length = sticker.length;

		if (length == 1) {
			return sticker[0];
		}

		int[] dp1 = new int[length];
		int[] dp2 = new int[length];

		dp1[0] = sticker[0];
		dp1[1] = sticker[0];

		dp2[0] = 0;
		dp2[1] = sticker[1];

		for (int i = 2; i < length; i++) {
			dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
			dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
		}

		return Math.max(dp1[length - 2], dp2[length - 1]);
	}
}
