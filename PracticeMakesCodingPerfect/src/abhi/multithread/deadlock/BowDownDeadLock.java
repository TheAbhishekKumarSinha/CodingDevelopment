package abhi.multithread.deadlock;

public class BowDownDeadLock {
	static class Friend{
		private final String bowerName;

		public Friend(String bowerName){
			this.bowerName=bowerName;
		}

		public String getName(){
			return this.bowerName;
		}

		public synchronized void bow(Friend Person){
			//System.out.println(this.bowerName+ Person.getName());//deadlock not happening
			//dead lock happening 
			 System.out.format("%s: %s"
	                + "  has bowed to me!%n", 
	                this.bowerName, Person.getName());
			Person.bowBack(this);
		}

		public synchronized void bowBack(Friend friend){
			System.out.println(this.bowerName+" has bowed Down Back to "+friend.getName());
		}
	}


	public static void main(String args[]){
		final Friend abhishek= new Friend("Abhishek");
		final Friend abhiMini= new Friend("Abhinav");
		new Thread(new Runnable(){
			public void run() {
				{
					abhishek.bow(abhiMini);
				}
			}}).start();
		new Thread(new Runnable(){
			public void run() {
				{
					abhiMini.bow(abhishek);
				}
			}}).start();
	}

}
