package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO
public class 트리의_순회_2263 {

	static int n;
	static int[] inOrder;
	static int[] postOrder;
	static int[] inOrderIndex;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		inOrderIndex = new int[n + 1];
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			inOrderIndex[inOrder[i]] = i;
		}

		preOrder(0, n - 1, 0, n - 1);
		System.out.println(sb);
	}

	private static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return;
		}

		int root = postOrder[postEnd];
		sb.append(root).append(" ");

		int rootIndex = inOrderIndex[root];
		int left = rootIndex - inStart;

		preOrder(inStart, rootIndex - 1, postStart, postStart + left - 1);
		preOrder(rootIndex + 1, inEnd, postStart + left, postEnd - 1);
	}
}
