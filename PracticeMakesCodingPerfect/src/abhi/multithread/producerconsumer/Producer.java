package abhi.multithread.producerconsumer;

public class Producer extends Thread{
	private CubbyHole c;
	public Producer(CubbyHole c){
		this.c=c;
	}
	public void run(){
		for(int i=0;i<10;i++){
			try {
				c.put(i);
				
			//hread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
