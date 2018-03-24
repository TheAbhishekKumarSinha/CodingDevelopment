package code.amdocs.solution;

public class StringReverse {
	
	public static void main(String args[]){
		StringReverse rev= new StringReverse();
		rev.Reverse("I am having food");
		rev.wordReverse("I am having food");
	}

	public void Reverse(String string) {
		for(int i=string.length()-1;i>=0;i--)
		System.out.print(string.charAt(i));
		System.out.println("");
		
	}

	public void wordReverse(String string) {
		String a[]=string.split(" ");
		for(int i=a.length-1;i>=0;i--){
			System.out.print(a[i]+ " ");
		}
		
	}

}
