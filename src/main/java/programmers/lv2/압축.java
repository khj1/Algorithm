package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
public class 압축 {
	public int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		List<String> dictionary = initDictionary();
		Stack<String> stack = toStack(msg);

		while (!stack.isEmpty()) {
			String word = stack.pop();
			int prevIndex = dictionary.indexOf(word);
			String pop = word;
			while (dictionary.contains(word) && !stack.isEmpty()) {
				prevIndex = dictionary.indexOf(word);
				pop = stack.pop();
				word = word.concat(pop);
			}
			if (dictionary.contains(word)) {
				answer.add(dictionary.indexOf(word) + 1);
			} else {
				answer.add(prevIndex + 1);
				dictionary.add(word);
				stack.add(pop);
			}
		}

		System.out.println(answer);

		return answer.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private List<String> initDictionary() {
		List<String> dictionary = new ArrayList<>();
		char word = 'A';
		while (word <= 'Z') {
			dictionary.add(String.valueOf(word));
			word++;
		}
		return dictionary;
	}

	private Stack<String> toStack(String msg) {
		Stack<String> stack = new Stack<>();
		String[] split = msg.split("");
		for (int i = split.length - 1; i >= 0; i--) {
			stack.add(split[i]);
		}
		return stack;
	}
}
