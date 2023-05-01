package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

//TODO
public class 줄_서는_방법_12936 {

	public int[] solution(int n, long k) {
		List<Integer> people = new ArrayList<>();
		int[] answer = new int[n];

		long factorial = 1;
		int index = 0;

		for (int i = 1; i <= n; i++) {
			factorial *= i;
			people.add(i);
		}

		k--;

		while (n > 0) {
			factorial /= n;
			int val = (int)(k / factorial);
			answer[index] = people.get(val);
			people.remove(val);

			k %= factorial;
			index++;
			n--;
		}

		return answer;
	}

}
