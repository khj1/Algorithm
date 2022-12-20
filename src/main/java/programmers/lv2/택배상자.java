package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
public class 택배상자 {
	public int solution(int[] order) {
		int answer = 0;
		Queue<Integer> main = initMain(order);
		Stack<Integer> assistance = new Stack<>();

		for (int orderedBox : order) {
			if (!assistance.isEmpty()) {
				Integer assistanceBox = assistance.pop();
				if (assistanceBox == orderedBox) {
					answer++;
					continue;
				}
				assistance.add(assistanceBox);
			}
			if (hasOrderedBox(main, assistance, orderedBox)) {
				answer++;
				continue;
			}
			break;
		}
		return answer;
	}

	private Queue<Integer> initMain(int[] order) {
		Queue<Integer> main = new LinkedList<>();
		for (int i = 1; i <= order.length; i++) {
			main.add(i);
		}
		return main;
	}

	private boolean hasOrderedBox(Queue<Integer> main, Stack<Integer> assistance, int orderedBox) {
		while (!main.isEmpty()) {
			Integer mainBox = main.poll();
			if (mainBox == orderedBox) {
				return true;
			}
			assistance.add(mainBox);
		}
		return false;
	}
}
