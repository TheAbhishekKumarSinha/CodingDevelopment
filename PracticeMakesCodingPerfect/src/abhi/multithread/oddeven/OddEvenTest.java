package abhi.multithread.oddeven;

public class OddEvenTest {
	static OddEvenFactory factory= new OddEvenFactory();
	public static void main(String args[]){
		int tillNum= 25;
		Odd odd= new Odd(factory,false,tillNum);
		Thread t1= new Thread(odd);
		Even even= new Even(factory,true,tillNum);
		Thread t2= new Thread(even);
		t1.start();
		t2.start();
		
	}

}
