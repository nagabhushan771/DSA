package dsa.stack;

public class Application {

	public static void main(String[] args) {
//		ArrayStack s = new ArrayStack(3);
//		s.push(1);
//		s.push(6);
//		s.push(7);
//		s.push(5);
//		System.out.println("Peek : " + s.peek());
//		System.out.println("Pop : "+ s.pop());
//		System.out.println("Peek : " + s.peek());
//		s.push(4);
//		System.out.println("Peek : " + (s.peek() == -1 ? "Stack is empty" : s.peek()));
//		System.out.println("Pop : "+ s.pop());
//		System.out.println("Pop : "+ s.pop());
//		System.out.println("Pop : "+ s.pop());
//		System.out.println("Pop : "+ s.pop());
//		System.out.println("Peek : " + (s.peek() == -1 ? "Stack is empty" : s.peek()));
		ExpressionConversion ec = new ExpressionConversion();
		System.out.println(ec.infixToPostfix("K+L-M*N+O^P*W/U/V*T+Q"));
		System.out.println(ec.infixToPrefix("K+L-M*N+O^P*W/U/V*T+Q"));
		System.out.println(ec.postfixToInfix("KL+MN*-OP^W*U/V/T*+Q+"));
		System.out.println(ec.prefixToInfix("++-+KL*MN*//*^OPWUVTQ"));
	}

}
