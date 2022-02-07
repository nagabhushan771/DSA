
import java.util.*;
import java.io.*;

public class kSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int l = 0;
		int r = k;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (isPossible(arr, mid, k))
				r = mid;
			else
				l = mid + 1;
		}
		System.out.println(l);
	}

	public static boolean isPossible(int[] arr, int d, int k) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Math.ceil(arr[i] / d);
		}
		if (sum <= k)
			return true;
		else
			return false;
	}
}