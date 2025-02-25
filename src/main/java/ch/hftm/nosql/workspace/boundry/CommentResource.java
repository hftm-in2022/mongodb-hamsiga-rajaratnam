package ch.hftm.nosql.workspace.boundry;

import ch.hftm.nosql.workspace.entity.Comment;
import ch.hftm.nosql.workspace.entity.Task;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tasks/{taskId}/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @POST
    public Response addComment(@PathParam("taskId") String taskId, Comment comment) {
        Task task = Task.findById(new org.bson.types.ObjectId(taskId));
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Add the new comment to the Task's comments list
        task.comments.add(comment);
        task.persistOrUpdate();

        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @GET
    public Response getComments(@PathParam("taskId") String taskId) {
        if (taskId == null || taskId.length() != 24) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid taskId format").build();
        }

        Task task = Task.findById(new org.bson.types.ObjectId(taskId));
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(task.comments).build();
    }
}
