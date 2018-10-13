package designpattern.structural.proxy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ExecuteProxyTest {
    public static void main(String[] args) {

        ExecuteCommand executor = new ExecuteCommandProxyClass("Pankaj", "wrong_pwd");
        try {
            executor.runCommand("cd..");
            executor.runCommand("rm -rf abc.pdf");
        }
        catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }

        executor = new ExecuteCommandProxyClass("Abhishek", "Abhishek");
        try {
            executor.runCommand("cd..");
            executor.runCommand("rm -rf abc.pdf");
        }
        catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}
