package section1;

import java.util.Scanner;

public class A02RecursiveThinking {

	public static void main(String[] args) {
		printInBinary(8);
	}
	// 재귀 함수를 이용해 문자열의 길이 구하기.
	public static int length(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1 + length(str.substring(1));
	}
	
	// 재귀 함수를 이용해 문자열의 각 문자를 모두 출력하기
	public static void printChars(String str) {
		if(str.length() == 0)
			return;
		else {
			System.out.println(str.charAt(0));
			printChars(str.substring(1));
		}
	}
	
	// 재귀함수를 이용해 문자열을 뒤집기.
	// StringBuilder 함수의 reverse() 메소드
	public static void printCharsReverse(String str) {
		if(str.length() == 0)
			return;
		else {
			printCharsReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
	
	// 재귀함수를 이용한 이진수 변환
	public static void printInBinary(int n) {
		if(n < 2)
			System.out.print(n);
		else {
			printInBinary(n/2);
			System.out.print(n%2);
		}
	}
	
	// 배열의 합 구하기
	public static int sum(int n, int[] data) {
		if(n <= 0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
	
	//데이터 파일로부터 n개의 정수 읽어오기 - 실용성은 거의 없다
	public void readFrom(int n, int[] data, Scanner in) {
		if(n==0)
			return;
		else {
			readFrom(n-1, data, in);
			data[n-1] = in.nextInt();
		}
	}

}
