
public class decodeString {

	public static void main(String[] args) {
		System.out.println(decodestring("3[a]2[bc]"));

	}

	public static String decodestring(String s) {
		int n = 0;
		if (s.indexOf('[') < 0)
			return s;
		n = Integer.parseInt(s.substring(0, s.indexOf('[')));
		if(s.substring(s.indexOf('[')+1).indexOf('[') < s.substring(s.indexOf('[')+1).indexOf(']')){
			
		}
		String repetableStr = s.substring(s.indexOf('[') + 1, s.indexOf(']'));
		String resultString = "";
		for (int i = 0; i < n; i++)
			resultString += repetableStr;
		return resultString + decodestring(s.substring(s.indexOf(']') + 1));
	}

}
