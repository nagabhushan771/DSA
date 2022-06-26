package test.cheggTest;

import java.util.HashMap;

public class CheggTestProblems {
	
	public static void main(String[] args) {
		int t = 1000;
		int n = 100;
		int m = 50;
		int x = 100;
		for(int i = 0; i<t; i++) {
			int[] A = new int[n];
			for(int j = 0; j<n; j++) {
				A[j] = ((int)Math.random()*m)+1;
			}
			int X = ((int)Math.random()*x)+1;
			int optR = createMaps(A, X);
			int brute = bruteForce(A, X);
			if(optR != brute) {
				System.out.println("Wrong Answer");
				break;
			}
		}
		System.out.println("Test Completed");
	}
	
	public static int bruteForce(int[] A, int X) {
		int result = 0;
		int n = A.length;
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(A[i] == A[j] && (i*j)%X == 0)
					result++;
			}
		}
		return result;
	}
	
	public static int gcd(int a, int b) {
		return b==0 ? a : gcd(b, a%b);
	}
	
	public static int getQ(int X, int j) {
		return X/gcd(X, j);
	}
	
	public static void addDivisors(int n, HashMap<Integer, Integer> map) {
		int m = 1;
		while(m*m <= n) {
			if(n%m == 0) {
				map.put(m, map.getOrDefault(m, 0)+1);
				int l = n/m;
				if(l != m) {
					map.put(l, map.getOrDefault(l, 0)+1);
				}
			}
			m++;
		}
	}
	
	public static int createMaps(int[] A, int X) {
		int result = 0;
		HashMap<Integer, HashMap<Integer, Integer>> contentsOfA = new HashMap<>();
		int n = A.length;
		for(int i = 1; i<n; i++) {
			if(A[i] == A[0])
				result++;
			if(contentsOfA.containsKey(A[i])) {
				int q = getQ(X, i);
				result += contentsOfA.get(A[i]).getOrDefault(q, 0);
			} else {
				contentsOfA.put(A[i], new HashMap<>());
			}
			addDivisors(i, contentsOfA.get(A[i]));
		}
		return result;
	}
}
