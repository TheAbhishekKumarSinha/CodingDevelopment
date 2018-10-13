package designpattern.creational.factorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
import java.util.ArrayList;
import java.util.Iterator;

public class TestRobotBuilders {
    public static void main(String args[]) {
        TestRobotBuilder builder;
        RobotBuildable robot;
        String response = "a";

        builder = new Cooker();
        // builder = new AutomotiveRobotBuilder();

        // Start the construction process.

        builder.addStart();
        builder.addTest();
        builder.addAssemble();
        builder.addStop();

        robot = builder.getRobot();

        robot.go();
    }
}

class Cooker implements TestRobotBuilder {
    CookerBuildable robot;
    ArrayList<Integer> actions;

    public Cooker() {
        robot = new CookerBuildable();
        actions = new ArrayList<Integer>();
    }

    public void addStart() {
        actions.add(new Integer(1));
    }

    public void addGetParts() {
        actions.add(new Integer(2));
    }

    public void addAssemble() {
        actions.add(new Integer(3));
    }

    public void addTest() {
        actions.add(new Integer(4));
    }

    public void addStop() {
        actions.add(new Integer(5));
    }

    public RobotBuildable getRobot() {
        robot.loadActions(actions);
        return robot;
    }

}

class Car implements TestRobotBuilder {
    CarBuildable robot;
    ArrayList<Integer> actions;

    public Car() {
        robot = new CarBuildable();
        actions = new ArrayList<Integer>();
    }

    public void addStart() {
        actions.add(new Integer(1));
    }

    public void addGetParts() {
        actions.add(new Integer(2));
    }

    public void addAssemble() {
        actions.add(new Integer(3));
    }

    public void addTest() {
        actions.add(new Integer(4));
    }

    public void addStop() {
        actions.add(new Integer(5));
    }

    public RobotBuildable getRobot() {
        robot.loadActions(actions);
        return robot;
    }

}

class CookerBuildable implements RobotBuildable {
    ArrayList<Integer> actions;

    public CookerBuildable() {
    }

    public final void go() {
        Iterator itr = actions.iterator();

        while (itr.hasNext()) {
            switch ((Integer) itr.next()) {
                case 1:
                    start();
                    break;
                case 2:
                    getParts();
                    break;
                case 3:
                    assemble();
                    break;
                case 4:
                    test();
                    break;
                case 5:
                    stop();
                    break;
            }
        }
    }

    public void start() {
        System.out.println("Starting....");
    }

    public void getParts() {
        System.out.println("Getting flour and sugar....");
    }

    public void assemble() {
        System.out.println("Baking a cookie....");
    }

    public void test() {
        System.out.println("Crunching a cookie....");
    }

    public void stop() {
        System.out.println("Stopping....");
    }

    public void loadActions(ArrayList<Integer> a) {
        actions = a;
    }
}

class CarBuildable implements RobotBuildable {
    ArrayList<Integer> actions;

    public CarBuildable() {
    }

    public final void go() {
        Iterator itr = actions.iterator();

        while (itr.hasNext()) {
            switch ((Integer) itr.next()) {
                case 1:
                    start();
                    break;
                case 2:
                    getParts();
                    break;
                case 3:
                    assemble();
                    break;
                case 4:
                    test();
                    break;
                case 5:
                    stop();
                    break;
            }
        }
    }

    public void start() {
        System.out.println("Starting....");
    }

    public void getParts() {
        System.out.println("Getting a carburetor....");
    }

    public void assemble() {
        System.out.println("Installing the carburetor....");
    }

    public void test() {
        System.out.println("Revving the engine....");
    }

    public void stop() {
        System.out.println("Stopping....");
    }

    public void loadActions(ArrayList<Integer> a) {
        actions = a;
    }
}