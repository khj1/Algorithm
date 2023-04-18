package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//TODO
public class 두_배열의_합_2143 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> listA = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}

		List<Integer> listB = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}

		listA.sort(null);
		listB.sort(null);

		int start = 0;
		int end = listB.size() - 1;
		long count = 0;

		while (start < listA.size() && end >= 0) {
			long sum = listA.get(start) + listB.get(end);
			if (sum == T) {
				long a = listA.get(start);
				long b = listB.get(end);
				long cntA = 0;
				long cntB = 0;

				while (start < listA.size() && listA.get(start) == a) {
					cntA++;
					start++;
				}
				while (end >= 0 && listB.get(end) == b) {
					cntB++;
					end--;
				}
				count += cntA * cntB;
			} else if (sum > T) {
				end--;
			} else {
				start++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
