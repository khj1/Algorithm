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
import java.util.StringTokenizer;

//TODO
//위상 정렬 기본
public class 줄_세우기_2252 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] students = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());

			graph.get(front).add(back);
			students[back]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (students[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int student = queue.poll();
			sb.append(student).append(" ");

			for (int backStudent : graph.get(student)) {
				students[backStudent]--;
				if (students[backStudent] == 0) {
					queue.add(backStudent);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
