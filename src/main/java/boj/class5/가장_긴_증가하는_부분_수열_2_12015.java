package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//TODO
//이분 탐색 다시 학습
public class 가장_긴_증가하는_부분_수열_2_12015 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> result = new ArrayList<>();
		result.add(0);

		for (int i = 1; i <= N; i++) {
			if (numbers[i] > result.get(result.size() - 1)) {
				result.add(numbers[i]);
			} else {
				int index = find(result.size() - 1, numbers[i], result);
				result.set(index, numbers[i]);
			}
		}

		bw.write(String.valueOf(result.size() - 1));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int find(int end, final int target, final List<Integer> arr) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (arr.get(mid) >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

}
