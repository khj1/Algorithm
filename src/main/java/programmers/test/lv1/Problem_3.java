package programmers.test.lv1;

public class Problem_3 {
	boolean solution(String s) {
		boolean answer = true;

		int countOfP = 0;
		int countOfY = 0;

		String loweredS = s.toLowerCase();
		for (char c : loweredS.toCharArray()) {
			if (c == 'p') {
				countOfP++;
			}
			if (c == 'y') {
				countOfY++;
			}
		}

		if (countOfP == 0 && countOfY == 0) {
			return true;
		}
		return countOfP == countOfY;
	}
}
