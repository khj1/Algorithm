package programmers.lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class 수식_최대화 {

	private long max = Integer.MIN_VALUE;
	private boolean[] visited;

	public long solution(String expression) {
		List<String> operators = List.of("+", "-", "*");
		Queue<String> operatorsInProgress = new LinkedList<>();
		Queue<Long> numbers = new LinkedList<>();

		StringBuilder number = new StringBuilder();
		for (String s : expression.split("")) {
			if (operators.contains(s)) {
				operatorsInProgress.add(s);
				numbers.add(Long.parseLong(number.toString()));
				number = new StringBuilder();
			} else {
				number.append(s);
			}
		}
		numbers.add(Long.parseLong(number.toString()));

		System.out.println(numbers);
		System.out.println(operatorsInProgress);

		visited = new boolean[operators.size()];
		dfs(operators, operatorsInProgress, numbers);
		return max;
	}

	private void dfs(List<String> operators, Queue<String> operatorsInProgress, Queue<Long> numbers) {
		if (operatorsInProgress.isEmpty() && !numbers.isEmpty()) {
			max = Math.max(max, Math.abs(numbers.poll()));
		} else {
			for (int i = 0; i < operators.size(); i++) {
				String operator = operators.get(i);
				if (visited[i] || !operatorsInProgress.contains(operator)) {
					continue;
				}
				Queue<String> tempOperators = new LinkedList<>(operatorsInProgress);
				Queue<Long> tempNumbers = new LinkedList<>(numbers);

				while (tempOperators.contains(operator)) {
					Queue<String> newOperators = new LinkedList<>();
					Queue<Long> newNumbers = new LinkedList<>();

					Long prev = tempNumbers.poll();
					while (!tempOperators.isEmpty()) {
						Long next = tempNumbers.poll();
						String polledOperator = tempOperators.poll();
						if (polledOperator.equals(operator)) {
							prev = calculate(prev, next, operator);
						} else {
							newNumbers.add(prev);
							newOperators.add(polledOperator);
							prev = next;
						}
					}
					newNumbers.add(prev);
					tempOperators = newOperators;
					tempNumbers = newNumbers;
				}

				visited[i] = true;
				dfs(operators, tempOperators, tempNumbers);
				visited[i] = false;
			}
		}
	}

	private Long calculate(Long prev, Long next, String operator) {
		if (operator.equals("+")) {
			return prev + next;
		}
		if (operator.equals("-")) {
			return prev - next;
		}
		return prev * next;
	}
}
