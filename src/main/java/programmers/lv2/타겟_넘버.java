package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟_넘버 {

	private final Set<int[]> operators = new HashSet<>();
	private int[] numbers;
	private int target;

	public int solution(int[] numbers, int target) {
		this.numbers = numbers;
		this.target = target;
		dfs(numbers, 0, -1);

		return operators.size();
	}

	private void dfs(int[] numbers, int count, int position) {
		if (count < numbers.length) {
			int sum = sum(numbers);
			if (sum == target) {
				operators.add(numbers);
			} else if (sum > target) {
				for (int i = position + 1; i < this.numbers.length; i++) {
					int[] temp = numbers.clone();
					temp[i] = -numbers[i];
					dfs(temp, count + 1, i);
				}
			}
		}
	}

	private int sum(int[] temp) {
		int sum = 0;
		for (int t : temp) {
			sum += t;
		}
		return sum;
	}
}
