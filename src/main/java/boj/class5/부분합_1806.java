package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class 부분합_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}

		int sum = 0;
		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;
		while (true) {
			if (sum >= S) {
				ans = Math.min(ans, right - left);
				sum -= numbers[left++];
			} else if (right == N) {
				break;
			} else {
				sum += numbers[right++];
			}
		}

		if (ans == Integer.MAX_VALUE) {
			ans = 0;
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
}
