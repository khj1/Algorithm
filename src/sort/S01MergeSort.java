package sort;

public class S01MergeSort {

	static int[] data = {5, 4, 66, 3, 59, 2, 2, 84};
	
	static void mergeSort( int[] data, int p, int r) {
		if(p < r) {
			int q = (p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
	}
	
	static void merge( int[] data, int p, int q, int r) {
		int i=p, j=q+1, k=p;
		int[] tmp = new int[data.length];
		while(i<=q && j<=r) {
			if(data[i] <= data[j])
				tmp[k++] = data[i++];
			else
				tmp[k++] = data[j++];
		}
		
		while(i<=q)
			tmp[k++] = data[i++];
		while(j<=r)
			tmp[k++] = data[j++];
		
		for(int x=p; x<=r; x++) {
			data[x] = tmp[x];
		}
		
		StringBuffer sb = new StringBuffer();
		for(int y : data)
			sb.append(y + " ");
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		mergeSort(data, 0, data.length-1);
	}

}
