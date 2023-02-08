package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO
public class DSLR_9019 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			sb.append(bfs(start, target)).append("\n");
		}
		System.out.println(sb);
	}

	private static String bfs(int start, int target) {

		Queue<Register> queue = new LinkedList<>();
		queue.add(new Register(start, ""));
		boolean[] visited = new boolean[10_000];
		visited[start] = true;

		while (!queue.isEmpty()) {
			Register register = queue.poll();

			System.out.println("register.value = " + register.value);
			System.out.println("register.command = " + register.command);
			System.out.println();

			if (register.value == target) {
				return register.command;
			}
			Register D = register.D();
			Register S = register.S();
			Register L = register.L();
			Register R = register.R();

			if (!visited[D.value]) {
				visited[D.value] = true;
				queue.add(D);
			}
			if (!visited[S.value]) {
				visited[S.value] = true;
				queue.add(S);
			}
			if (!visited[L.value]) {
				visited[L.value] = true;
				queue.add(L);
			}
			if (!visited[R.value]) {
				visited[R.value] = true;
				queue.add(R);
			}
		}
		return null;
	}

	static class Register {
		int value;
		String command;

		public Register(int value, String command) {
			this.value = value;
			this.command = command;
		}

		public Register D() {
			int newValue = value * 2;
			if (newValue > 9_999) {
				newValue %= 10_000;
			}
			return new Register(newValue, command + "D");
		}

		public Register S() {
			int newValue = value - 1;
			if (newValue < 0) {
				newValue = 9_999;
			}
			return new Register(newValue, command + "S");
		}

		public Register L() {
			return new Register(rotateValueLeft(), command + "L");
		}

		public Register R() {
			return new Register(rotateValueRight(), command + "R");
		}

		private int rotateValueLeft() {
			return (value % 1_000) * 10 + value / 1_000;
		}

		private int rotateValueRight() {
			return (value % 10) * 1000 + value / 10;
		}
	}
}
