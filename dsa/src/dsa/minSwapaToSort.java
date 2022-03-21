package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class minSwapaToSort {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//	      System.out.println("hello");
	      int n = 5;
	      int[] arr = {10, 19, 6, 3, 5};
	      HashMap<Integer, Integer> map = new HashMap<>();
	      for(int i = 0; i<n; i++){
//	        arr[i] = sc.nextInt();
	        map.put(arr[i], i);
	      }
	      int count = 0;
	      System.out.println(Arrays.toString(arr));
	      Arrays.sort(arr);
	      System.out.println(Arrays.toString(arr));
	      for(int i = 0; i<n; i++){
	        if(i == map.get(arr[i]))
	          continue;
	        else{
	          int temp = arr[i];
	          arr[i] = arr[map.get(arr[i])];
	          arr[map.get(temp)] = temp;
	          count++;
	          i--;
	        }
//	        System.out.println("hii");
	      }
	      System.out.println(Arrays.toString(arr));
	      System.out.println(count);
	      return;

	}

}
