package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 요세푸스_문제_0_11866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> results = new ArrayList<>();

		int[] participants = new int[N];
		int count = 0;
		int index = 0;
		while (results.size() < N) {
			if (participants[index] == 0) {
				count++;
				if (count % K == 0) {
					participants[index] = 1;
					results.add(index + 1);
				}
			}
			index = (index + 1) % N;
		}

		String result = results.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", ", "<", ">"));

		System.out.println(result);
	}
}
