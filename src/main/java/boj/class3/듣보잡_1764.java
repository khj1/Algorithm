package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 듣보잡_1764 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> neverHeard = new HashSet<>();
		for (int i = 0; i < N; i++) {
			neverHeard.add(br.readLine());
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (neverHeard.contains(name)) {
				result.add(name);
			}
		}

		Collections.sort(result);

		sb.append(result.size()).append(System.lineSeparator());
		for (String name : result) {
			sb.append(name).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}
