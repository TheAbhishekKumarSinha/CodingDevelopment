package abhi.multithread.producerconsumer;

public class Consumer extends Thread{
	private CubbyHole c;
	public Consumer(CubbyHole c){
		this.c=c;
	}
	public void run(){
		for(int i=0;i<10;i++){
			int value=0;
			try {
				value=c.get();				
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
