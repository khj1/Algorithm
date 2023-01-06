package programmers.lv2;

import java.util.LinkedList;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class 캐시 {

	public static final int HIT = 1;
	public static final int MISS = 5;

	public int solution(int cacheSize, String[] cities) {
		LinkedList<String> cache = new LinkedList<>();

		int count = 0;
		for (String city : cities) {
			city = city.toUpperCase();
			if (cache.contains(city) && cacheSize > 0) {
				cache.remove(city);
				cache.addLast(city);
				count += HIT;
				continue;
			}
			if (cache.size() == cacheSize) {
				cache.poll();
			}
			cache.add(city);
			count += MISS;
		}
		return count;
	}
}
