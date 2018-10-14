package org.springhibernate.webservices.soap.services;

import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.springhibernate.controllers.helper.HelperClass;
import org.springhibernate.jdbc.pojo.Users;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@WebService(serviceName = "UserListService", portName = "UserListPortDtls", name = "UserList", targetNamespace = "http://www.userservice.com/users")

public class UserList {
    @WebResult(name = "User")
    @WebMethod(action = "getUserList", operationName = "getAllUserList")
    public List<Users> userList() throws IOException {
        return HelperClass.userList();
    }

    @WebResult(name = "User")
    @WebMethod(action = "getUserDetail", operationName = "getUserDtlsList")
    public Users userDetails(@WebParam(name = "UserCode") @XmlElement(nillable = false, required = true) String userId)
            throws IOException {
        List<Users> users = HelperClass.userList();
        for (Users us : users) {
            if (us.getUserid().equals(userId)) {
                return us;
            }
        }
        throw new NullPointerException("User Not Found");

    }

    static {
        // Endpoint.publish("http://localhost:8123/Services/UserListService", new UserList());

    }
}
