package abhi.multithread;

public class AbhiTest {

	public static void printMsg(String threadName,String msg){
		
		System.out.println(threadName+": "+msg);
	}
	
	public static class MessageThread extends Thread{
		
		public void run(){
			Thread.currentThread().setName("Child Thread Executing");
			String msgs[]={"I NEED A JOB","WAITING FOR GOOD JOB","TIME AND TIDE WAIT FOR NUN",
					"I AM NOT A LOSER","THE PEOPLE WHO GIVE UP ARE LOSER"," UNTIL YOU DONT GIVE UP,U ARE NOT DEFEATED"};
			for(int i =0;i<msgs.length;i++){
				try {
					Thread.sleep(2000);
					printMsg(Thread.currentThread().getName(), msgs[i]);
					if(Thread.interrupted()){
						printMsg(Thread.currentThread().getName(),"I AM STILL PRINTING");
					}
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		Thread.currentThread().setName("PARENT THREAD");
		MessageThread t=new MessageThread();
		long startTime = System.currentTimeMillis();
		t.start();
		printMsg(Thread.currentThread().getName(),"WAITING FOR CHILD TO FINISH");
		while(t.isAlive()){
			printMsg(Thread.currentThread().getName()," STILL WAITING FOR CHILD");
			t.join(1000);
			if(((System.currentTimeMillis()-startTime)>5000)&&t.isAlive()){
				printMsg(Thread.currentThread().getName()," CHILD TIME IS UP");
				t.interrupt();
				t.stop();
				printMsg(Thread.currentThread().getName()," CHILD INTERRUPTED");
				//t.join();
			}
		}
		printMsg(Thread.currentThread().getName()," EXECUTION FINISHED");
		
	}
}

