package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//TODO
public class 세_용액_2473 {

	static int N;
	static long[] solutions;
	static long min = Long.MAX_VALUE;
	static long[] minValues = new long[3];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		solutions = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solutions[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(solutions);

		for (int i = 0; i < N - 2; i++) {
			int start = i + 1;
			int end = N - 1;
			while (start < end) {
				long result = solutions[start] + solutions[end] + solutions[i];

				if (Math.abs(result) < min) {
					min = Math.abs(result);
					minValues[0] = solutions[i];
					minValues[1] = solutions[start];
					minValues[2] = solutions[end];
				}

				if (result > 0) {
					end--;
				} else if (result < 0) {
					start++;
				} else {
					break;
				}
			}
		}

		sb.append(minValues[0]).append(" ")
				.append(minValues[1]).append(" ")
				.append(minValues[2]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
