package abhi.multithread.oddeven;

public class OddEvenFactory {
	private boolean isOdd;
	public synchronized void OddPrint(int Number) throws InterruptedException{
		while(isOdd){
			wait();
		}
		isOdd=true;
		System.out.println("Odd:"+Number);
		notify();
		
	}
	
	public synchronized void EvenPrint(int Number) throws InterruptedException{
		while(!isOdd){
			wait();
		}
		isOdd=false;
		System.out.println("Even:"+Number);
		notify();
		
	}

}
