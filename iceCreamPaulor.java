import java.io.*;
import java.util.*;

public class iceCreamPaulor {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		while (t-- > 0) {
			int k = 4;//sc.nextInt();
			int n = 5;//sc.nextInt();

			int[] arr = {1, 4, 5, 3, 2};
//			for (int i = 0; i < n; i++) {
//				arr[i] = sc.nextInt();
//			}
			int[] hashArray = new int[10001];
			Arrays.fill(hashArray, -1);
			for (int i = 0; i < n; i++) {
				if (arr[i] < k && hashArray[k - arr[i]] > -1) {
					System.out.println((hashArray[k - arr[i]] + 1) + " " + (i + 1));
					break;
				}
				hashArray[arr[i]] = i;
			}
//		}
	}

}
