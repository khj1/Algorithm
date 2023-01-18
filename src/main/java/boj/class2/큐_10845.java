package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐_10845 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MyQueue queue = new MyQueue();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("push")) {
				queue.push(Integer.parseInt(st.nextToken()));
			}
			if (command.equals("pop")) {
				sb.append(queue.pop()).append(System.lineSeparator());
			}
			if (command.equals("size")) {
				sb.append(queue.size()).append(System.lineSeparator());
			}
			if (command.equals("empty")) {
				sb.append(queue.empty()).append(System.lineSeparator());
			}
			if (command.equals("front")) {
				sb.append(queue.front()).append(System.lineSeparator());
			}
			if (command.equals("back")) {
				sb.append(queue.back()).append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}

	static class MyQueue {
		int size = 0;
		Node head;
		Node tail;

		public void push(int value) {
			Node newNode = new Node(value);
			if (tail == null) {
				tail = newNode;
				head = tail;
			} else if (size == 1) {
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
				head.next = tail;
			} else {
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}

		public int pop() {
			if (size == 0) {
				return -1;
			}
			size--;
			int result = head.value;
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return result;
		}

		public int size() {
			return size;
		}

		public int empty() {
			if (size == 0) {
				return 1;
			}
			return 0;
		}

		public int front() {
			if (size == 0) {
				return -1;
			}
			return head.value;
		}

		public int back() {
			if (size == 0) {
				return -1;
			}
			return tail.value;
		}
	}

	static class Node {
		int value;
		Node prev;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}
}
