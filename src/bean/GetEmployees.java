package bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.EmployeeEJB;

@ApplicationScoped
@Path("/getemployees")
public class GetEmployees {

	@Inject
	EmployeeEJB employeeEJB;

	@GET
	@Produces("application/json; charset=utf-8")
	public Response getAllEmployees() throws Exception {
		Gson gson = new Gson();
		String jsonString = null;
		try {
			jsonString = gson.toJson(employeeEJB.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(jsonString).build();
	}
}
