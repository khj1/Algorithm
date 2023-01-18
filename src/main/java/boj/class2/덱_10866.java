package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덱_10866 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MyDeque deque = new MyDeque();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			if (command.equals("push_front")) {
				int value = Integer.parseInt(st.nextToken());
				deque.push_front(value);
			}
			if (command.equals("push_back")) {
				int value = Integer.parseInt(st.nextToken());
				deque.push_back(value);
			}
			if (command.equals("pop_front")) {
				sb.append(deque.pop_front()).append(System.lineSeparator());
			}
			if (command.equals("pop_back")) {
				sb.append(deque.pop_back()).append(System.lineSeparator());
			}
			if (command.equals("size")) {
				sb.append(deque.size()).append(System.lineSeparator());
			}
			if (command.equals("empty")) {
				sb.append(deque.empty()).append(System.lineSeparator());
			}
			if (command.equals("front")) {
				sb.append(deque.front()).append(System.lineSeparator());
			}
			if (command.equals("back")) {
				sb.append(deque.back()).append(System.lineSeparator());
			}
		}
		System.out.println(sb);
	}

	static class MyDeque {

		int size;
		Node head;
		Node tail;

		public void push_front(int value) {
			if (head == null) {
				head = new Node(value);
				tail = head;
			} else {
				Node newNode = new Node(value);
				if (head == tail) {
					newNode.next = tail;
					tail.prev = newNode;
				} else {
					newNode.next = head;
					head.prev = newNode;
				}
				head = newNode;
			}
			size++;
		}

		public void push_back(int value) {
			if (tail == null) {
				tail = new Node(value);
				head = tail;
			} else {
				Node newNode = new Node(value);
				if (head == tail) {
					newNode.prev = head;
					head.next = newNode;
				} else {
					newNode.prev = tail;
					tail.next = newNode;
				}
				tail = newNode;
			}
			size++;
		}

		public int pop_front() {
			if (head == null) {
				return -1;
			}
			int result = head.value;
			head = head.next;
			if (head == null) {
				tail = null;
			} else {
				head.prev = null;
			}
			size--;
			return result;
		}

		public int pop_back() {
			if (tail == null) {
				return -1;
			}
			int result = tail.value;
			tail = tail.prev;
			if (tail == null) {
				head = null;
			} else {
				tail.next = null;
			}
			size--;
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
			if (head == null) {
				return -1;
			}
			return head.value;
		}

		public int back() {
			if (tail == null) {
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
