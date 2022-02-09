package dsa;

import java.util.Arrays;

public class findMissingAndDuplicate1toN {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 2, 1, 1, 5};
		int i = 0;
		while(i < arr.length) {
			while(arr[i] != i+1) {
				if(arr[i] == arr[arr[i]-1])
					break;
				else {
					int temp = arr[arr[i]-1];
					arr[arr[i]-1] = arr[i];
					arr[i] = temp;
				}
			}
			i++;
		}
//		System.out.println("hello");
		System.out.println(Arrays.toString(arr));
		i = 0;
		while(i<arr.length) {
			if(arr[i] != i+1) {
				System.out.println("Missing element is : "+(i+1));
				System.out.println("Duplicate elemnt is : "+ arr[i]);
			}
			i++;
		}
//		System.out.println("Missing element is : "+(i+1));
//		System.out.println("Duplicate elemnt is : "+ arr[i]);
		

	}

}
