
import java.io.*;
import java.util.*;

public class Books {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = 1;//sc.nextInt();
		int t = 10;//sc.nextInt();
		int[] arr = {4};//new int[n];
//        int[] count = new int[104];

//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
			// count[a[i]-1]++;
//		}
		// int k = 0;
		// for(int i = 0; i<104; i++){
		// for(int j = 0; j<count[i]; j++){
		// a[k++] = i+1;
		// }
		// }
		// int i;
		// for(i = 0; i<n; i++){
		// if(t>=a[i])
		// t-=a[i];
		// else
		// break;
		// }

		// System.out.println(i);

		int l = 0;
		int r = n;
		int mid = 0;
		int ans=0;
		while (l <= r) {
			mid = l + (r - l) / 2;

			if (isPossible(arr, mid, t)) {
				l = mid+1;
				ans = mid;
			}
			else
				r = mid-1;
		}
		System.out.println(ans);
	}

	public static boolean isPossible(int[] arr, int mid, int time) {
		int t = time;
		for (int i = 0; i < arr.length - mid + 1; i++) {
			t = time;
			for (int j = 0; j < mid; j++) {
				t -= arr[i + j];
			}
			if (t >= 0)
				return true;
		}
		return false;
	}
}
