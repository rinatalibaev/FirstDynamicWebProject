package main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ttocservice")
public class TbsCupsService {

	@GET
	@Produces("text/html")
	public Response convertTbstoCups() throws Exception {
		return null;
	}
}
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

// @Path("{t}")
// @GET
// @Produces("text/html")
// public Response convertTbstoCupsfromInput(@PathParam("t") Double t) throws
// Exception {
// Double cups;
// Double tbs = t;
// cups = (tbs / 16.0);
//
// Double calc[];
// Double calc2[];
// calc = new Double[2];
// calc2 = new Double[2];
// calc[0] = tbs;
// calc[1] = cups;
//
// // Call the method that writes to and reads from the database.
// // Capture the retrieved data in calc2, which is passed to the
// // result string that is returned to the calling client.
// calc2 = accessDB(calc);

// EntityManagerFactory entityManagerFactory;
// entityManagerFactory =
// Persistence.createEntityManagerFactory("FirstDynamicWebProject");
// EntityManager entityManager = entityManagerFactory.createEntityManager();
// List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee
// e", Employee.class).getResultList();
// String allEmployees = "";
// for (Employee employee : employees) {
// allEmployees = allEmployees + employee.getEmpFirstname() +
// employee.getEmpSurname() + "\n";
// }

// String result = "@Produces(\"text/html\") Output: \n\nTbs to Cups
// Output from Database: \n\n" + "Tablespoons = " + calc2[0] + "\n" +
// "Cups = " + calc2[1];
// return Response.status(200).entity(allEmployees).build();
// }

// Write data to and retrieve data from the ObjectDB database
// private Double[] accessDB(Double[] calc) {
// Double[] calc3;
// calc3 = calc;
// Integer[] entity;
// // Open a database connection
// // Create a new database if it doesn't exist yet
// EntityManagerFactory emf =
// Persistence.createEntityManagerFactory("second_attempt_hibernate");
// EntityManager em = emf.createEntityManager();
// try {
// // Write to database:
// // Create entity class and intialize it with data
// Employee employee = new Employee();
// employee.setEmpFirstname("Жопа");
// // Start a transaction
// em.getTransaction().begin();
// // Write data to the database
// em.persist(employee);
// // End the transaction
// em.getTransaction().commit();
// // Read all entries from the database
// em.getTransaction().begin();
// Query query = em.createQuery("SELECT empCity FROM Employee emp");
// @SuppressWarnings("rawtypes")
// List list = query.getResultList();
// @SuppressWarnings("rawtypes")
// Iterator iterator = list.iterator();
// while (iterator.hasNext()) {
// System.out.println("Iterator:" + iterator.next());
// }
// em.getTransaction().commit();
// } catch (Exception e) {
// System.out.println(e);
// } finally {
// try {
// em.close();
// } catch (java.lang.Exception e) {
// System.out.println(e);
// }
// }
// // System.out.println("Values from DB:");
// // System.out.println("#TBSonvert to cups: " + entity[0]);
// // System.out.println("Equalsfollowing #cups: " + entity[1] + "\n");
// return calc3;
// }
// }