package programmers.test.lv2;

public class Problem_2 {
	public int[] solution(String s) {
		int countOfConvert = 0;
		int countOfDeletedZero = 0;

		while (!s.equals("1")) {
			int lengthWithZero = s.length();
			String sWithoutZero = s.replaceAll("0", "");
			int lengthWithoutZero = sWithoutZero.length();

			countOfDeletedZero += lengthWithZero - lengthWithoutZero;

			countOfConvert++;
			s = Integer.toBinaryString(lengthWithoutZero);
		}
		return new int[] {countOfConvert, countOfDeletedZero};
	}
}
