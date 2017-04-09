package main;

import javax.ws.rs.Path;;

@Path("/ttocservice2")
public class TbsCupsService2 {
	// @GET
	// @Produces("text/html")
	// public Response convertTbstoCups() throws Exception {
	// Double tbs = 32.0;
	// Double cups;
	// cups = (tbs / 16.0);
	//
	// Double calc[];
	// calc = new Double[2];
	// calc[0] = tbs;
	// calc[1] = cups;
	//
	// String result = "@Produces(\"text/html\") Output: \n\nTbs to Cups Output:
	// \n\n" + "Tablespoons = " + calc[0] + "\n" + "Cups = " + calc[1];
	// return Response.status(200).entity(result).build();
	// }
	//
	// @Path("{t}")
	// @GET
	// @Produces("text/html")
	// public Response convertTbstoCupsfromInput(@PathParam("t") Double t)
	// throws Exception {
	// Double cups;
	// Double tbs = t;
	// cups = (tbs / 16.0);
	//
	// Double calc[];
	// calc = new Double[2];
	// calc[0] = tbs;
	// calc[1] = cups;
	// String result = "@Produces(\"text/html\") Output: \n\nTbs to Cups Output:
	// \n\n" + "Tablespoons = " + calc[0] + "\n" + "Cups = " + calc[1];
	// // return Response.status(200).entity(result).build();
	// return Response.status(200).entity(result).build();
	// }
}