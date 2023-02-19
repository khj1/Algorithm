package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//TODO
public class 특정한_최단_경로_1504 {

	static int nodeCount;
	static int pathCount;
	static int[] minDistance;
	static List<List<Node>> network;
	static int mustPassNodeA;
	static int mustPassNodeB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		nodeCount = Integer.parseInt(st.nextToken());
		pathCount = Integer.parseInt(st.nextToken());
		minDistance = new int[nodeCount + 1];
		network = new ArrayList<>();

		for (int i = 0; i <= nodeCount; i++) {
			network.add(new ArrayList<>());
		}

		for (int i = 0; i < pathCount; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int departure = Integer.parseInt(st2.nextToken());
			int destination = Integer.parseInt(st2.nextToken());
			int distance = Integer.parseInt(st2.nextToken());

			network.get(departure).add(new Node(destination, distance));
			network.get(destination).add(new Node(departure, distance));
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		mustPassNodeA = Integer.parseInt(st2.nextToken());
		mustPassNodeB = Integer.parseInt(st2.nextToken());

		long distanceTempA = 0;
		distanceTempA += bfs(1, mustPassNodeA);
		distanceTempA += bfs(mustPassNodeA, mustPassNodeB);
		distanceTempA += bfs(mustPassNodeB, nodeCount);

		long distanceTempB = 0;
		distanceTempB += bfs(1, mustPassNodeB);
		distanceTempB += bfs(mustPassNodeB, mustPassNodeA);
		distanceTempB += bfs(mustPassNodeA, nodeCount);

		if (distanceTempA >= Integer.MAX_VALUE && distanceTempB >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(distanceTempA, distanceTempB));
		}
	}

	private static int bfs(int startPoint, int endPoint) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startPoint, 0));

		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[startPoint] = 0;

		while (!pq.isEmpty()) {
			int departure = pq.poll().destination;
			for (Node next : network.get(departure)) {
				int destination = next.destination;
				int distance = next.distance;
				if (minDistance[destination] <= minDistance[departure] + distance) {
					continue;
				}

				minDistance[destination] = minDistance[departure] + distance;
				pq.add(new Node(destination, minDistance[destination]));
			}
		}
		return minDistance[endPoint];
	}

	static class Node implements Comparable<Node> {
		int destination;
		int distance;

		public Node(int destination, int distance) {
			this.destination = destination;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}
