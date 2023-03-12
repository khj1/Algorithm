package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TODO
public class 웜홀_1865 {

	static final int INF = 1_000_000_000;
	static int N;
	static int M;
	static int W;
	static int[] minTime;
	static List<List<Road>> roads;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			minTime = new int[N + 1];
			roads = new ArrayList<>();
			for (int j = 0; j <= N; j++) {
				roads.add(new ArrayList<>());
			}

			for (int j = 0; j < M + W; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				if (j < M) {
					roads.get(start).add(new Road(end, time));
					roads.get(end).add(new Road(start, time));
				} else {
					roads.get(start).add(new Road(end, -time));
				}
			}

			sb.append(bellmanFord() ? "YES" : "NO").append(System.lineSeparator());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean bellmanFord() {
		Arrays.fill(minTime, INF);
		minTime[1] = 0;
		boolean update = false;

		for (int i = 0; i < N - 1; i++) {
			update = false;

			for (int j = 1; j <= N; j++) {
				for (Road road : roads.get(j)) {
					if (minTime[road.end] > minTime[j] + road.time) {
						minTime[road.end] = minTime[j] + road.time;
						update = true;
					}
				}
			}

			if (!update) {
				break;
			}
		}

		if (update) {
			for (int i = 1; i <= N; i++) {
				for (Road road : roads.get(i)) {
					if (minTime[road.end] > minTime[i] + road.time) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static class Road {
		int end;
		int time;

		public Road(final int end, final int time) {
			this.end = end;
			this.time = time;
		}
	}

}
