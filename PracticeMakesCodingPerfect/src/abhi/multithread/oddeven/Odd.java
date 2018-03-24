package abhi.multithread.oddeven;

public class Odd implements Runnable{
	private OddEvenFactory factory;
	private int maxNum;
	Odd(OddEvenFactory factory,boolean isOdd,int maxNum){
		this.factory=factory;
		this.maxNum=maxNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=maxNum;i+=2){
			try {
				factory.OddPrint(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
