package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 순위_검색_72412 {
	private final Map<String, List<Integer>> map = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			String[] infoSplit = info[i].split(" ");

			int score = Integer.parseInt(infoSplit[4]);

			String[] languages = {infoSplit[0], "-"};
			String[] jobs = {infoSplit[1], "-"};
			String[] careers = {infoSplit[2], "-"};
			String[] foods = {infoSplit[3], "-"};

			for (String language : languages) {
				for (String job : jobs) {
					for (String career : careers) {
						for (String food : foods) {
							String key = language + job + career + food;
							map.putIfAbsent(key, new ArrayList<>());
							map.get(key).add(score);
						}
					}
				}
			}
		}

		for (List<Integer> scores : map.values()) {
			scores.sort(null);
		}

		for (int i = 0; i < query.length; i++) {
			String replacedQuery = query[i].replaceAll(" and", "");
			String[] querySplit = replacedQuery.split(" ");

			int targetScore = Integer.parseInt(querySplit[4]);

			String key = querySplit[0] + querySplit[1] + querySplit[2] + querySplit[3];
			if (!map.containsKey(key)) {
				answer[i] = 0;
				continue;
			}

			List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
			int startIndex = findStartIndex(scores, targetScore);

			answer[i] += scores.size() - startIndex;
		}

		return answer;
	}

	private int findStartIndex(final List<Integer> scores, final int target) {
		int start = 0;
		int end = scores.size();

		while (start < end) {
			int mid = (start + end) / 2;
			if (scores.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

}
