package code.amdocs.solution;

class CSE implements Runnable {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    int x, y;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                x = 12;
                y = 12;
            }
        }

    }

}

class Test {

    public static void main(String[] args) {

        /*
         * String toBeCased = args[0]; if (Character.isUpperCase(toBeCased.charAt(0))) { toBeCased =
         * toBeCased.toUpperCase(); } else { toBeCased = toBeCased.toLowerCase(); }
         * System.out.println(toBeCased);
         */

        final int x;
        x = 20;
        System.out.println(x);

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t2.start();
        t1.start();

    }

}
