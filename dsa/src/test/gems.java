package test;

import java.util.Arrays;
import java.util.Comparator;

public class gems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int gems(int[][] a) {
		Arrays.sort(a);
		int n = a.length;
		int i = 0;
		int j = n-1;
		int ans = 0;
		while(i<j) {
			for(int k = 0; k<a[i][0];k++) {
				if(i<j) {
					ans += a[j--][1];
				} else {
					break;
				}
			}
			i++;
		}
		return ans;
	}

}

class arrayComparator implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[1]-o2[1];
	}
	
}
