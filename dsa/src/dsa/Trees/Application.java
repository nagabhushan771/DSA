package dsa.Trees;

public class Application {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		int[] arr = new int[]{1, 2, 5, 3, 4, 6};
		
		for(int i = 0; i<arr.length; i++) {
			bst.insert(arr[i]);
		}
		
		

	}

}
