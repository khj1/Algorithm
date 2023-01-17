package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순_정렬_10814 {

	private int sequence = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Member> members = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			members.add(new Member(name, age));
		}

		members.sort(Member::compareTo);

		for (Member member : members) {
			sb.append(member).append(System.lineSeparator());
		}
		System.out.println(sb);
	}

	static class Member implements Comparable<Member>{

		private final String name;
		private final int age;

		public Member(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}
}
