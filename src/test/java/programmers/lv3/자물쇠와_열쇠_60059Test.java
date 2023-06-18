package programmers.lv3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class 자물쇠와_열쇠_60059Test {

	@Test
	void solution() {
		// given
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

		자물쇠와_열쇠_60059 자물쇠와_열쇠_60059 = new 자물쇠와_열쇠_60059();

		// when
		boolean result = 자물쇠와_열쇠_60059.solution(key, lock);

		// then
		assertTrue(result);
	}
}
