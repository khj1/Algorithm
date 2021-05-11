package section1;

public class A03DesigningRecursion {
	
	//순환 알고리즘 설계를 위해선 암시적 매개변수를 명시적 매개변수로 바꿔야한다!

	// 매개변수의 명시화: 순차 탐색
    /*
    매개변수의 명시화란?
    	기본적으로 배열을 순차적으로 탐색할 때 중요한 것은 시작 위치보다는
    	끝 위치다. 배열의 크기에 비해 실제로 객체가 담겨있는 갯수가 더 적을수도 있다.
    	배열의 시작 인덱스는 항상 '0'이므로 0을 생략한다. 
    	0과 같이 자명한 매개변수를 암시적 매개변수라고 한다. 따라서 매개변수의 명시화란
    	메소드의 매개변수에 배열의 시작위치를 지정해줌으로써 암시적인 매개변수를
    	명시화 해준 것이다.
     */
	public static int search(int[] data, int begin, int end, int target) {
		if(begin > end)
			return -1;
		else if(target == data[begin])
			return begin;
		else
			return search(data, begin+1, end, target);
	}
	
	// 순차 탐색 다른 버전
	public static int search2(int[] data, int begin, int end, int target) {
		if(begin > end)
			return -1;
		else if(target == data[end])
			return end;
		else
			return search2(data, begin, end-1, target);
	}
	
	// 순차 탐색 다른 버전
	public static int search3(int[] data, int begin, int end, int target) {
		if(begin > end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			if(target == data[middle])
				return middle;
			
			int index = search3(data, begin, middle-1, target);
			if(index != -1)
				return index;
			else
				return search3(data, begin, middle+1, target);
		}
	}
	
	// 매개변수의 명시화: 최댓값 찾기
	public static int findMax(int[] data, int begin, int end) {
		if(begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax(data, begin +1, end));
	}
	
	// 최댓값  찾기 다른버전
	public static int findMax2(int[] data, int begin, int end) {
		if(begin == end)
			return data[begin];
		else {
			int middle = (begin + end) / 2;
			int max1 = findMax2(data, begin, middle-1);
			int max2 = findMax2(data, middle+1, end);
			return Math.max(max1, max2);
			
		}
	}
	
	//이진검색 (Binary Search)
	public static int binarySearch(String[] items, String target, int begin, int end) {
		if(begin>end)
			return -1;
		else {
			int middle = (begin + end) / 2;
			int compResult = target.compareTo(items[middle]);
			if(compResult == 0)
				return middle;
			else if(compResult < 0)
				return binarySearch(items, target, begin, middle-1);
			else
				return binarySearch(items, target, middle+1, end);
		}
	}
}
