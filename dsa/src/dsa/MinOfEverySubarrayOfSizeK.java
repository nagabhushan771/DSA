package dsa;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MinOfEverySubarrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 20, 30, 50, 10, 70, 30};
		int n = arr.length;
		int k = 3;
		Deque<Integer> q = new LinkedList<>();
		int[] ans = new int[n-k+1];
		for(int i = 0; i< k; i++) {
			while(!q.isEmpty() && arr[q.peekLast()] >= arr[i])
				q.removeLast();
			q.add(i);
		}
		int i = k;
		while(i < n) {
			ans[i-k] = q.peekLast();
			while(!q.isEmpty() && arr[q.peekLast()] >= arr[i])
				q.removeLast();
			while(q.peekFirst() <= i-k)
				q.removeFirst();
			
			q.add(i);
		}
		ans[i-k] = q.peekLast();
		System.out.println(Arrays.toString(ans));
	}

}
