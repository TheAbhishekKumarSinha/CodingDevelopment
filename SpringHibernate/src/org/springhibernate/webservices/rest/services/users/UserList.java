package org.springhibernate.webservices.rest.services.users;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springhibernate.controllers.helper.HelperClass;
import org.springhibernate.jdbc.pojo.Users;

/**
 * @author Abhishek Kumar Sinha
 *
 */
@Path("/Users")
public class UserList {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUserList() throws IOException {

        return HelperClass.userList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Users getUserDetailsWithId(@PathParam("userId") String userId) throws IOException {
        List<Users> users = HelperClass.userList();
        for (Users us : users) {
            if (us.getUserid().equals(userId)) {
                return us;
            }
        }
        throw new NullPointerException("User Not Found");
    }
}
