package programmers.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 불량_사용자_64064 {

	private int N;
	private List<List<String>> similar_ids;
	private HashSet<Set<String>> answer;

	public int solution(String[] user_ids, String[] banned_ids) {
		N = banned_ids.length;
		answer = new HashSet<>();
		similar_ids = initSimilarIds();

		for (int i = 0; i < N; i++) {
			String bannedId = banned_ids[i];
			for (String userId : user_ids) {
				if (userId.length() != bannedId.length()) {
					continue;
				}
				if (isSimilar(bannedId, userId)) {
					similar_ids.get(i).add(userId);
				}
			}
		}

		dfs(new HashSet<>(), 0, 0);

		for (Set<String> strings : answer) {
			System.out.println("strings = " + strings);
		}

		return answer.size();
	}

	private List<List<String>> initSimilarIds() {
		List<List<String>> similar_ids = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			similar_ids.add(new ArrayList<>());
		}
		return similar_ids;
	}

	private boolean isSimilar(final String bannedId, final String userId) {
		for (int i = 0; i < bannedId.length(); i++) {
			if (bannedId.charAt(i) == '*') {
				continue;
			}
			if (bannedId.charAt(i) != userId.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private void dfs(final Set<String> combination, final int start, final int count) {
		if (count == N) {
			answer.add(combination);
		} else {
			for (String similarId : similar_ids.get(start)) {
				Set<String> clone = new HashSet<>(combination);
				if (clone.contains(similarId)) {
					continue;
				}
				clone.add(similarId);
				dfs(clone, start + 1, count + 1);
			}
		}
	}
}
