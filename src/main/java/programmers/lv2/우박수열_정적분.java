package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */
public class 우박수열_정적분 {
	public double[] solution(int k, int[][] ranges) {
		double[] answer = new double[ranges.length];
		List<Integer> sequence = calculateSequence(k);
		List<Double> widths = calculateWidths(sequence);

		for (int i = 0; i < ranges.length; i++) {
			int start = ranges[i][0];
			int end = sequence.size() + ranges[i][1] - 1;

			if (start == end) {
				answer[i] = 0;
			}
			if (start > end) {
				answer[i] = -1;
			}
			if (start < end) {
				answer[i] = sumWidths(start, end, widths);
			}
		}
		return answer;
	}

	private List<Integer> calculateSequence(int k) {
		List<Integer> sequence = new ArrayList<>();
		while (k > 1) {
			sequence.add(k);
			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
			if (k == 1) {
				sequence.add(k);
				break;
			}
		}
		return sequence;
	}

	private List<Double> calculateWidths(List<Integer> sequence) {
		List<Double> widths = new ArrayList<>();
		for (int i = 0; i < sequence.size() - 1; i++) {
			double width = (double)(sequence.get(i) + sequence.get(i + 1)) / 2;
			widths.add(width);
		}
		return widths;
	}

	private double sumWidths(int start, int end, List<Double> widths) {
		double sum = 0;
		for (int i = start; i < end; i++) {
			sum += widths.get(i);
		}
		return sum;
	}
}
