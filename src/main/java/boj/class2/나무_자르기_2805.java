package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//TODO
public class 나무_자르기_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		List<Integer> tree = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		while (st2.hasMoreTokens()) {
			tree.add(Integer.parseInt(st2.nextToken()));
		}

		tree.sort(Collections.reverseOrder());

		int min = 0;
		int max = tree.get(0);

		while (min <= max) {
			int sawHeight = (max + min) / 2;
			System.out.println("sawHeight = " + sawHeight);
			long currentCut = getCurrentCut(tree, sawHeight);
			if (currentCut < M) {
				max = sawHeight - 1;
			} else {
				min = sawHeight + 1;
			}
		}
		System.out.println(max);
	}

	private static long getCurrentCut(List<Integer> tree, int sawHeight) {
		long currentCut = 0;
		for (Integer treeHeight : tree) {
			if (sawHeight < treeHeight) {
				currentCut += treeHeight - sawHeight;
			}
		}
		return currentCut;
	}
}
