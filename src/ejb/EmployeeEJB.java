package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Employee;

@LocalBean
@Stateless
public class EmployeeEJB {

	@PersistenceContext
	EntityManager em;

	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

	public void deleteEmployee(Employee employee) {
		em.remove(employee);
	}

	public List<Employee> getAll() {
		Query query = em.createQuery("SELECT emp FROM Employee emp", Employee.class);
		List<Employee> emp = (List<Employee>) query.getResultList();
		return emp;
	}

}
