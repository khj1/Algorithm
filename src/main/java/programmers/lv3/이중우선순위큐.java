package programmers.lv3;

import java.util.LinkedList;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
public class 이중우선순위큐 {
	private static final String INSERT_NUMBER = "I ";
	private static final String DELETE_MAX = "D 1";
	private static final String DELETE_MIN = "D -1";

	public int[] solution(String[] operations) {
		LinkedList<Integer> numbers = new LinkedList<>();
		for (String operation : operations) {
			if (operation.contains(INSERT_NUMBER)) {
				String replace = operation.replace(INSERT_NUMBER, "");
				numbers.add(Integer.parseInt(replace));
			}
			if (operation.equals(DELETE_MAX) && !numbers.isEmpty()) {
				numbers.removeLast();
			}
			if (operation.equals(DELETE_MIN) && !numbers.isEmpty()) {
				numbers.removeFirst();
			}
			numbers.sort(Integer::compareTo);
		}

		if (numbers.isEmpty()) {
			return new int[] {0, 0};
		}
		if (numbers.size() == 1) {
			return new int[] {numbers.peek(), numbers.peek()};
		}
		return new int[] {numbers.removeLast(), numbers.removeFirst()};
	}
}
