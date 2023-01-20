package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 수_정렬하기_3_10989 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> numbers = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			numbers.put(number, numbers.getOrDefault(number, 0) + 1);
		}

		List<Integer> keys = numbers.keySet().stream()
				.sorted()
				.collect(Collectors.toList());

		for (Integer key : keys) {
			for (int i = 0; i < numbers.get(key); i++) {
				sb.append(key).append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}
}
