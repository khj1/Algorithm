package boj.class5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TODO
public class _1의_개수_세기_9527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());

		long sum = count(end) - count(start - 1);


		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}

	private static long count(final long n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int digits = 0;
		long pow = 1;

		while (pow * 2 <= n) {
			pow *= 2;
			digits++;
		}
		return digits * pow / 2 + (n - pow + 1) + count(n - pow);
	}
}
