package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class ACM_Craft_1005 {

	static int N, K;
	static int[] time;
	static int[] minTime;
	static int[] indegree;
	static ArrayList<Integer>[] orders;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N + 1];
			orders = new ArrayList[N + 1];

			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
				orders[j] = new ArrayList<>();
			}

			indegree = new int[N + 1];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				orders[start].add(end);
				indegree[end]++;
			}

			int target = Integer.parseInt(br.readLine());

			minTime = new int[N + 1];
			calculateMinTime();
			sb.append(minTime[target]).append(System.lineSeparator());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void calculateMinTime() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				minTime[i] = time[i];
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : orders[current]) {
				minTime[next] = Math.max(minTime[next], minTime[current] + time[next]);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
