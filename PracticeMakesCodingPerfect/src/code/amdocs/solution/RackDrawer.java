package code.amdocs.solution;

public class RackDrawer {
	public static void main(String[] args){
		RackDrawer rack= new RackDrawer();
		rack.insertBook(56);
		int a=10;  
		String s=String.valueOf(a);  
		System.out.println(s+10); 
		
		StringBuffer sb=new StringBuffer("Hello");  
		sb.replace(1,3,"Java");  
		System.out.println(sb);//prints HJavalo  
	}

	public void insertBook(int bookcount) {
		String rack[][]= new String[10][10];
		int drawercounter= 1;int k=1;

		while(k<=bookcount){
			System.out.println("Books in Drawer No :"+drawercounter);
			for(int i=0;i<10;i++){
				if(k<=bookcount){
					rack[drawercounter][i]="Book No:"+k++;
					System.out.println(rack[drawercounter][i]+"\t");
				}
				
			}
			drawercounter++;
		}
		


	}


}
