package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호_찾기_17219 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> siteAndPassword = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			siteAndPassword.put(st2.nextToken(), st2.nextToken());
		}
		for (int i = 0; i < M; i++) {
			sb.append(siteAndPassword.get(br.readLine())).append(System.lineSeparator());
		}
		System.out.println(sb);
	}
}
