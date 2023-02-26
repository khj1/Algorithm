package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 트리_순회_1991 {

	static Node head = new Node("A", null, null);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			insertNode(head, root, left, right);
		}

		preOrder(head);
		System.out.println();

		inOrder(head);
		System.out.println();

		postOrder(head);
		System.out.println();
	}

	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}

	static class Node {
		String value;
		Node left;
		Node right;

		public Node(String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	static void insertNode(Node temp, String root, String left, String right) {
		if (temp.value.equals(root)) {
			if (left.equals(".")) {
				temp.left = null;
			} else {
				temp.left = new Node(left, null, null);
			}

			if (right.equals(".")) {
				temp.right = null;
			} else {
				temp.right = new Node(right, null, null);
			}
		} else {
			if (temp.left != null) {
				insertNode(temp.left, root, left, right);
			}
			if (temp.right != null) {
				insertNode(temp.right, root, left, right);
			}
		}
	}
}
