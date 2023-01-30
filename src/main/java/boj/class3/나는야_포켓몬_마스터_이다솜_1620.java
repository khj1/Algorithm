package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] pokemonsIndex = new String[N + 1];
		Map<String, Integer> pokemonsName = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			pokemonsIndex[i] = input;
			pokemonsName.put(input, i);
		}

		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if (isNumeric(question)) {
				sb.append(pokemonsIndex[Integer.parseInt(question)]).append(System.lineSeparator());
			} else {
				sb.append(pokemonsName.get(question)).append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}

	private static boolean isNumeric(String question) {
		try {
			Integer.parseInt(question);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
