package abhi.multithread;

public class MultiRunnable implements Runnable{

	@Override
	public void run() {
		for (int i=0;i<10;i++){
			System.out.println("I Hates Abhishek");
		}
		
	}
	
	
	public static void main(String args[]){
		new Thread(new MultiRunnable()).start();
		new Thread(new MultiRunnable()).start();
	}
}
