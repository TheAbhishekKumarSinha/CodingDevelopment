package geeksforgeeks.datastructure.practice;

public class InfixToPostFix {
	
	public static int priority(char symbol) {
		switch(symbol) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		case '(':
		case ')':
			return -1;
		default:break;
		}
		return 0;
	}
	
	public static void main(String args[]) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		convertInfixToPostFix(exp);
	}

	private static void convertInfixToPostFix(String exp) {
		Stack stack = new Stack();
		for(int i =0;i<exp.length();i++) {
			if(priority(exp.charAt(i))==0) {
				System.out.print(exp.charAt(i));
			}else if(priority(exp.charAt(i))==-1) {
				if(exp.charAt(i)=='('){
					stack.push(String.valueOf(exp.charAt(i)));
				}else {
					while(!stack.peek().equals("(")) {
						System.out.print(stack.pop());
					}
					stack.pop();
				}
			}else {
				if(priority(exp.charAt(i))>priority(stack.peek().charAt(0))) {
					stack.push(String.valueOf(exp.charAt(i)));
				}else {
					while(priority(exp.charAt(i))<=priority(stack.peek().charAt(0))) {
						System.out.print(stack.pop());
					}stack.push(String.valueOf(exp.charAt(i)));
				}
			}
		}while(!stack.isempty()) {
			String a= stack.pop();
			if(!(a.equals("(")))
				System.out.print(a);
		}
		
	}
}
