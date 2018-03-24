package code.amdocs.solution;

public class PrimeNo {
	public static void main(String args[]){
		PrimeNo print= new PrimeNo();
		print.primeNo(20);
	}

	public void primeNo(int i) {
		int primeno=2;
		boolean isNotPrime= false;
		System.out.println("Prime Nos:");
		while(primeno<=i){
			for (int k=2;k<=primeno/2;k++){
				if(primeno%k==0){
					isNotPrime=true;
					break;
				}
			}
			if(isNotPrime==false){
				System.out.print(primeno+"\t");
			}
			primeno++;
			isNotPrime=false;
		}
		
		
	}
}
