package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//TODO
//왜 DFS는 시간초과가 발생할까?
public class 별자리_만들기_4386 {

	static int n;
	static Star[] stars;
	static int[] parents;
	static List<Path> paths;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		stars = new Star[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			stars[i] = new Star(x, y);
		}

		paths = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double distance = calculateDistance(stars[i], stars[j]);
				paths.add(new Path(i, j, distance));
			}
		}

		Collections.sort(paths);

		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		double sum = 0;
		for (Path path : paths) {
			if (!hasSameParent(path.start, path.end)) {
				sum += path.weight;
				union(path.start, path.end);
			}
		}

		bw.write(String.format("%.2f", sum));
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean hasSameParent(final int a, final int b) {
		return find(a) == find(b);
	}

	private static int find(final int n) {
		if (parents[n] == n) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parents[b] = a;
		}
	}

	private static double calculateDistance(Star s1, Star s2) {
		return Math.sqrt(Math.pow(s2.x - s1.x, 2) + Math.pow(s2.y - s1.y, 2));
	}

	private static class Star {
		double x;
		double y;

		public Star(final double x, final double y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Path implements Comparable<Path> {
		int start;
		int end;
		double weight;

		public Path(final int start, final int end, final double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(final Path o) {
			return (int)(this.weight - o.weight);
		}
	}

}
