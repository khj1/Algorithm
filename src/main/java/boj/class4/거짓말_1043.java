package boj.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//TODO
public class 거짓말_1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int truthCount = Integer.parseInt(st2.nextToken());
		Set<Integer> knowingTruth = new HashSet<>();
		while (st2.hasMoreElements()) {
			knowingTruth.add(Integer.parseInt(st2.nextToken()));
		}

		Queue<List<Integer>> parties = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			List<Integer> party = new ArrayList<>();

			boolean isRelated = false;
			int peopleCount = Integer.parseInt(st3.nextToken());
			while (st3.hasMoreElements()) {
				int person = Integer.parseInt(st3.nextToken());
				party.add(person);
				if (knowingTruth.contains(person)) {
					isRelated = true;
				}
			}
			if (isRelated) {
				knowingTruth.addAll(party);
				continue;
			}
			parties.add(party);
		}

		boolean checkRelated = true;
		while (!parties.isEmpty() && checkRelated) {
			int count = 0;
			for (int i = 0; i < parties.size(); i++) {
				List<Integer> party = parties.poll();
				if (relatedWithKnowingTruth(party, knowingTruth)) {
					count++;
					continue;
				}
				parties.add(party);
			}
			if (count == 0) {
				checkRelated = false;
			}
		}
		System.out.println(parties.size());
	}

	private static boolean relatedWithKnowingTruth(List<Integer> party, Set<Integer> knowingTruth) {
		for (Integer person : party) {
			if (knowingTruth.contains(person)) {
				knowingTruth.addAll(party);
				return true;
			}
		}
		return false;
	}
}
