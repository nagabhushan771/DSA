
public class binaryAndLong {

	public static void main(String[] args) {
		
//		long a = 9223372036854775685l;
//		System.out.println(Long.toBinaryString(a));
//		String str = Long.toBinaryString(a);
//		long b = Long.parseLong(str,2);
//		System.out.println(b);
		long c = 7902;
		long d = 94241;
		for(long i = d-11;i>c-1;i--) {
			d = d&i;
		}
		
		System.out.println(d);
	}

}
