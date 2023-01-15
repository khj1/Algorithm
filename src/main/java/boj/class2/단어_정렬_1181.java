package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단어_정렬_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		List<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}

		words.sort((o1, o2) -> {
			int lengthA = o1.length();
			int lengthB = o2.length();
			if (lengthA == lengthB) {
				return o1.compareTo(o2);
			}
			return lengthA - lengthB;
		});

		String prev = "";
		for (String word : words) {
			if (!word.equals(prev)) {
				sb.append(word).append(System.lineSeparator());
				prev = word;
			}
		}

		System.out.println(sb);
	}
}
