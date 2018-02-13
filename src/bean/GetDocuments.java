package bean;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.DocumentsEJB;

@DeclareRoles({ "TutorialUser", "AnotherUser" })
@ApplicationScoped
@Path("/getdocuments")
public class GetDocuments {

	@Inject
	DocumentsEJB documentsEJB;

	// @RolesAllowed("TutorialUser")
	@DenyAll
	@GET
	@Produces("application/json; charset=utf-8")
	public Response getAllDocuments() throws Exception {
		Gson gson = new Gson();
		String jsonString = null;
		try {
			jsonString = gson.toJson(documentsEJB.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return Response.status(200).entity(jsonString).build();

	}

}
