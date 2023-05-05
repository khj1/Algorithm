package programmers.lv3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 베스트_앨범_42579 {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> playsByGenre = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			playsByGenre.put(genres[i], playsByGenre.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<String> sortedKeys = playsByGenre.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		List<Integer> bestAlbum = new ArrayList<>();

		for (String genre : sortedKeys) {
			PriorityQueue<Song> pq = new PriorityQueue<>();
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(genre)) {
					pq.add(new Song(i, plays[i]));
				}
			}

			int count = 2;
			while (!pq.isEmpty() && count > 0) {
				bestAlbum.add(pq.poll().number);
				count--;
			}
		}

		return bestAlbum.stream()
				.mapToInt(i -> i)
				.toArray();
	}

	private static class Song implements Comparable<Song> {
		int number;
		int plays;

		public Song(final int number, final int plays) {
			this.number = number;
			this.plays = plays;
		}

		@Override
		public int compareTo(final Song o) {
			if (this.plays == o.plays) {
				return this.number - o.number;
			}
			return o.plays - this.plays;
		}
	}
}
