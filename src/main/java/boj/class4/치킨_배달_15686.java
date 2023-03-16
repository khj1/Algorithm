package boj.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨_배달_15686 {

	static int N, M;
	static int[][] map;
	static List<Node> homes = new ArrayList<>();
	static List<Node> allChickens = new ArrayList<>();
	static List<Node> originalSurvivedChickens = new ArrayList<>();
	static int minDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					homes.add(new Node(i, j));
				}
				if (value == 2) {
					allChickens.add(new Node(i, j));
				}
			}
		}

		selectChickens(originalSurvivedChickens, 0);

		bw.write(String.valueOf(minDistance));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void selectChickens(final List<Node> survivedChickens, final int index) {
		if (survivedChickens.size() == M) {
			calculateTotalChickenDistance(survivedChickens);
		} else {
			for (int i = index; i < allChickens.size(); i++) {
				ArrayList<Node> temp = new ArrayList<>(survivedChickens);
				temp.add(allChickens.get(i));
				selectChickens(temp, i + 1);
			}
		}
	}

	private static void calculateTotalChickenDistance(final List<Node> survivedChickens) {
		int distance = 0;
		for (Node home : homes) {
			distance += calculateChickenDistance(home, survivedChickens);
		}
		minDistance = Math.min(minDistance, distance);
	}

	private static int calculateChickenDistance(final Node home, final List<Node> survivedChickens) {
		int distance = Integer.MAX_VALUE;
		for (Node survivedChicken : survivedChickens) {
			int result = Math.abs(home.r - survivedChicken.r) + Math.abs(home.c - survivedChicken.c);
			distance = Math.min(distance, result);
		}
		return distance;
	}

	private static class Node {
		int r;
		int c;

		public Node(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}
}
