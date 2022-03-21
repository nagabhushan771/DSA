package dsa.stack;

public class ArrayStack {
	private int top;
	private int[] arr;
	
	ArrayStack(int n){
		top = -1;
		arr = new int[n];
	}
	
	void push(int n) {
		if(top+1 == arr.length) {
			System.out.println("Stack Overflow");
			return;
		}
		arr[++top] = n;
		return;
	}
	
	int pop() {
		if(top == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[top--];
	}
	
	int peek() {
		if(top == -1)
			return -1;
		return arr[top];
	}
	
	boolean isEmpty() {
		return top == -1;
	}
}
