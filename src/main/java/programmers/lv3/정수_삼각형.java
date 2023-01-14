package programmers.lv3;

import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class 정수_삼각형 {
	public int solution(int[][] triangle) {
		int[] sum = {triangle[0][0]};
		for (int i = 1; i < triangle.length; i++) {
			int[] temp = new int[triangle[i].length];
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					temp[j] = triangle[i][j] + sum[j];
				} else if (j == triangle[i].length - 1) {
					temp[j] = triangle[i][j] + sum[j - 1];
 				} else {
					temp[j] = Math.max(triangle[i][j] + sum[j - 1], triangle[i][j] + sum[j]);
				}
			}
			sum = temp;
		}
		return Arrays.stream(sum).max().getAsInt();
	}
}
