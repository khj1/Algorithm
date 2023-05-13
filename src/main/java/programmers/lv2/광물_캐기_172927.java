package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 광물_캐기_172927 {

	private static final int DIAMOND = 0;
	private static final int IRON = 1;
	private static final int STONE = 2;

	private Map<Integer, int[]> fatigues;
	private int min = Integer.MAX_VALUE;

	public int solution(int[] picks, String[] minerals) {
		fatigues = new HashMap<>();

		for (int i = 0; i < 3; i++) {
			if (i == DIAMOND) {
				fatigues.put(i, new int[] {1, 1, 1});
			}
			if (i == IRON) {
				fatigues.put(i, new int[] {5, 1, 1});
			}
			if (i == STONE) {
				fatigues.put(i, new int[] {25, 5, 1});
			}
		}

		for (int i = 0; i < 3; i++) {
			dfs(picks, minerals, 0, 0);
		}

		return min;
	}

	private void dfs(final int[] picks, final String[] minerals, final int index, final int fatigue) {
		if (isAllPicked(picks) || index == minerals.length) {
			min = Math.min(min, fatigue);
		} else {
			for (int i = 0; i < 3; i++) {
				if (picks[i] == 0) {
					continue;
				}
				int count = 0;
				int newIndex = index;
				int newFatigue = fatigue;
				while (newIndex < minerals.length && count < 5) {
					String mineral = minerals[newIndex];
					if (mineral.equals("diamond")) {
						newFatigue += fatigues.get(i)[DIAMOND];
					}
					if (mineral.equals("iron")) {
						newFatigue += fatigues.get(i)[IRON];
					}
					if (mineral.equals("stone")) {
						newFatigue += fatigues.get(i)[STONE];
					}
					count++;
					newIndex++;
				}
				picks[i]--;
				dfs(picks, minerals, newIndex, newFatigue);
				picks[i]++;
			}
		}
	}

	private boolean isAllPicked(final int[] picks) {
		for (int pick : picks) {
			if (pick > 0) {
				return false;
			}
		}
		return true;
	}
}
