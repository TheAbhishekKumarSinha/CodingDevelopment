package designpattern.structural.proxy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ExecuteCommandImpl implements ExecuteCommand {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.proxy.ExecuteCommand#runCommand(java.lang.String)
     */
    @Override
    public void runCommand(String cmd) throws Exception {

        System.out.println(cmd + "Execute Command Successfully");

    }

}
