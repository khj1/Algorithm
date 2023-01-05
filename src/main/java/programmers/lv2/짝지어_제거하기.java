package programmers.lv2;

import java.util.Stack;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class 짝지어_제거하기 {
	public int solution(String s) {
		Stack<String> stack = new Stack<>();
		for (String word : s.split("")) {
			if (!stack.isEmpty() && stack.peek().equals(word)) {
				stack.pop();
			} else {
				stack.add(word);
			}
		}
		if (stack.isEmpty()) {
			return 1;
		}
		return 0;
	}
}


