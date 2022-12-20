package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class 연속_부분_수열_합의_개수 {
	public int solution(int[] elements) {
		HashSet<Integer> distinct = new HashSet<>();
		addElements(elements, distinct);
		return distinct.size();
	}

	private void addElements(int[] elements, HashSet<Integer> distinct) {
		addSingleElement(elements, distinct);
		addTotalElementSum(elements, distinct);
		addMultiElements(elements, distinct);
	}

	private void addSingleElement(int[] elements, HashSet<Integer> distinct) {
		for (int element : elements) {
			distinct.add(element);
		}
	}

	private void addMultiElements(int[] elements, HashSet<Integer> distinct) {
		for (int i = 1; i < elements.length - 1; i++) {
			int[] newElements = makeNewElement(elements, i);
			for (int j = 0; j < elements.length; j++) {
				int sum = calculateSum(newElements, i, j);
				distinct.add(sum);
			}
		}
	}

	private void addTotalElementSum(int[] elements, HashSet<Integer> distinct) {
		distinct.add(Arrays.stream(elements).sum());
	}

	private int calculateSum(int[] arr, int i, int j) {
		int sum = 0;
		for (int k = j; k <= j + i; k++) {
			sum += arr[k];
		}
		return sum;
	}

	private int[] makeNewElement(int[] elements, int count) {
		int[] outsideElements = Arrays.copyOfRange(elements, 0, count);
		return IntStream
				.concat(Arrays.stream(elements), Arrays.stream(outsideElements))
				.toArray();
	}
}
