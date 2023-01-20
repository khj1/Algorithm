package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 통계학_2108 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> numbers = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(numbers);

		sb.append(calculateArithmeticMean(numbers)).append(System.lineSeparator());
		sb.append(calculateMedian(numbers)).append(System.lineSeparator());
		sb.append(calculateMostFrequent(numbers)).append(System.lineSeparator());
		sb.append(calculateRange(numbers)).append(System.lineSeparator());

		System.out.println(sb);
	}

	public static long calculateArithmeticMean(List<Integer> numbers) {
		int sum = numbers.stream()
				.mapToInt(v -> v)
				.sum();

		return Math.round((double)sum / numbers.size());
	}

	public static int calculateMedian(List<Integer> numbers) {
		int medianIndex = numbers.size() / 2;
		return numbers.get(medianIndex);
	}

	public static int calculateMostFrequent(List<Integer> numbers) {
		Map<Integer, Long> count = getCounts(numbers);
		long maxCount = getMaxCount(count);
		List<Integer> mostFrequents = getMostFrequents(count, maxCount);

		if (mostFrequents.size() > 1) {
			return mostFrequents.get(1);
		}
		return mostFrequents.get(0);
	}

	private static Map<Integer, Long> getCounts(List<Integer> numbers) {
		return numbers.stream()
				.collect(Collectors.groupingBy(arg -> arg, Collectors.counting()));
	}

	private static long getMaxCount(Map<Integer, Long> count) {
		return count.values().stream()
				.mapToLong(l -> l)
				.max()
				.getAsLong();
	}

	private static List<Integer> getMostFrequents(Map<Integer, Long> count, long maxCount) {
		return count.entrySet().stream()
				.filter(entry -> entry.getValue() == maxCount)
				.map(Map.Entry::getKey)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}

	public static int calculateRange(List<Integer> numbers) {
		return numbers.get(numbers.size() - 1) - numbers.get(0);
	}
}
