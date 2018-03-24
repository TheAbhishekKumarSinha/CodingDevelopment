package java.geeksforgeek.practice.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

class Stack {
	private final int MAX =100;
	private String data;
	private String arr[]= new String[MAX];
	private int top ;
	public Stack(){
		top=-1;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	boolean isempty() {
		return top<0;
	}
	
	void push(String data) {
		if(top>=MAX) {
			System.out.println("Stack is full");
		}
		else{
			top =top+1;
			arr[top]= data;	
		}
	}
	
	String pop() {
		String symbol = "";
		if(isempty()) {
			System.out.println("Stack is empty");
		}else {
			symbol= arr[top];
			top=top-1;
			
		}return symbol;
	}
	
	String peek() {
		if(!isempty())
			return arr[top];
		return "Empty";
	}
	public boolean validateBracketBalance(String[] data){
		HashMap<String,String> hm= new HashMap<>();
		hm.put("{","}");
		hm.put("(",")");
		hm.put("[","]");
		Set<String> startBrackChar= hm.keySet();
		for(String e:data) {
			if(startBrackChar.contains(e)) {
				push(e);
			}else {
				String stackValue = pop();
				String close = hm.get(stackValue);
				if(!e.equals(close)) {
					System.out.println("Invalid Input"+e);
					return false;
				}
			}
		}
			
		
		
		return true;
		
	}
	
	
}

public class StackSymbolImplementation{
	public static void main(String[] args) {
		Stack stack= new Stack();
		String exp[] = {"{","(",")","}","[","]"};
		
			if (stack.validateBracketBalance(exp))
				System.out.println("Balanced ");
	        else
	        	System.out.println("Not Balanced ");  
		}
        
	}
