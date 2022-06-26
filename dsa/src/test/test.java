package test;

public class test {
	
	public static void main(String[] args) {
		System.out.println(noPrime(3, 2));
	}
	
	public static int noPrime(int a, int b) {
		int ans = 0;
		long[] prime = new long[a+1];
		long facto = 1;
		for(int i = 1; i<=a; i++) {
			facto = facto*i;
			prime[i] = facto+b;
		}
		for(int i = 1; i<a+1; i++) {
			if(isPrime(prime[i]))
				ans++;
		}
		return ans;
	}

	public static boolean isPrime(long n) {  
	       if (n <= 1) {  
	           return false;  
	       }  
	       for (int i = 2; i <= Math.sqrt(n); i++) {  
	           if (n % i == 0) {  
	               return false;  
	           }  
	       }  
	       return true;  
	   }  
}
