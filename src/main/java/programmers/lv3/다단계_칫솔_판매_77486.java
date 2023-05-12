package programmers.lv3;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매_77486 {

	private final int PRICE = 100;
	private final Map<String, String> REFERER = new HashMap<>();
	private final Map<String, Integer> PROFITS = new HashMap<>();

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		for (int i = 0; i < enroll.length; i++) {
			REFERER.put(enroll[i], referral[i]);
		}

		for (int i = 0; i < enroll.length; i++) {
			PROFITS.put(enroll[i], 0);
		}

		for (int i = 0; i < seller.length; i++) {
			int profit = amount[i] * PRICE;
			PROFITS.put(seller[i], PROFITS.get(seller[i]) + profit);

			if (profit / 10 > 0) {
				dfs(seller[i], profit);
			}
		}

		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = PROFITS.get(enroll[i]);
		}

		return answer;
	}

	private void dfs(final String seller, final int profit) {
		if (seller.equals("-") || profit / 10 == 0) {
			return;
		}
		int distribution = profit / 10;

		String referer = REFERER.get(seller);
		if (!referer.equals("-")) {
			PROFITS.put(referer, PROFITS.get(referer) + distribution);
		}
		PROFITS.put(seller, PROFITS.get(seller) - distribution);

		dfs(referer, distribution);
	}
}
