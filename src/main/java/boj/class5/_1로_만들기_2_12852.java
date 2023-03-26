package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//TODO
//DP로 풀어보기
public class _1로_만들기_2_12852 {

	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		List<Integer> result = bfs();

		StringBuilder sb = new StringBuilder();
		sb.append(min).append(System.lineSeparator());

		String method = result.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));

		sb.append(method);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static List<Integer> bfs() {
		List<Integer> methods = new ArrayList<>();
		methods.add(N);

		Queue<Number> queue = new LinkedList<>();
		queue.add(new Number(N, 0, methods));

		boolean[] visited = new boolean[N + 1];
		visited[N] = true;

		while (!queue.isEmpty()) {
			Number current = queue.poll();
			int currentValue = current.value;
			int currentCount = current.count;
			List<Integer> currentMethod = current.methods;

			if (currentValue == 1) {
				min = Math.min(min, currentCount);
				methods = currentMethod;
				break;
			}

			List<Integer> nexts = new ArrayList<>();
			if (currentValue % 3 == 0) {
				nexts.add(currentValue / 3);
			}
			if (currentValue % 2 == 0) {
				nexts.add(currentValue / 2);
			}
			if (currentValue - 1 > 0) {
				nexts.add(currentValue - 1);
			}

			for (int next : nexts) {
				if (visited[next] || next == 0) {
					continue;
				}
				visited[next] = true;
				List<Integer> nextMethods = new ArrayList<>(currentMethod);
				nextMethods.add(next);
				queue.add(new Number(next, currentCount + 1, nextMethods));
			}
		}
		return methods;
	}

	private static class Number {
		int value;
		int count;
		List<Integer> methods;

		public Number(final int value, final int count, final List<Integer> methods) {
			this.value = value;
			this.count = count;
			this.methods = methods;
		}
	}

}
