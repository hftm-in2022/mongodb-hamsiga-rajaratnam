package ch.hftm.nosql.workspace.boundry;

import ch.hftm.nosql.workspace.entity.Category;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @GET
    public List<Category> getAllCategories() {
        return Category.listAll();
    }

    @POST
    public Response createCategory(Category category) {
        category.persist();
        return Response.status(Response.Status.CREATED).entity(category).build();
    }
}
