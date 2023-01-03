package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class 메뉴_리뉴얼 {
	private final List<String> courses = new ArrayList<>();
	private Map<String, Integer> courseCount;
	private String[] menus;

	public String[] solution(String[] orders, int[] course) {

		for (int limit : course) {
			int maxCount = Integer.MIN_VALUE;
			courseCount = new HashMap<>();

			for (String order : orders) {
				menus = order.split("");
				Arrays.sort(menus);
				combination("", 0, 0, limit);
			}
			for (String key : courseCount.keySet()) {
				maxCount = Math.max(maxCount, courseCount.get(key));
			}
			for (String key : courseCount.keySet()) {
				if (courseCount.get(key) >= 2 && courseCount.get(key) == maxCount) {
					courses.add(key);
				}
			}
		}
		return courses.stream()
				.sorted()
				.toArray(String[]::new);
	}

	private void combination(String menu, int count, int index, int limit) {
		if (count == limit) {
			courseCount.put(menu, courseCount.getOrDefault(menu, 0) + 1);
			return;
		}
		for (int i = index; i < menus.length; i++) {
			String newMenu = menu.concat(menus[i]);
			combination(newMenu, count + 1, i + 1, limit);
		}
	}
}
