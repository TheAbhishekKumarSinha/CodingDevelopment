package abhi.multithread;

public class HelloThread extends Thread{
	
	public void run(){
		for (int i=0;i<10;i++){
			System.out.println("Abhishek Loves You");
			if(Thread.interrupted()){
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
		}
		try {
			Thread.sleep(4500, 1500);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		for (int i=0;i<10;i++){
			System.out.println("Abhishek Hates You");
		}
	}
	
	public static void main(String args[]){
		HelloThread h2= new HelloThread();
		h2.start();
		System.out.println("Execution Finished");
		h2.interrupt();
	}

}
