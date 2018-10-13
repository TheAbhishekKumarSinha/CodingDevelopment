package org.springhibernate.webservices.services;

import java.io.IOException;
import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.springhibernate.controllers.helper.HelperClass;
import org.springhibernate.jdbc.pojo.Users;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@WebService(serviceName = "UserListService")
public class UserList {
    @WebResult(name = "Users")
    public List<Users> userList() throws IOException {
        return HelperClass.userList();
    }

    @WebResult(name = "Users")
    public Users userDetails(String userId) throws IOException {
        return HelperClass.userList().get(1);
    }

    static {
        Endpoint.publish("http://localhost:8123/Services/UserListService", new UserList());

    }
}
