package programmers.lv2;

public class 멀쩡한_사각형_62048 {

	public long solution(int w, int h) {
		long gcd = findGCD(w, h);
		long dividedW = w / gcd;
		long dividedH = h / gcd;

		double inclination = (double)dividedH / dividedW;

		long countOfCleanRectangle = 0;
		for (int i = 1; i < dividedW ; i++) {
			long currentHeight = (long)(dividedH - inclination * i);
			countOfCleanRectangle += currentHeight;
		}

		long totalRectangle = dividedW * dividedH;
		long countOfBrokenRectangles = totalRectangle - 2 * countOfCleanRectangle;

		long totalBrokenRectangles = countOfBrokenRectangles * gcd;

		return (long)w * h - totalBrokenRectangles;
	}

	private int findGCD(final int w, final int h) {
		int lower = Math.min(w, h);
		for (int i = lower; i > 1 ; i--) {
			if (w % i == 0 && h % i == 0) {
				return i;
			}
		}
		return 1;
	}
}
