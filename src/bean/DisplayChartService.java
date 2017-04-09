package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.EmployeeEJB;

@ApplicationScoped
@ManagedBean
@Path("/displaychart")
public class DisplayChartService extends Application {

	@Inject
	EmployeeEJB empEJB;

	@GET
	@Produces("application/json; charset=utf-8")
	public Response displayChart() throws Exception {
		String my_data = parseJSON();
		System.out.println("Control point10");
		return Response.status(200).entity(my_data).build();
	}

	@SuppressWarnings("unchecked")
	private String parseJSON() {
		Gson gson = new Gson();
		String jsonString = null;
		try {
			System.out.println("Control point0");
			jsonString = gson.toJson(empEJB.getAll());
			System.out.println("Control point6");
		} catch (Exception e) {
			System.out.println("Control point7");
			e.printStackTrace();
			System.out.println("Control point8");
		}
		System.out.println(jsonString);
		System.out.println("Control point9");
		return jsonString;
	}

}
