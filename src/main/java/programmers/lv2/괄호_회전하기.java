package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class 괄호_회전하기 {

	private final List<Character> open = new ArrayList<>();
	private final List<Character> close = new ArrayList<>();

	public int solution(String s) {
		init();
		int answer = 0;
		int count = 1;
		Queue<Character> characters = getQueue(s);
		Stack<Character> currentOpen = new Stack<>();

		while (count < s.length()) {
			int innerCount = 0;
			for (char c : characters) {
				if (open.contains(c)) {
					currentOpen.add(c);
				} else if (close.contains(c)) {
					if (currentOpen.isEmpty() || isNotMatch(c, currentOpen.pop())) {
						break;
					}
				}
				innerCount++;
			}
			if (innerCount == s.length() && currentOpen.isEmpty()) {
				answer++;
			}
			characters.add(characters.poll());
			count++;
		}

		return answer;
	}

	private void init() {
		open.add('(');
		open.add('{');
		open.add('[');

		close.add(')');
		close.add('}');
		close.add(']');
	}

	private Queue<Character> getQueue(String s) {
		Queue<Character> characters = new LinkedList<>();
		for (char c : s.toCharArray()) {
			characters.add(c);
		}
		return characters;
	}

	private boolean isNotMatch(char close, char open) {
		return Math.abs(close - open) > 2;
	}
}
