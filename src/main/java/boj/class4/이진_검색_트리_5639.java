package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진_검색_트리_5639 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = null;
		while (true) {
			String read = br.readLine();
			if (read == null || read.equals("")) {
				break;
			}
			int value = Integer.parseInt(read);
			root = addNode(root, value);
		}
		postOrder(root);
	}

	private static Node addNode(Node root, int value) {
		if (root == null) {
			root = new Node(value, null, null);
		} else {
			if (value < root.value) {
				Node left = addNode(root.left, value);
				root = new Node(root.value, left, root.right);
			} else {
				Node right = addNode(root.right, value);
				root = new Node(root.value, root.left, right);
			}
		}
		return root;
	}

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value);
	}

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
