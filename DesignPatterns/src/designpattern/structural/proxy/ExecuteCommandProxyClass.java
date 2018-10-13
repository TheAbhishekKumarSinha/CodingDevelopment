package designpattern.structural.proxy;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class ExecuteCommandProxyClass implements ExecuteCommand {

    /*
     * (non-Javadoc)
     * 
     * @see designpattern.behavioral.proxy.ExecuteCommand#runCommand(java.lang.String)
     */
    boolean isAdminUser;
    ExecuteCommand command;

    public ExecuteCommandProxyClass(String userName, String password) {
        if (userName.equals("Abhishek") && password.equals("Abhishek")) {
            isAdminUser = true;
        }
        command = new ExecuteCommandImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {

        if (isAdminUser) {
            command.runCommand(cmd);
        }
        else {
            if (cmd.startsWith("rm")) {
                System.out.println("User Doesnt Have Rights to issue this command");
            }
            else {
                command.runCommand(cmd);
            }
        }
    }

}
