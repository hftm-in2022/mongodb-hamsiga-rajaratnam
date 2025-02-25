package ch.hftm.nosql.workspace.boundry;

import ch.hftm.nosql.workspace.entity.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getAllUsers() {
        return User.listAll();
    }

    @POST
    public Response createUser(User user) {
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
}

