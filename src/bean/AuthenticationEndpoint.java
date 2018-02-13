package bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.AuthenticateEJB;
import entity.User;
import security.Credentials;

@ApplicationScoped
@Path("/authentication")
public class AuthenticationEndpoint {

	private boolean isAuthenticated = false;
	@Inject
	AuthenticateEJB authenticateEJB;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(String jsonString) {
		Gson gson = new Gson();
		Credentials credentials = gson.fromJson(jsonString, Credentials.class);
		String userName = credentials.getUserName();
		String password = credentials.getPassword();

		try {
			User user = authenticateEJB.checkUser(userName, password);
			if ((user instanceof User) && user != null) {
				return Response.ok().header("token", user.getToken().getToken()).build();
			} else {
				return Response.status(Response.Status.FORBIDDEN).build();
			}
		} catch (Exception e) {
			System.out.println("Exception in authUser");
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}
}
