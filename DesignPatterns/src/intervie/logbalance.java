package intervie;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class logbalance {

    interface Log {
        double weightUpto(double x); // returns the weightUpto of the part of the log from the left
                                     // end to a point at distance x from it.

        double length(); // returns the total length of the log
    }

    static class Line implements Log {
        private double m;
        private double c;
        private double l;

        public Line(double l, double m, double c) {
            this.m = m;
            this.c = c;
            this.l = l;
        }

        @Override
        public double weightUpto(double x) {
            return m * x + c;
        }

        @Override
        public double length() {
            return l;
        }
    }

    public static void main(String[] args) {
        Log log = new Line(1d, 2d, 4d);
        double low = 0d;
        double r = log.length();

        double expectedWeight = log.weightUpto(r) / 2;

        double length = searchLog(log, low, r, expectedWeight);

        System.out.println(length);
    }

    /**
     * Method Description:
     *
     * Conditions handled:
     *
     * 1.
     *
     * 2.
     * 
     * @param l
     * @param d
     * @return
     */
    private static double searchLog(Log log, double low, double r, double expectedWeight) {
        int mid = 0;
        if (r >= low) {
            mid = (int) (low + (r - low) / 2);

            if (log.weightUpto(mid) == expectedWeight) {
                return mid;
            }

            if (log.weightUpto(mid) < expectedWeight) {
                return searchLog(log, low, mid - 1d, expectedWeight);
            }
            else {
                return searchLog(log, mid + 1d, r, expectedWeight);
            }

        }
        return mid;
    }

}
