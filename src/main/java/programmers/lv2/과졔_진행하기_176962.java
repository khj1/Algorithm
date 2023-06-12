package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class 과졔_진행하기_176962 {
	public String[] solution(String[][] plans) {
		List<String> answer = new ArrayList<>();
		PriorityQueue<Assignment> pq = new PriorityQueue<>();
		Stack<Assignment> remainAssignment = new Stack<>();

		for (String[] plan : plans) {
			String name = plan[0];
			int startTime = getStartTime(plan[1]);
			int remainMinutes = Integer.parseInt(plan[2]);

			pq.add(new Assignment(name, startTime, remainMinutes));
		}

		while (!pq.isEmpty()) {
			Assignment current = pq.poll();

			String currentName = current.name;
			int currentStart = current.startTime;
			int currentRemain = current.remainMinutes;
			int currentTime = currentStart;

			if (!pq.isEmpty()) {
				Assignment next = pq.peek();
				int nextStart = next.startTime;

				if (currentStart + currentRemain < nextStart) {
					answer.add(currentName);
					currentTime += currentRemain;

					while (!remainAssignment.isEmpty()) {
						Assignment remain = remainAssignment.pop();
						if (currentTime + remain.remainMinutes <= nextStart) {
							currentTime += remain.remainMinutes;
							answer.add(remain.name);
						} else {
							remain.decreaseRemainMinutes(nextStart - currentTime);
							remainAssignment.add(remain);
							break;
						}
					}
				} else if (currentStart + currentRemain == nextStart) {
					answer.add(currentName);
				} else {
					current.decreaseRemainMinutes(nextStart - currentStart);
					remainAssignment.add(current);
				}
			} else {
				if (remainAssignment.isEmpty()) {
					answer.add(currentName);
				} else {
					answer.add(currentName);
					while (!remainAssignment.isEmpty()) {
						answer.add(remainAssignment.pop().name);
					}
				}
			}
		}
		return answer.toArray(String[]::new);
	}

	private int getStartTime(final String timeString) {
		String[] split = timeString.split(":");

		int hour = Integer.parseInt(split[0]) * 60;
		int minute = Integer.parseInt(split[1]);
		return hour + minute;
	}

	private class Assignment implements Comparable<Assignment> {
		String name;
		int startTime;
		int remainMinutes;

		public Assignment(final String name, final int startTime, final int remainMinutes) {
			this.name = name;
			this.startTime = startTime;
			this.remainMinutes = remainMinutes;
		}

		@Override
		public int compareTo(final Assignment o) {
			return this.startTime - o.startTime;
		}

		public void decreaseRemainMinutes(final int minutes) {
			remainMinutes -= minutes;
		}
	}
}
