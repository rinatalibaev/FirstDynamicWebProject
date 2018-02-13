package ejb;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Employee;
import entity.Psswrd;

@LocalBean
@Stateless
public class PsswrdsEJB {

	@PreDestroy
	public void destruct() {
		em.close();
	}

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	EntityManager em;

	public void savePsswrd(Psswrd psswrd) {
		em.merge(psswrd);
	}

	public void deletePsswrd(Psswrd psswrd) {
		em.remove(psswrd);
	}

	// public List<Psswrd> getAll() {
	// Query query = em.createQuery("SELECT emp FROM Psswrds psswrds",
	// Psswrd.class);
	// List<Psswrd> psswrds = (List<Psswrd>) query.getResultList();
	// return psswrds;
	// }

	public String checkUser(String userName, String password) {
		System.out.println("In checkUser");
		Query query = em.createQuery("SELECT psswrd FROM Psswrd psswrd WHERE login = :userName", Psswrd.class);
		query.setParameter("userName", userName);
		List<Psswrd> psswrds = (List<Psswrd>) query.getResultList();
		if (psswrds.get(0).getPsw().equals(password)) {
			int empID = psswrds.get(0).getEmployee();
			Query query2 = em.createQuery("SELECT emp FROM Employee emp WHERE id = :empID", Employee.class);
			query2.setParameter("empID", empID);
			Employee employee = (Employee) query2.getSingleResult();
			return employee.getEmpSurname() + " " + employee.getEmpFirstname();
		} else {
			return null;
		}
	}

}
