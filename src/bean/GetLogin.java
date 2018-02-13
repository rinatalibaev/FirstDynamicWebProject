package bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.PsswrdsEJB;

@ApplicationScoped
@Path("/login/{username}/{password}")
public class GetLogin {

	@Inject
	PsswrdsEJB psswrdsEJB;

	@GET
	@Produces("application/json; charset=utf-8")
	public Response getLogin(@PathParam("username") String userName, @PathParam("password") String password) throws Exception {
		System.out.println("In getLogin");
		Gson gson = new Gson();
		String jsonString = null;
		try {
			if (psswrdsEJB.checkUser(userName, password) != null) {
				jsonString = gson.toJson(psswrdsEJB.checkUser(userName, password));
			} else {
				jsonString = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jsonString != null) {
			return Response.status(200).entity(jsonString).build();
		}
		return Response.status(404).build();
	}

	// @GET
	// @Produces("application/json; charset=utf-8")
	// public Response getLogin(@PathParam("username") String userName,
	// @PathParam("password") String password) throws Exception {
	// Gson gson = new Gson();
	// String jsonString = null;
	// try {
	// jsonString = gson.toJson(employeeEJB.getAll());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return Response.status(200).entity(jsonString).build();
	// }
}
