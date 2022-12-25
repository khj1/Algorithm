package programmers.lv2;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰_수_만들기 {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int scope = number.length() - k;
		for (int i = 1; i <= scope; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < number.length() - (scope - i); j++) {
				char aChar = number.charAt(j);
				int current = Character.getNumericValue(aChar);
				if (current == 9) {
					max = current;
					index = j + 1;
					break;
				}
				if (max < current) {
					max = current;
					index = j + 1;
				}
			}
			sb.append(max);
			number = number.substring(index);
		}
		return sb.toString();
	}
}
