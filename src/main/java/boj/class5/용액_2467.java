package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 용액_2467 {

	static int min = Integer.MAX_VALUE;
	static int[] minNumbers = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] solutions = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;

		while (start < end) {
			int result = solutions[start] + solutions[end];
			if (Math.abs(result) < min) {
				min = Math.abs(result);
				minNumbers[0] = solutions[start];
				minNumbers[1] = solutions[end];
			}
			if (result > 0) {
				end--;
			}
			if (result < 0) {
				start++;
			}
			if (result == 0) {
				break;
			}
		}

		bw.write(minNumbers[0] + " " + minNumbers[1]);
		bw.flush();
		bw.close();
		br.close();
	}
}
