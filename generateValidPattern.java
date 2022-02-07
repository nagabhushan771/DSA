
public class generateValidPattern {

	public static void main(String[] args) {
		int n = 2;
		solve(n,n,"");

	}
	
	public static void solve(int open, int close, String s) {
		if(open == 0 && close == 0) {
			System.out.println(s);
			return;
		}
		if(open == close)
			solve(open-1, close, s+"(");
		if(open == 0)
			solve(open, close-1, s+")");
		else {
			solve(open-1, close, s+"(");
			solve(open, close-1, s+")");
		}
//		return;
	}

}
