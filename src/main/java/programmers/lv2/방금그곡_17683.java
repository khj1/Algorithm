package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 방금그곡_17683 {
	public String solution(String m, String[] musicinfos) {
		PriorityQueue<Music> pq = new PriorityQueue<>();

		List<String> melody = getMelody(m);
		int melodyTime = melody.size();

		for (String musicinfo : musicinfos) {
			String[] musicinfoSplit = musicinfo.split(",");

			int radioPlayTime = calculateRadioPlayTime(musicinfoSplit[0], musicinfoSplit[1]);
			String name = musicinfoSplit[2];
			List<String> radioMelody = getMelody(musicinfoSplit[3]);

			String[] fullRadioMelody = new String[radioPlayTime];
			int melodyIdx = 0;
			for (int i = 0; i < radioPlayTime; i++) {
				fullRadioMelody[i] = radioMelody.get(melodyIdx++);
				if (melodyIdx == radioMelody.size()) {
					melodyIdx = 0;
				}
			}

			if (isSameMusic(melody, melodyTime, fullRadioMelody)) {
				pq.add(new Music(name, radioPlayTime));
			}
		}

		return pq.isEmpty() ? "(None)" : pq.poll().name;
	}

	private boolean isSameMusic(final List<String> melody, final int melodyTime, final String[] fullRadioMelody) {
		String radioMelodyString = String.join("", fullRadioMelody);
		String melodyString = String.join("", melody);

		return radioMelodyString.contains(melodyString);
	}

	private List<String> getMelody(final String m) {
		List<String> melody = new ArrayList<>();
		String[] melodySplit = m.split("");
		for (int i = 0; i < m.length(); i++) {
			if (melodySplit[i].equals("#")) {
				melody.add(melody.remove(melody.size() - 1).toLowerCase());
			} else {
				melody.add(melodySplit[i]);
			}
		}
		return melody;
	}

	private int calculateRadioPlayTime(final String startTime, final String endTime) {
		String[] endTimeSplit = endTime.split(":");
		int totalEndMinutes = Integer.parseInt(endTimeSplit[0]) * 60 + Integer.parseInt(endTimeSplit[1]);

		String[] startTimeSplit = startTime.split(":");
		int totalStartMinutes = Integer.parseInt(startTimeSplit[0]) * 60 + Integer.parseInt(startTimeSplit[1]);

		return totalEndMinutes - totalStartMinutes;
	}

	private class Music implements Comparable<Music> {
		String name;
		int playTime;

		public Music(final String name, final int playTime) {
			this.name = name;
			this.playTime = playTime;
		}

		@Override
		public int compareTo(final Music o) {
			return o.playTime - this.playTime;
		}
	}
}
