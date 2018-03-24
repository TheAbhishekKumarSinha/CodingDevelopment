package abhi.multithread.oddeven;

public class Even implements Runnable{
	private OddEvenFactory factory;
	private int maxNum;
	Even(OddEvenFactory factory,boolean isOdd,int maxNum){
		this.factory=factory;
		this.maxNum=maxNum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=2;i<=maxNum;i+=2){
			try {
				factory.EvenPrint(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
