package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AB_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		Queue<MyNumber> queue = new LinkedList<>();
		queue.add(new MyNumber(A, 0));
		while (!queue.isEmpty()) {
			MyNumber current = queue.poll();

			int newCount = current.count + 1;
			long newValueAdd = current.value * 10 + 1;
			long newValueMulti = current.value * 2;

			if (newValueAdd == B || newValueMulti == B) {
				System.out.println(newCount + 1);
				return;
			}
			if (newValueAdd < B) {
				queue.add(new MyNumber(newValueAdd, newCount));
			}
			if (newValueMulti < B) {
				queue.add(new MyNumber(newValueMulti, newCount));
			}
		}
		System.out.println(-1);
	}

	static class MyNumber {
		long value;
		int count;

		public MyNumber(long value, int count) {
			this.value = value;
			this.count = count;
		}
	}

}
