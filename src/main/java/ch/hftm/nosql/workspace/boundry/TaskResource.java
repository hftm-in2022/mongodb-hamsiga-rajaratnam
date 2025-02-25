package ch.hftm.nosql.workspace.boundry;

import ch.hftm.nosql.workspace.entity.Task;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") String id) {
        return Task.findById(new org.bson.types.ObjectId(id));
    }

    @POST
    public Response createTask(Task task) {
        task.persist();
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") String id, Task updatedTask) {
        Task existingTask = Task.findById(new org.bson.types.ObjectId(id));
        if (existingTask == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingTask.title = updatedTask.title;
        existingTask.description = updatedTask.description;
        existingTask.dueDate = updatedTask.dueDate;
        existingTask.priority = updatedTask.priority;
        existingTask.status = updatedTask.status;
        existingTask.persistOrUpdate();
        return Response.ok(existingTask).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") String id) {
        boolean deleted = Task.deleteById(new org.bson.types.ObjectId(id));
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
