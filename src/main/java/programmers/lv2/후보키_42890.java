package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키_42890 {
	private int R;
	private int C;
	private String[][] relationCopy;
	private List<Set<Integer>> candidates = new ArrayList<>();

	public int solution(String[][] relation) {
		relationCopy = relation;
		R = relation.length;
		C = relation[0].length;

		for (int i = 1; i <= C; i++) {
			dfs(0, i, 0, new HashSet<>());
		}

		return candidates.size();
	}

	private void dfs(final int start, final int size, final int depth, final HashSet<Integer> set) {
		if (depth == size) {
			if (!isUnique(set)) {
				return;
			}
			if (!isMinimum(set)) {
				return;
			}
			candidates.add(set);
			return;
		}
		for (int i = start; i < C; i++) {
			HashSet<Integer> cloneSet = new HashSet<>(set);
			cloneSet.add(i);
			dfs(start + 1, size, depth + 1, cloneSet);
		}
	}

	private boolean isUnique(final HashSet<Integer> set) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder();
			for (Integer idx : set) {
				sb.append(relationCopy[i][idx]);
			}
			if (!list.contains(sb.toString())) {
				list.add(sb.toString());
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isMinimum(final HashSet<Integer> set) {
		for (Set<Integer> candidate : candidates) {
			if (set.containsAll(candidate)) {
				return false;
			}
		}
		return true;
	}
}
