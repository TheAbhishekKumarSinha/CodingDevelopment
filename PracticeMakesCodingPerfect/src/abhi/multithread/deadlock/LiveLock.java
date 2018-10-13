package abhi.multithread.deadlock;

/**
 * @author Abhishek Kumar Sinha
 *
 */
class Worker {
    boolean isActive;
    String workerName;

    /**
     * @param isActive
     * @param workerName
     */
    public Worker(boolean isActive, String workerName) {
        super();
        this.isActive = isActive;
        this.workerName = workerName;
    }

    protected String getWorkerName() {
        return workerName;
    }

    protected synchronized void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    protected boolean isActive() {
        return isActive;
    }

    protected void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public synchronized void work(Resource resource, Worker otherWorker) throws InterruptedException {
        while (isActive()) {
            if (resource.getOwner() != this) {
                wait(10);
                continue;
            }

            if (otherWorker.isActive()) {
                System.out.println(getWorkerName() + "handing resource to " + otherWorker.getWorkerName());
                resource.setOwner(otherWorker);
                continue;

            }

            System.out.println(getWorkerName() + ": working on the common resource");
            isActive = false;
            resource.setOwner(otherWorker);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */

}

class Resource {
    private Worker owner;

    protected Worker getOwner() {
        return owner;
    }

    protected void setOwner(Worker owner) {
        this.owner = owner;
    }

    /**
     * @param owner
     */
    public Resource(Worker owner) {
        super();
        this.owner = owner;
    }

}

public class LiveLock {
    public static void main(String[] args) {
        final Worker worker1 = new Worker(true, "Worker 1");
        final Worker worker2 = new Worker(true, "Worker 2");

        final Resource resource = new Resource(worker1);
        new Thread(() -> {

            try {
                worker1.work(resource, worker2);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                worker2.work(resource, worker1);
            }
            catch (InterruptedException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }
        }).start();
    }
}
