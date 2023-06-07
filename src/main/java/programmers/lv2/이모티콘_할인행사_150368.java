package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 이모티콘_할인행사_150368 {
	private final int[] discountRates = {10, 20, 30, 40};
	private final List<int[]> discountCombinations = new ArrayList<>();
	private final PriorityQueue<SellingResult> results = new PriorityQueue<>();

	private int n;

	public int[] solution(int[][] users, int[] emoticons) {
		n = emoticons.length;

		combineDiscountRates(new int[n], 0);

		for (int[] discountCombination : discountCombinations) {
			int totalSales = 0;
			int countOfSubscribers = 0;

			for (int[] user : users) {
				int discountDemand = user[0];
				int subscribeCondition = user[1];

				int eachSales = 0;

				for (int i = 0; i < n; i++) {
					if (discountCombination[i] >= discountDemand) {
						eachSales += calculateSales(discountCombination[i], emoticons[i]);
					}
				}

				if (eachSales >= subscribeCondition) {
					countOfSubscribers++;
				} else {
					totalSales += eachSales;
				}
			}

			results.add(new SellingResult(countOfSubscribers, totalSales));
		}

		SellingResult result = results.poll();
		return new int[] {result.countOfSubscribers, result.totalSales};
	}

	private double calculateSales(final int discountRate, final int price) {
		double salesRate = 1 - (double)discountRate / 100;
		return price * salesRate;
	}

	private void combineDiscountRates(final int[] combinations, final int count) {
		if (count == n) {
			discountCombinations.add(combinations);
		} else {
			for (int i = 0; i < 4; i++) {
				int[] clone = combinations.clone();
				clone[count] = discountRates[i];
				combineDiscountRates(clone, count + 1);
			}
		}
	}

	private class SellingResult implements Comparable<SellingResult> {
		int countOfSubscribers;
		int totalSales;

		public SellingResult(final int countOfSubscribers, final int totalSales) {
			this.countOfSubscribers = countOfSubscribers;
			this.totalSales = totalSales;
		}

		@Override
		public int compareTo(final SellingResult o) {
			if (this.countOfSubscribers == o.countOfSubscribers) {
				return o.totalSales - this.totalSales;
			}
			return o.countOfSubscribers - this.countOfSubscribers;
		}
	}
}
