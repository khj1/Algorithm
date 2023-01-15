package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String number = br.readLine();
			if (number.equals("0")) {
				break;
			}

			String front = "";
			String back = "";
			if (number.length() % 2 == 0) {
				front = number.substring(0, number.length() / 2);
				back = number.substring(number.length() / 2);
			} else {
				front = number.substring(0, number.length() / 2);
				back = number.substring(number.length() / 2 + 1);
			}
			back = new StringBuilder(back).reverse().toString();

			if (front.equals(back)) {
				sb.append("yes").append(System.lineSeparator());
			} else {
				sb.append("no").append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}
}
