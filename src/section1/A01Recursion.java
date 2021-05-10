package section1;

public class A01Recursion {

	/*
	Recursion (순환) : 내부적으로 자기 자신을 호출하는 함수
		아래의 경우 무한루프에 빠지게 된다.
	 */
	public static void func() {
		System.out.println("Hello");
		func();
	}
	
	
	/*
	recursion이 항상 무한루프에 빠지는 것은 아니다.
	무한루프에 빠지지 않으려면?
		적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다. (Base case)
		recursion을 반복하다보면 결국 base case로 수렴해야한다. (Recursive case)
	 */
	public static void func1(int k) {
		if(k <= 0) // base case
			return;
		else {
			System.out.println("Hello");
			func1(k-1); // recursive case
			//Recursive case를 따라가다보면 결국 base case로 수렴해야한다.
		}
	}
	
	// 1부터 n까지의 합
	public static int func2(int n) {
		if(n <= 0)
			return 0;
		else {
			return n + func2(n-1);
		}
	}
	
	//Factorial
	public static int func3(int n) {
		if(n == 0)
			return 1;
		else {
			return n * func3(n-1);
		}
	}
	
	// 최대 공약수
	public static int gcd(int m, int n) {
		if(m < n) {
			int tmp =m; m=n; n=tmp;
		}
		if(m%n == 0)
			return n;
		else
			return gcd(n, m%n);
	}

}
