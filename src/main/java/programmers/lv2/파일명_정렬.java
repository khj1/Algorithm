package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class 파일명_정렬 {
	public String[] solution(String[] files) {
		List<File> fileList = new ArrayList<>();
		for (String fileName : files) {
			fileList.add(new File(fileName));
		}
		return fileList.stream()
				.sorted()
				.map(File::getOriginalName)
				.toArray(String[]::new);
	}

	static class File implements Comparable<File> {
		String head;
		String number;
		String originalName;

		public File(String originalName) {
			String[] parts = getParts(originalName);
			this.head = parts[0];
			this.number = parts[1];
			this.originalName = originalName;
		}

		private String[] getParts(String originalName) {
			String[] parts = new String[2];
			int currentIndex = 0;
			for (; currentIndex < originalName.length(); currentIndex++) {
				if (Character.isDigit(originalName.charAt(currentIndex))) {
					break;
				}
			}

			parts[0] = originalName.substring(0, currentIndex);
			int firstNumberIndex = currentIndex;

			int count = 1;
			for (; currentIndex < originalName.length(); currentIndex++) {
				if (!Character.isDigit(originalName.charAt(currentIndex)) || count > 5) {
					break;
				}
				count++;
			}
			parts[1] = originalName.substring(firstNumberIndex, currentIndex);
			return parts;
		}

		public String getOriginalName() {
			return originalName;
		}

		@Override
		public int compareTo(File other) {
			if (this.head.equalsIgnoreCase(other.head)) {
				return Integer.parseInt(this.number) - Integer.parseInt(other.number);
			}
			return this.head.compareToIgnoreCase(other.head);
		}
	}
}
