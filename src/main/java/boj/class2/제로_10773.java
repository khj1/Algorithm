package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> book = new Stack<>();
		for (int i = 0; i < K; i++) {
			int money = Integer.parseInt(br.readLine());
			if (money == 0) {
				book.pop();
			} else {
				book.add(money);
			}
		}

		int sum = 0;
		while (!book.isEmpty()) {
			sum += book.pop();
		}

		System.out.println(sum);
	}
}
