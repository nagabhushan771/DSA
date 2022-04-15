package dsa.bitManipulation;

public class DecimalToBinary {

	public static void main(String[] args) {
		int n = 8;
		
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			sb.append(n%2 == 0 ? "0" : "1");
			n/=2;
		}
		sb.reverse();
		System.out.println(sb.toString());
	}

}
