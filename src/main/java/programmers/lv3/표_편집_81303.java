package programmers.lv3;

import java.util.Stack;

//TODO
public class 표_편집_81303 {

	public String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		int size = n;

		for (String query : cmd) {
			String[] split = query.split(" ");
			if (split[0].equals("U")) {
				k -= Integer.parseInt(split[1]);
			}
			if (split[0].equals("D")) {
				k += Integer.parseInt(split[1]);
			}
			if (split[0].equals("C")) {
				stack.add(k);
				size--;
				if (k == size) {
					k--;
				}
			}
			if (split[0].equals("Z")) {
				int removedValue = stack.pop();
				if (removedValue <= k) {
					k++;
				}
				size++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append('O');
		}
		while (!stack.isEmpty()) {
			sb.insert(stack.pop().intValue(), 'X');
		}
		return sb.toString();
	}
}
