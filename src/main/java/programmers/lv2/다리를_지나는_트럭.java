package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
TODO
https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를_지나는_트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int truckWeight : truck_weights) {
			queue.add(truckWeight);
		}

		int count = 0;
		int weightSum = 0;
		while (!queue.isEmpty()) {
			if (bridge.size() == bridge_length) {
				weightSum -= bridge.poll();
			}
			if (weightSum + queue.peek() <= weight) {
				int truckWeight = queue.poll();
				weightSum += truckWeight;
				bridge.add(truckWeight);
			} else {
				bridge.add(0);
			}
			count++;
		}
		return count + bridge_length;
	}
}
