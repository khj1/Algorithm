package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class 모음_사전 {
	private final String[] alphabets = {"A", "E", "I", "O", "U"};
	private final List<String> dictionary = new ArrayList<>();

	public int solution(String word) {
		dfs("");
		return dictionary.indexOf(word) + 1;
	}

	private void dfs(String word) {
		if (word.length() < 5) {
			for (int i = 0; i < alphabets.length; i++) {
				String newWord = word.concat(alphabets[i]);
				dictionary.add(newWord);
				dfs(newWord);
			}
		}
	}
}
