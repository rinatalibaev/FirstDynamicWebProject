package bean;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ejb.MailOrdersEJB;

@ApplicationScoped
@Path("/getmailorders")
public class GetMailOrders {

	@Inject
	MailOrdersEJB mailOrdersEJB;

	@GET
	@Produces("application/json; charset=utf-8")
	public Response getAllMailOrders() throws Exception {
		Gson gson = new Gson();
		String jsonString = null;
		try {
			jsonString = gson.toJson(mailOrdersEJB.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return Response.status(200).entity(jsonString).build();
	}

	@GET
	@Path("/{City}")
	@Produces("application/json; charset=utf-8")
	public Response getURI(@PathParam("City") final String city) throws Exception {
		Gson gson = new Gson();
		String scheme = "http";
		String authority = "api.openweathermap.org";
		String path = "/data/2.5/forecast";
		String appid = "4d7189d0d55235c4c6ba300d1811af03";
		String query = "q" + URLEncoder.encode("=", "UTF-8") + city + URLEncoder.encode("&", "UTF-8") + "appid" + URLEncoder.encode("=", "UTF-8") + appid;
		String uriString = scheme + authority + path + query;
		String jsonString = null;
		URI uri;
		try {
			uri = new URI(scheme, authority, path, query, "");
			URL url = uri.toURL();
			jsonString = gson.toJson(uri.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return Response.status(200).entity(jsonString).build();
	}

}
