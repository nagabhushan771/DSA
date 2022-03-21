package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 5, 6, 2, 10, 9};
		int n = arr.length;
		int[] ans = new int[n];
		
		Stack<Integer> st = new Stack<>();
		for(int i = n-1; i>=0; i--) {
			while(!st.empty() && st.peek() > arr[i]) {
				st.pop();
			}
			if(st.empty())
				ans[i] = -1;
			else
				ans[i] = st.peek();
			st.push(arr[i]);
		}
		System.out.println(Arrays.toString(ans));
		return;
	}

}
