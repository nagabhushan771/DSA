package dsa;

import java.util.Arrays;

public class sortArrayUsingRecursion {

	public static void main(String[] args) {
		int[] arr = {13, 1, 1, 1, 1, 1, 0};
		sort(arr, arr.length-1);
		System.out.println(Arrays.toString(arr));
		return;
	}

	public static void sort(int[] a, int ind) {
		if(ind == 0)
			return;
		
		sort(a, ind-1);//this will give sorted array upto index ind-1
		insert(a, ind-1, a[ind]);//this will insert the arr[ind] in it's correct position
		return;
	}
	
	public static void insert(int[] a, int ind, int val) {
		
		if(ind == -1 || a[ind] <= val) {
			a[ind+1] = val;
			return;
		}
		
		a[ind+1] = a[ind];
		insert(a, ind-1, val);
			
		return;
	}
}
