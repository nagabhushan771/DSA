package dsa.heap;

//import java.util.ArrayList;
//import java.util.Collections;
//
//public class minHeap {
//	ArrayList<Integer> heap;
//	public minHeap() {
//		heap = new ArrayList<>();
//	}
//	public void push(int val) {
//		heap.add(val);
////		System.out.println(heap.size());
//		heapifyAdd(heap.size()-1);
////		System.out.println(heap.size());
//	}
//	void heapifyAdd(int child) {
////		int child = heap.size()-1;
//		int parent = (child-1)/2;
//		if(child == 0 || (heap.get(child) <= heap.get(parent)))
//			return;
////		int temp = heap.get(parent);
////		heap.add(parent, heap.get(child));
////		heap.add(child, temp);
//		Collections.swap(heap, parent, child);
//		heapifyAdd(parent);
//		return;
//	}
//	
//	public int top() {
//		return heap.get(0);
//	}
//	
//	public void printHeap() {
//		System.out.println(heap);
////		System.out.println(heap.size());
//	}
//}

public class minHeap {
	int[] arr;
	int maxSize;
	int ind;
	
	public minHeap(int size) {
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
		while(parent >= 0 && arr[child] < arr[parent]) {
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
			int smallInd = parent;
			int child1 = parent*2+1;
			int child2 = parent*2+2;
			if(child1 < ind && arr[smallInd] > arr[child1])
				smallInd = child1;
			if(child2 < ind && arr[smallInd] > arr[child2])
				smallInd = child2;
			
			if(smallInd == parent)
				break;
			else {
				int temp = arr[smallInd];
				arr[smallInd] = arr[parent];
				arr[parent] = temp;
				parent = smallInd;
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
		for(int i = 1; i<n; i++) {
			int child = i;
			int parent = (child-1)/2;
			while(parent >= 0 && a[parent] > a[child]) {
				int temp = a[parent];
				a[parent] = a[child];
				a[child] = temp;
				child = parent;
				parent = (child-1)/2;
			}
		}
		
		for(int i = 0; i<n; i++) {
			int temp = a[n-1-i];
			a[n-1-i] = a[0];
			a[0] = temp;
			int parent = 0;
			while(parent < n-i-1) {
				int smallInd = parent;
				int child1 = parent*2+1;
				int child2 = parent*2+2;
				if(child1 < n-i-1 && a[child1] < a[smallInd])
					smallInd = child1;
				if(child2 < n-i-1 && a[child2] < a[smallInd])
					smallInd = child2;
				if(parent == smallInd)
					break;
				else {
					int t = a[smallInd];
					a[smallInd] = a[parent];
					a[parent] = t;
					parent = smallInd;
				}
			}
		}
		return;
	}
}
