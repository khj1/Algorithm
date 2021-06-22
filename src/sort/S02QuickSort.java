package sort;

public class S02QuickSort {
	static void quickSort(int[] data, int p, int r) {
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
	}
	
	static int partition(int[] data, int p, int r) {
		int x = data[r];
		int i = p-1;
		for(int j=p; j<= r-1; j++) {
			if(data[j] <= x) {
				i++;
				int tmp = data[i+1];
				data[i+1] = data[j];
				data[j] = tmp;
			}
			else {
				j++;
			}
		}
		data[r] = data[i+1];
		data[i+1] = x;
		
		return i+1;
	}
}
