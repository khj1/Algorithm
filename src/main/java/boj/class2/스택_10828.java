package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스택_10828 {

	public static void main(String[] args) throws IOException {
		MyStack myStack = new MyStack();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = java.lang.Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			if (split[0].equals("push")) {
				int number = Integer.parseInt(split[1]);
				myStack.push(number);
			} else if (split[0].equals("pop")) {
				sb.append(myStack.pop()).append(System.lineSeparator());
			} else if (split[0].equals("size")) {
				sb.append(myStack.size()).append(System.lineSeparator());
			} else if (split[0].equals("empty")) {
				sb.append(myStack.empty()).append(System.lineSeparator());
			} else if (split[0].equals("top")) {
				sb.append(myStack.top()).append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}

	private static class MyStack {

		int size = 0;
		Node first;

		public void push(Integer value) {
			Node newNode = new Node(value);
			newNode.prev = first;
			first = newNode;
			size++;
		}

		public int empty() {
			if (size == 0) {
				return 1;
			}
			return 0;
		}

		public Integer pop() {
			if (size == 0) {
				return -1;
			}
			Integer result = first.value;
			first = first.prev;
			size--;
			return result;
		}

		public int size() {
			return size;
		}

		public Integer top() {
			if (size == 0) {
				return -1;
			}
			return first.value;
		}
	}

	private static class Node {
		Integer value;
		Node prev;

		public Node(Integer value) {
			this.value = value;
		}
	}
}
