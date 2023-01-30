package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합_11723 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MySet set = new MySet();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			if (command.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			} else if (command.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			} else if (command.equals("check")) {
				int result = set.check(Integer.parseInt(st.nextToken()));
				sb.append(result).append(System.lineSeparator());
			} else if (command.equals("toggle")) {
				set.toggle(Integer.parseInt(st.nextToken()));
			} else if (command.equals("all")) {
				set.all();
			} else if (command.equals("empty")) {
				set.empty();
			}
		}
		System.out.println(sb);
	}

	static class MySet {

		int[] set = new int[20];

		public void add(int value) {
			if (check(value) == 0) {
				set[value - 1] = value;
			}
		}

		public void remove(int value) {
			if (check(value) == 1) {
				set[value - 1] = 0;
			}
		}

		public int check(int value) {
			if (set[value - 1] == 0) {
				return 0;
			}
			return 1;
		}

		public void toggle(int value) {
			if (check(value) == 1) {
				remove(value);
			} else {
				add(value);
			}
		}

		public void all() {
			for (int i = 1; i <= 20; i++) {
				add(i);
			}
		}

		public void empty() {
			set = new int[20];
		}
	}

}
