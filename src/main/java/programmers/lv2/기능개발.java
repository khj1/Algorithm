package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> distributionCount = new ArrayList<>();
		Queue<Integer> progressQueue = getQueue(progresses);
		Queue<Integer> speedQueue = getQueue(speeds);

		while (!progressQueue.isEmpty()) {
			int count = countDistribution(progressQueue, speedQueue);
			if (count > 0) {
				distributionCount.add(count);
			}
			if (progressQueue.size() == 1) {
				distributionCount.add(1);
				break;
			}
			for (Integer speed : speedQueue) {
				if (!progressQueue.isEmpty()) {
					progressQueue.add(progressQueue.poll() + speed);
				}
			}
		}
		return distributionCount.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private Queue<Integer> getQueue(int[] progresses) {
		Queue<Integer> queue = new LinkedList<>();
		for (int progress : progresses) {
			queue.add(progress);
		}
		return queue;
	}

	private int countDistribution(Queue<Integer> progressQueue, Queue<Integer> speedQueue) {
		int count = 0;
		while (!progressQueue.isEmpty() && progressQueue.peek() >= 100) {
			progressQueue.poll();
			speedQueue.poll();
			count++;
		}
		return count;
	}
}
