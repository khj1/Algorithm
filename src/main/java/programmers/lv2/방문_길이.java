package programmers.lv2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
public class 방문_길이 {

	private final NodeRepository nodeRepository = new NodeRepository();

	public int solution(String dirs) {
		int x = 0;
		int y = 0;

		for (char dir : dirs.toCharArray()) {
			Node departure = new Node(x, y);
			if (dir == 'U' && y < 5) {
				y++;
			} else if (dir == 'D' && y > -5) {
				y--;
			} else if (dir == 'L' && x > -5) {
				x--;
			} else if (dir == 'R' && x < 5) {
				x++;
			}
			Node arrival = new Node(x, y);
			if (arrival.equals(departure)) {
				continue;
			}
			Nodes nodes = new Nodes(departure, arrival);
			nodeRepository.save(nodes);
			System.out.println(nodeRepository.size());
		}
		return nodeRepository.size();
	}

	static class Node {
		private final int x;
		private final int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	static class Nodes {
		private final Set<Node> nodes = new HashSet<>();

		public Nodes(Node nodeA, Node nodeB) {
			nodes.add(nodeA);
			nodes.add(nodeB);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Nodes nodes1 = (Nodes)o;
			return nodes.containsAll(nodes1.nodes);
		}

		@Override
		public int hashCode() {
			return Objects.hash(nodes);
		}
	}

	static class NodeRepository {
		private final Set<Nodes> store = new HashSet<>();

		public void save(Nodes nodes) {
			store.add(nodes);
		}

		public int size() {
			return store.size();
		}
	}
}
