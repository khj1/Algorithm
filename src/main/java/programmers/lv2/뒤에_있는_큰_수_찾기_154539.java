package programmers.lv2;

import java.util.Stack;

//TODO
public class 뒤에_있는_큰_수_찾기_154539 {

	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				answer[stack.pop()] = numbers[i];
			}
			stack.add(i);
		}

		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}

		return answer;
	}
}
