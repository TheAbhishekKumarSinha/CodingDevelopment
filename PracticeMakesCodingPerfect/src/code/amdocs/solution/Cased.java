package code.amdocs.solution;

public class Cased {
	public static void main (String[] args) {
	String toBeCased = args[0];
	 if(Character.isUpperCase(toBeCased.charAt(0))){
	     toBeCased = toBeCased.toUpperCase();
	 }else{
	     toBeCased = toBeCased.toLowerCase();
	 }
	 System.out.println(toBeCased);
	 }
	 
	

}
