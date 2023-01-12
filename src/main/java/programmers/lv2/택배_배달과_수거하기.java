package programmers.lv2;

/*
TODO 시간초과
https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
public class 택배_배달과_수거하기 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int deliveryStartIndex = n - 1;
		int pickupStartIndex = n - 1;
		while (true) {
			int deliverBox = cap;
			int pickupBox = cap;

			for (; deliveryStartIndex >= 0; deliveryStartIndex--) {
				if (deliveries[deliveryStartIndex] != 0) {
					break;
				}
			}
			for (; pickupStartIndex >= 0; pickupStartIndex--) {
				if (pickups[pickupStartIndex] != 0) {
					break;
				}
			}

			if (deliveryStartIndex == -1) {
				deliverBox = 0;
			}
			if (pickupStartIndex == -1) {
				pickupBox = 0;
			}

			int startIndex = Math.max(deliveryStartIndex, pickupStartIndex);
			if (startIndex == -1) {
				break;
			}

			answer += 2L * (startIndex + 1);

			for (int i = deliveryStartIndex; i >= 0 && deliverBox > 0; i--) {
				if (deliveries[i] > deliverBox) {
					deliveries[i] -= deliverBox;
					deliverBox = 0;
				} else {
					deliverBox -= deliveries[i];
					deliveries[i] = 0;
				}
			}

			for (int i = pickupStartIndex; i >= 0 && pickupBox > 0; i--) {
				if (pickups[i] > pickupBox) {
					pickups[i] -= pickupBox;
					pickupBox = 0;
				} else {
					pickupBox -= pickups[i];
					pickups[i] = 0;
				}
			}
		}
		return answer;
	}
}
