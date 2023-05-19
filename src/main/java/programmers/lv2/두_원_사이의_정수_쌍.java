package programmers.lv2;

public class 두_원_사이의_정수_쌍 {
	public long solution(int r1, int r2) {
		long answer = 0;

		for (int i = 1; i <= r2; i++) {
			long minJ = (int)Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));
			long maxJ = (int)Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));

			answer += (maxJ - minJ + 1);
		}
		return answer * 4;
	}
}
