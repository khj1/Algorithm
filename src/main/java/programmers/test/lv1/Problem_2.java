package programmers.test.lv1;

import java.util.HashMap;
import java.util.Map;

public class Problem_2 {
	public String[] solution(String[] players, String[] callings) {
		Map<Integer, String> rank = new HashMap<>();
		Map<String, Integer> player = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			player.put(players[i], i);
			rank.put(i, players[i]);
		}

		for (String calling : callings) {
			int currentRank = player.get(calling);
			int frontRank = currentRank - 1;

			String frontPlayer = rank.get(frontRank);

			rank.put(frontRank, calling);
			rank.put(currentRank, frontPlayer);
			player.put(frontPlayer, currentRank);
			player.put(calling, frontRank);
		}

		return rank.values().toArray(String[]::new);
	}
}
