package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//TODO
public class 이중_우선순위_큐_7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					map.put(value, map.getOrDefault(value, 0) + 1);
				} else {
					if (!map.isEmpty()) {
						if (value == 1) {
							Integer lastKey = map.lastKey();
							if (map.get(lastKey) == 1) {
								map.remove(lastKey);
							} else {
								map.put(lastKey, map.get(lastKey) - 1);
							}
						} else {
							Integer firstKey = map.firstKey();
							if (map.get(firstKey) == 1) {
								map.remove(firstKey);
							} else {
								map.put(firstKey, map.get(firstKey) - 1);
							}
						}
					}
				}
			}
			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
}
