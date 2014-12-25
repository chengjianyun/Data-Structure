package personal.jianyun.algo;

import personal.janyun.ds.Heap;

public class Sort {
	public static void heapSort(Heap<Integer> heap) {
		int size = heap.getSize();
		while (size > 0) {

		}
	}

	public void quickSort(int[] values, int start, int end) {
		if (start < end) {
			int pivot = patrition(values, start, end);
			quickSort(values, start, pivot - 1);
			quickSort(values, pivot + 1, end);
		}
	}

	private int patrition(int[] values, int start, int end) {
		// TODO Auto-generated method stub
		int key = values[end];
		int j = end;
		for (int i = end - 1; i >= start; i--) {
			if (values[i] > key) {
				int temp = values[j - 1];
				values[j - 1] = values[i];
				values[i] = temp;
				j--;
			}
		}
		values[end] = values[j];
		values[j] = key;
		return j;
	}

	public void insertSort(int[] values, int len) {
		for (int i = 1; i < len; i++) {
			int key = values[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (key < values[j]) {
					values[j + 1] = values[j];
				} else {
					break;
				}
			}
			values[j + 1] = key;
		}
	}

	public void mergeSort(int[] values, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(values, start, mid);
			mergeSort(values, mid + 1, end);
			merge(values,start,mid,end);
		}
	}

	private void merge(int[] values, int start, int mid, int end) {
		int[] merges = new int[end-start+1];
		int i = start, j = mid+1, k = 0;
		while (i <= mid && j <= end) {
			if (values[i] < values[j]) {
				merges[k] = values[i];
				i++;
			} else {
				merges[k] = values[j];
				j++;
			}
			k++;
		}
		if (i <= mid) {
			for (int m = i; m <= mid; m++) {
				merges[k] = values[m];
				k++;
			}
		}

		if (j <= end) {
			for (int m = j; m <= end; m++) {
				merges[k] = values[m];
				k++;
			}
		}
		
		for(int m=0;m<merges.length;m++){
			values[m+start]=merges[m];
		}
	}
}
