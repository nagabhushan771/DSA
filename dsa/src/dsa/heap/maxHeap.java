package dsa.heap;

public class maxHeap {
	int[] arr;
	int maxSize;
	int ind;
	
	public maxHeap(int size) {
		arr = new int[size];
		maxSize = size;
		ind = -1;
	}
	
	public void add(int val) {
		if(ind == maxSize) {
			System.out.println("Heap is full...");
			return;
		}
		arr[++ind] = val;
		int child = ind;
		int parent = (child-1)/2;
		while(parent >= 0 && arr[child] > arr[parent]) {
			int temp = arr[child];
			arr[child] = arr[parent];
			arr[parent] = temp;
			child = parent;
			parent = (child-1)/2;
		}
		return;
	}
	
	public int poll() {
		if(ind == -1) {
			System.out.println("Heap is empty....");
			return -1;
		}
		int ans = arr[0];
		arr[0] = arr[ind];
		int parent = 0;
		while(parent < ind) {
			int bigInd = parent;
			int child1 = parent*2+1;
			int child2 = parent*2+2;
			if(child1 < ind && arr[bigInd] < arr[child1])
				bigInd = child1;
			if(child2 < ind && arr[bigInd] < arr[child2])
				bigInd = child2;
			
			if(bigInd == parent)
				break;
			else {
				int temp = arr[bigInd];
				arr[bigInd] = arr[parent];
				arr[parent] = temp;
				parent = bigInd;
			}
		}
		ind--;
		return ans;
	}
	
	public void printHeap() {
		for(int i = 0; i<ind+1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public int peek() {
		if(ind == -1) {
			System.out.println("Heap is Empty...");
			return -1;
		}
		return arr[0];
	}
	
	public static void heapSort(int[] a) {
		int n = a.length;
//		for(int i = 1; i<n; i++) {
//			int child = i;
//			int parent = (child-1)/2;
//			while(parent >= 0 && a[parent] < a[child]) {
//				int temp = a[parent];
//				a[parent] = a[child];
//				a[child] = temp;
//				child = parent;
//				parent = (child-1)/2;
//			}
//		}
		for(int i = n/2; i>=0; i--)
			heapifyDown(a, i, n);
		
		
		
//		for(int i = 0; i<n; i++) {
//			int temp = a[n-1-i];
//			a[n-1-i] = a[0];
//			a[0] = temp;
//			int parent = 0;
//			while(parent < n-i-1) {
//				int bigInd = parent;
//				int child1 = parent*2+1;
//				int child2 = parent*2+2;
//				if(child1 < n-i-1 && a[child1] > a[bigInd])
//					bigInd = child1;
//				if(child2 < n-i-1 && a[child2] > a[bigInd])
//					bigInd = child2;
//				if(parent == bigInd)
//					break;
//				else {
//					int t = a[bigInd];
//					a[bigInd] = a[parent];
//					a[parent] = t;
//					parent = bigInd;
//				}
//			}
//		}
		for(int i = 0; i<n; i++) {
			int temp = a[n-1-i];
			a[n-1-i] = a[0];
			a[0] = temp;
			heapifyDown(a, 0, n-i-1);
		}
		return;
	}
	
	public static void heapifyDown(int[] arr, int parent, int n) {
		int child1 = parent*2+1;
		int child2 = parent*2+2;
		int smallInd = parent;
//		int n = arr.length;
		if(child1 < n && arr[smallInd] < arr[child1])
			smallInd = child1;
		if(child2 < n && arr[smallInd] < arr[child2])
			smallInd = child2;
		if(parent == smallInd)
			return;
		else {
			int temp = arr[parent];
			arr[parent] = arr[smallInd];
			arr[smallInd] = temp;
			parent = smallInd;
			heapifyDown(arr, parent, n);
			return;
		}
	}
}
//Heap sort using heapify down function only
//public static void heapSort(int[] a) {
//	int n = a.length;
//	
//	for(int i = n/2; i>=0; i--)
//		heapifyDown(a, i, n);
//
//	for(int i = 0; i<n; i++) {
//		int temp = a[n-1-i];
//		a[n-1-i] = a[0];
//		a[0] = temp;
//		heapifyDown(a, 0, n-i-1);
//	}
//	
//	return;
//}
//
//public static void heapifyDown(int[] arr, int parent, int n) {
//	int child1 = parent*2+1;
//	int child2 = parent*2+2;
//	int smallInd = parent;
//	if(child1 < n && arr[smallInd] < arr[child1])
//		smallInd = child1;
//	if(child2 < n && arr[smallInd] < arr[child2])
//		smallInd = child2;
//	if(parent == smallInd)
//		return;
//	else {
//		int temp = arr[parent];
//		arr[parent] = arr[smallInd];
//		arr[smallInd] = temp;
//		parent = smallInd;
//		heapifyDown(arr, parent, n);
//		return;
//	}
//}
