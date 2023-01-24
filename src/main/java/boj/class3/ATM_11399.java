package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ATM_11399 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Queue<Integer> queue = new PriorityQueue<>();

		while (st.hasMoreTokens()) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		int prev = 0;
		int total = 0;
		while (!queue.isEmpty()) {
			prev += queue.poll();
			total += prev;
		}

		System.out.println(total);
	}
}
