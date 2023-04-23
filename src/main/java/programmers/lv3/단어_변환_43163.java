package programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환_43163 {

	public int solution(String begin, String target, String[] words) {
		return bfs(begin, target, words);
	}

	private int bfs(final String begin, final String target, final String[] words) {
		boolean[] visited = new boolean[words.length];
		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(begin, 0));

		int count = 0;

		while (!queue.isEmpty()) {
			Word current = queue.poll();
			if (current.value.equals(target)) {
				count = current.count;
				break;
			}
			for (int i = 0; i < words.length; i++) {
				String next = words[i];
				if (visited[i]) {
					continue;
				}

				if (isDifferentOnlyOneWord(current.value, next)) {
					visited[i] = true;
					queue.add(new Word(next, current.count + 1));
				}
			}
		}
		return count;
	}

	private boolean isDifferentOnlyOneWord(final String s1, final String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1;
	}

	static class Word {
		String value;
		int count;

		public Word(final String value, final int count) {
			this.value = value;
			this.count = count;
		}
	}

}
