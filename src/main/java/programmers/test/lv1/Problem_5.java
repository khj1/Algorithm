package programmers.test.lv1;

import java.util.HashSet;
import java.util.Set;

public class Problem_5 {
	public int solution(int[] nums) {
		int n = nums.length / 2;

		Set<Integer> uniques = new HashSet<>();
		for (int num : nums) {
			uniques.add(num);
		}
		return Math.min(uniques.size(), n);
	}
}
