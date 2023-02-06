package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕_신해빈_9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothes = new HashMap<>();
			initClothes(br, n, clothes);

			int count = 1;
			for (String type : clothes.keySet()) {
				count *= clothes.get(type) + 1;
			}
			System.out.println(count - 1);
		}
	}

	private static void initClothes(BufferedReader br, int n, Map<String, Integer> clothes) throws IOException {
		for (int j = 0; j < n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String type = st.nextToken();

			clothes.put(type, clothes.getOrDefault(type, 0) + 1);
		}
	}
}
