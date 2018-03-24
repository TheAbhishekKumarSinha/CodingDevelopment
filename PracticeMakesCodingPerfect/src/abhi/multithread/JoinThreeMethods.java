package abhi.multithread;

public class JoinThreeMethods extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        JoinThreeMethods t1 = new JoinThreeMethods();
        JoinThreeMethods t2 = new JoinThreeMethods();
        JoinThreeMethods t3 = new JoinThreeMethods();
        t1.start();

        try {
            t1.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
        try {
            t2.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        t3.start();
    }
}
