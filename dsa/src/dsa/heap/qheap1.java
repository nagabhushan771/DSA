package dsa.heap;

import java.util.HashMap;
import java.util.Scanner;

public class qheap1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// MinimimHeap minh = new MinimimHeap();
		System.out.println("Enter number of queries : ");
		int n = sc.nextInt();
		MinimimHeap minh = new MinimimHeap(n);
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the option : ");
			int a = sc.nextInt();
			if(a == 1) {
				System.out.println("Enter the value to be inserted : ");
//				int val = sc.nextInt();
				minh.add(sc.nextInt());
			} else if(a == 2){
				System.out.println("Enter the value to be deleted : ");
//				int rm = sc.nextInt();
				minh.poll(sc.nextInt());
			}else if(a == 3) {
				System.out.println(minh.peek());
			}else
				System.out.println("Invalid Choice");
		}
		return;
	}

}

class MinimimHeap {
	int[] arr;
	HashMap<Integer, Integer> map;
	int ind;
	int size;

	public MinimimHeap(int n) {
		size = n;
		ind = -1;
		arr = new int[size + 1];
		map = new HashMap<Integer, Integer>();
	}

	public void add(int val) {
		arr[++ind] = val;
		map.put(val, ind);
		int child = ind;
		int parent = (child - 1) / 2;
		while (parent >= 0 && arr[parent] > arr[child]) {
			int temp = arr[parent];
			arr[parent] = arr[child];
			arr[child] = temp;
			map.put(arr[child], child);
			map.put(arr[parent], parent);
			child = parent;
			parent = (child - 1) / 2;
		}
		return;
	}

	public void poll(int val) {
		int valInd = map.get(val);
		int temp = arr[valInd];
		arr[valInd] = arr[ind];
		arr[ind] = temp;
		map.put(arr[valInd], valInd);
		map.remove(arr[ind]);
		int parent = valInd;
		while (parent < ind) {
			int child1 = parent * 2 + 1;
			int child2 = parent * 2 + 2;
			int smallInd = parent;
			if (child1 < ind && arr[smallInd] > arr[child1])
				smallInd = child1;
			if (child2 < ind && arr[smallInd] > arr[child2])
				smallInd = child2;

			if (parent == smallInd)
				break;

			int t = arr[smallInd];
			arr[smallInd] = arr[parent];
			arr[parent] = t;
			map.put(arr[parent], parent);
			map.put(arr[smallInd], smallInd);
			parent = smallInd;
		}
		ind--;
		return;
	}

	public int peek() {
		if (ind == -1)
			return -1;
		return arr[0];
	}
}
