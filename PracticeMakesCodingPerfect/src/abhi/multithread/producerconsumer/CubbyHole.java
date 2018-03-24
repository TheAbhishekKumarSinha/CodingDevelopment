package abhi.multithread.producerconsumer;

public class CubbyHole {
	
	private boolean avilable;
	private int content;
	public synchronized int get() throws InterruptedException{
		while(!avilable){
			System.out.println("Waiting for Producer To produce");
			System.out.println("Avilable:"+avilable);
			wait();
			
		}
		avilable=false;
		notifyAll();
		System.out.println("Consumer consumed Apple:"+content);
		return content;
	}
	
	public synchronized void put(int value) throws InterruptedException{
		while(avilable){
			System.out.println("Avilable:"+avilable);
			System.out.println("Waiting for Consumer To consume");
			wait();
		}
		content=value;
		System.out.println("Producer Produced Apple:"+value);
		avilable=true;
		notifyAll();
	}

}
