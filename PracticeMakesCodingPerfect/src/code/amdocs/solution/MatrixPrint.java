package code.amdocs.solution;
public class MatrixPrint{

	public static void main(String args[])
	{
		MatrixPrint fac = new MatrixPrint();
		fac.matrixprinting(4);

	}

	public void matrixprinting(int lines) {

		int counter=0;
		String a="";
		String arr[] = new String[lines];
		for (int i=0;i<lines;i++){
			for(int j=0;j<=i;j++){
				a+=++counter +"*";
			}
			a=a.substring(0, a.length()-1);
			arr[i]=a;
			a="";

		}
		for (int i=0;i<lines;i++){
			System.out.println(arr[i]);
		}
		for (int k=lines-1;k>=0;k--){
			System.out.println(arr[k]);
		}


	}
}