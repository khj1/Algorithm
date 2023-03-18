package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질_2_12851 {

	static int N, K;
	static int minTime = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		find();

		sb.append(minTime).append(System.lineSeparator());
		sb.append(count);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void find() {
		int[] visited = new int[1_000_001];
		LinkedList<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
		visited[N] = 1;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			int currentPos = current.position;
			int currentTime = current.time;

			if (currentPos == K) {
				if (count == 0) {
					minTime = currentTime;
				}
				if (minTime == currentTime) {
					count++;
				}
			} else {
				int[] arr = {currentPos * 2, currentPos - 1, currentPos + 1};
				for (int i = 0; i < 3; i++) {
					int nextPos = arr[i];
					if (nextPos < 0 || nextPos > 1_000_000) {
						continue;
					}
					if (visited[nextPos] == 0 || visited[nextPos] == currentTime + 1) {
						visited[nextPos] = currentTime + 1;
						queue.add(new Point(nextPos, currentTime + 1));
					}
				}
			}
		}

	}

	static class Point {
		int position;
		int time;

		public Point(final int position, final int time) {
			this.position = position;
			this.time = time;
		}
	}
}
