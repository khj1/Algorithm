package programmers.lv2;

public class 행렬_테두리_회전하기_77485 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] numbers = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				numbers[i][j] = (i - 1) * columns + j;
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];

			int startX = query[0];
			int startY = query[1];
			int endX = query[2];
			int endY = query[3];

			int currentX = startX;
			int currentY = startY;
			int prev = numbers[currentX][currentY];
			int min = numbers[currentX][currentY];

			while (true) {
				if (currentX == startX && currentY < endY) {
					currentY++;
				} else if (currentY == endY && currentX < endX) {
					currentX++;
				} else if (currentX == endX && currentY > startY) {
					currentY--;
				} else if (currentY == startY && currentX > startX) {
					currentX--;
				}

				int temp = numbers[currentX][currentY];
				numbers[currentX][currentY] = prev;
				prev = temp;

				min = Math.min(min, numbers[currentX][currentY]);

				if (currentX == startX && currentY == startY) {
					break;
				}
			}

			answer[i] = min;
		}

		return answer;
	}
}
