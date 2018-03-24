package abhi.multithread;

public class ThreadInterferance {
	
	public int count=0;
	
	public synchronized void increment(){
		System.out.println(Thread.currentThread().getName()+"-BEFORE INCREMENT: "+ getCount());
		System.out.println(Thread.currentThread().getName()+": ABHISHEK KUMAR");
		System.out.println(Thread.currentThread().getName()+": ABHINAV KUMAR");
		System.out.println(Thread.currentThread().getName()+": ABHIJEET KUMAR");
		count++;
		System.out.println(Thread.currentThread().getName()+"-AFTER INCREMENT: "+ getCount());
	}
	
	public synchronized void decrement(){
		System.out.println(Thread.currentThread().getName()+"-BEFORE DECREMENT: "+ getCount());
		System.out.println(Thread.currentThread().getName()+": XYZZZZZ");
		System.out.println(Thread.currentThread().getName()+": QWEERERER");
		System.out.println(Thread.currentThread().getName()+": DSFDSFDSFDFDG");
		count--;
		System.out.println(Thread.currentThread().getName()+"-AFTER DECREMENT: "+ getCount());
	}
	public synchronized int getCount(){
		return count;
			
	}
	
	public static class ThreadIncrementRunnable implements Runnable{
		ThreadInterferance t=null;
		ThreadIncrementRunnable(ThreadInterferance t){
			this.t=t;
		}
		@Override
		public void run(){
			t.increment();
			System.out.println(Thread.currentThread().getName()+"-FINAL:" +t.getCount());
		}
	}
	
	public static class ThreadDecrementRunnable implements Runnable{
		ThreadInterferance t=null;
		ThreadDecrementRunnable(ThreadInterferance t){
			this.t=t;
		}
		@Override
		public void run(){
			
			t.decrement();
			System.out.println(Thread.currentThread().getName()+"-FINAL:" +t.getCount());
		}
	}
	public static void main(String args[]) throws InterruptedException{
		ThreadInterferance tI=new ThreadInterferance();
		Thread t= new Thread(new ThreadIncrementRunnable(tI));
		t.setName("First Thread");
		Thread t1= new Thread(new ThreadDecrementRunnable(tI));
		t1.setName("Second Thread");
		t.start();
		t1.start();
	}
}
