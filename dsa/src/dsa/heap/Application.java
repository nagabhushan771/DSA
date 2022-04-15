package dsa.heap;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		minHeap minH = new minHeap(100);
		maxHeap maxH = new maxHeap(100);
		int[] arr= new int[] {20, 6, 35, 4, 12, 19, 21, 55, 38, 22};
//		for(int i = 0; i<arr.length; i++) {
//			minH.add(arr[i]);
//			minH.printHeap();
//			if(i!=0 && i%3 == 0) {
//				minH.poll();
//				minH.printHeap();
//			}
//		}
//		System.out.println("--------------------------------------------------------------------------------------");
//		for(int i = 0; i<arr.length; i++) {
//			maxH.add(arr[i]);
//			maxH.printHeap();
//			if(i!=0 && i%3 == 0) {
//				maxH.poll();
//				maxH.printHeap();
//			}
//		}
		maxHeap.heapSort(arr);
		System.out.println(Arrays.toString(arr));
//		minH.push(7);
//		minH.push(8);
//		minH.push(9);
//		minH.printHeap();
//		minH.push(5);
//		minH.push(3);
//		minH.push(4);
//		System.out.println(minH.top());
//		minH.printHeap();
	}

}
