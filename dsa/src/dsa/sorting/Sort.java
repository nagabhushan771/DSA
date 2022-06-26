package dsa.sorting;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] ar = new int[] {7, 2, 8, 7, 3, 7, 4};
		int n = ar.length;
		System.out.println(Arrays.toString(ar));
		quickSort(ar, 0, n-1);
		System.out.println(Arrays.toString(ar));
	}
	
	public static int[] BubbleSort(int[] ar, int n) {
		for(int i = n-1; i>=0; i--) {
			for(int j = 0; j<i; j++) {
				if(ar[j+1] < ar[j]) {
					int temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}
			}
		}
		return ar;
	}
	
	public static int[] InsertionSort(int[] arr, int n) {
		for(int i = 1; i<n; i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		
		return arr;
	}
	
	public static void SelectionSort(int[] arr, int n) {
		for(int i = 0; i<n; i++) {
			int minInd = i;
			for(int j = i+1; j<n; j++) {
				if(arr[minInd] > arr[j])
					minInd = j;
			}
			int temp = arr[minInd];
			arr[minInd] = arr[i];
			arr[i] = temp;
		}
		return;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}
//		if(left+1 == right) {
//			if(arr[right] < arr[left]) {
//				swap(arr, left, right);
//			}
//			return;
//		}
		int pivot = arr[left];
		int l = left+1;
		int r = right;
		while(l<=r) {
			while(l<=r && arr[l] <= pivot)
				l++;
			while(r>=l && arr[r] > pivot)
				r--;
			if(l < r)
				swap(arr, l, r);
		}
		swap(arr, left, r);
		quickSort(arr, left, r-1);
		quickSort(arr, r+1, right);
		return;
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l>=r)
			return;
		int mid = l+(r-l)/2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, r);
		merge(arr, l, mid, r);
	}
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int[] mergeArr = new int[r-l+1];
		int ind = 0;
		int firstInd = l;
		int secInd = mid+1;
		while(firstInd <= mid && secInd <= r) {
			if(arr[firstInd] <= arr[secInd]) {
				mergeArr[ind++] = arr[firstInd++];
			} else {
				mergeArr[ind++] = arr[secInd++];
			}
		}
		if(firstInd <= mid) {
			while(firstInd <= mid){
				mergeArr[ind++] = arr[firstInd++];
			}
		}
		if(secInd <= r) {
			while(secInd <= r) {
				mergeArr[ind++] = arr[secInd++];
			}
		}
		
		for(int i = 0; i<r-l+1 ;i++) {
			arr[l+i] = mergeArr[i];
		}
		
	}

	public static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
