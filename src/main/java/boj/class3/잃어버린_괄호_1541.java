package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO
public class 잃어버린_괄호_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String formula = br.readLine();
		String[] splitBySubtraction = formula.split("-");

		int result = Integer.MAX_VALUE;
		for (String formulaWithAddition : splitBySubtraction) {
			int sum = 0;
			String[] splitByAddition = formulaWithAddition.split("\\+");
			for (String number : splitByAddition) {
				sum += Integer.parseInt(number);
			}
			if (result == Integer.MAX_VALUE) {
				result = sum;
			} else {
				result -= sum;
			}
		}
		System.out.println(result);
	}
}
