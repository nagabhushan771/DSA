package dsa.stack;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionConversion {
	HashMap<Character, Integer> preceed;
	
	public ExpressionConversion() {
		preceed = new HashMap<>();
		preceed.put('/', 2);
		preceed.put('*', 2);
		preceed.put('%', 2);
		preceed.put('+', 1);
		preceed.put('-', 1);
		preceed.put('(', 0);
		preceed.put(')', 0);
		preceed.put('^', 3);
	}



	public String infixToPostfix(String infixE) {
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> s = new Stack<>();
		for(int i = 0; i< infixE.length(); i++) {
			char c = infixE.charAt(i);
			if((c<='z' && c >= 'a') || (c >= 'A' && c <='Z') || (c <= '9' && c >='0'))
				sb.append(c);
			else {
				if(c == '(')
					s.push(c);
				else if(c == ')') {
					char x;
					while((x = s.pop()) != '(')
						sb.append(x);
				} else {
					while(!s.empty() && preceed.get(c) <= preceed.get(s.peek())) {
						sb.append(s.pop());
					}
					s.push(c);
				}
				
			}
		}
		while(!s.empty())
			sb.append(s.pop());
		return sb.toString();
	}
	
	public String infixToPrefix(String infixE) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
//		for(int i = 0; i< infixE.length(); i++)
//			s.push(infixE.charAt(i));
//		while(!s.empty())
//			sb.append(s.pop());
//		sb.reverse();
//		infixE = sb.toString();
//		sb.setLength(0);
		for(int i = infixE.length()-1; i >= 0; i--) {
			char c = infixE.charAt(i);
			if((c<='z' && c >= 'a') || (c >= 'A' && c <='Z') || (c <= '9' && c >='0'))
				sb.append(c);
			else {
				if(c == ')')
					s.push(c);
				else if(c == '(') {
					char x;
					while((x = s.pop()) != ')')
						sb.append(x);
				} else {
					while(!s.empty() && preceed.get(c) < preceed.get(s.peek())) {
						sb.append(s.pop());
					}
					s.push(c);
				}
				
			}
		}
		while(!s.empty())
			sb.append(s.pop());
		sb.reverse();
		return sb.toString();
	}
	
	public String postfixToInfix(String postfix) {
//		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();
		for(int i = 0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			if((c<='z' && c >= 'a') || (c >= 'A' && c <='Z') || (c <= '9' && c >='0'))
				s.push("" + c);
			else {
				String x = s.pop();
				String y = s.pop();
				s.push(y + c + x);
			}
		}
		return s.pop();
	}
	
	public String prefixToInfix(String prefix) {
//		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();
		for(int i = prefix.length()-1; i>= 0; i--) {
			char c = prefix.charAt(i);
			if((c<='z' && c >= 'a') || (c >= 'A' && c <='Z') || (c <= '9' && c >='0'))
				s.push("" + c);
			else {
				s.push(s.pop() + c + s.pop());
			}
		}
		return s.pop();
	}

}
