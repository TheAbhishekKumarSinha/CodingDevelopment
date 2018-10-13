package designpattern.creational.factorypattern;

/**
 * @author Abhishek Kumar Sinha
 *
 */
interface TestRobotBuilder {
    public void addStart();

    public void addGetParts();

    public void addAssemble();

    public void addTest();

    public void addStop();

    public RobotBuildable getRobot();
}

interface RobotBuildable {
    public void go();
}
