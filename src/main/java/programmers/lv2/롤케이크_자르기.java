package programmers.lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class 롤케이크_자르기 {
	public int solution(int[] topping) {
		int answer = 0;
		Set<Integer> littleBrotherTopping = new HashSet<>();
		Map<Integer, Integer> bigBrotherTopping = new HashMap<>();
		for (int toppingType : topping) {
			bigBrotherTopping.put(toppingType, bigBrotherTopping.getOrDefault(toppingType, 0) + 1);
		}

		for (int toppingType : topping) {
			littleBrotherTopping.add(toppingType);
			bigBrotherTopping.put(toppingType, bigBrotherTopping.get(toppingType) - 1);
			if (bigBrotherTopping.get(toppingType) == 0) {
				bigBrotherTopping.remove(toppingType);
			}
			if (littleBrotherTopping.size() == bigBrotherTopping.size()) {
				answer++;
			}
		}
		return answer;
	}
}
