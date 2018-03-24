package abhi.multithread.producerconsumer;

public class ProducerConsumerTest {
	public static void main(String args[]){
		CubbyHole c= new CubbyHole();
		Producer produce= new Producer(c);
		Consumer consume= new Consumer(c);
		consume.start();
		produce.start();
	}
}
