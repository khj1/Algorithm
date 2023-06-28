package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO
public class 등산코스_정하기_118669 {

	private List<List<Node>> nodes;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		nodes = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int[] path : paths) {
			int start = path[0];
			int end = path[1];
			int intensity = path[2];

			if (isGate(start, gates) || isSummit(end, summits)) {
				nodes.get(start).add(new Node(end, intensity));
			} else if (isGate(end, gates) || isSummit(start, summits)) {
				nodes.get(end).add(new Node(start, intensity));
			} else {
				nodes.get(start).add(new Node(end, intensity));
				nodes.get(end).add(new Node(start, intensity));
			}
		}

		return dijkstra(n, gates, summits);
	}

	private int[] dijkstra(final int n, final int[] gates, final int[] summits) {
		Queue<Node> queue = new LinkedList<>();
		int[] intensity = new int[n + 1];

		Arrays.fill(intensity, Integer.MAX_VALUE);

		for (int gate : gates) {
			queue.add(new Node(gate, 0));
			intensity[gate] = 0;
		}

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (intensity[current.destination] < current.intensity) {
				continue;
			}

			for (Node next : nodes.get(current.destination)) {
				int maxIntensity = Math.max(intensity[current.destination], next.intensity);
				if (intensity[next.destination] > maxIntensity) {
					intensity[next.destination] = maxIntensity;
					queue.add(new Node(next.destination, maxIntensity));
				}
			}
		}

		Arrays.sort(summits);

		int minSummit = Integer.MAX_VALUE;
		int minIntensity = Integer.MAX_VALUE;
		for (int summit : summits) {
			if (minIntensity > intensity[summit]) {
				minSummit = summit;
				minIntensity = intensity[summit];
			}
		}

		return new int[] {minSummit, minIntensity};
	}

	private boolean isGate(final int node, final int[] gates) {
		for (int gate : gates) {
			if (gate == node) {
				return true;
			}
		}
		return false;
	}

	private boolean isSummit(final int node, final int[] summits) {
		for (int summit : summits) {
			if (summit == node) {
				return true;
			}
		}
		return false;
	}

	private class Node {
		int destination;
		int intensity;

		public Node(final int destination, final int intensity) {
			this.destination = destination;
			this.intensity = intensity;
		}
	}
}
