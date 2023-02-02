package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//TODO
public class AC_5430 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			String array = br.readLine();
			StringTokenizer st = new StringTokenizer(array.substring(1, array.length() - 1), ",");

			ArrayDeque<String> deque = new ArrayDeque<>();
			for (int j = 0; j < n; j++) {
				deque.add(st.nextToken());
			}

			boolean isRight = false;
			boolean isError = false;
			for (String command : p.split("")) {
				isError = false;
				if (command.equals("R")) {
					isRight = !isRight;
				}
				if (command.equals("D")) {
					if (deque.isEmpty()) {
						isError = true;
						break;
					}
					if (isRight) {
						deque.pollLast();
					} else {
						deque.poll();
					}
				}
			}

			if (isError) {
				sb.append("error");
			} else if (deque.isEmpty()) {
				sb.append("[]");
			} else if (isRight) {
				sb.append("[").append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());
				}
				sb.append("]");
			} else {
				sb.append("[").append(String.join(",", deque)).append("]");
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}
