package abhi.multithread.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RemoveBowDownDeadLock {
	static class Friend{
		private String name;
		private final Lock lock= new ReentrantLock();
		Friend(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}

		public boolean impendingBow(Friend bowee){
			boolean mylock=false;
			boolean friendLock=false;
			try{
				mylock=this.lock.tryLock();
				friendLock= bowee.lock.tryLock();
			}finally{
				if (! (mylock && friendLock)) {
					if(mylock){
						lock.unlock();
					}
					if(friendLock){
						bowee.lock.unlock();
					}
				}

			}
			return (mylock && friendLock);		
		}

		public void bow(Friend bowee){
			if(this.impendingBow(bowee)){
				try{
					System.out.println(Thread.currentThread().getName()+": "+ this.name +" has bowed to "+bowee.getName());
					bowee.bowback(this);
				}
				finally {
                    lock.unlock();
                    bowee.lock.unlock();
                }
			}else{
				System.out.println(Thread.currentThread().getName()+": "+this.getName()+" has bowed to "+bowee.getName()+
						" while "+this.getName()+" saw "+bowee.getName()+" has bowed to "+this.getName());
			}

		}
		public void bowback(Friend friend) {
			System.out.println(Thread.currentThread().getName()+": "+this.name+" has bowed back to "+friend.getName());

		}
	}
	/*static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }
    
        public void run() {
            Random random = new Random();
            for (;;) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                bowee.bow(bower);
            }
        }
    }
            

    public static void main(String[] args) {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }*/

	public static void main(String[] args) {
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				 Random random = new Random();
		            for (;;) {
		                try {
		                	Thread.sleep(10);
		                } catch (InterruptedException e) {}
		                alphonse.bow(gaston);;
		            } }
		}).start();
		new Thread(new Runnable() {
			public void run() {
				 Random random = new Random();
		            for (;;) {
		                try {
		                	Thread.sleep(9);
		                } catch (InterruptedException e) {}
		                gaston.bow(alphonse);;
		            }  }
		}).start();
	}
}
