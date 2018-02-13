package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Examp;
import entity.User;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuthenticateEJB {

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	EntityManager em;

	@Inject
	UserEJB userEJB;

	Examp examp = new Examp();

	public User checkUser(String userName, String password) {
		examp.setName("buk");
		em.persist(examp);
		List<User> users = userEJB.getUsers();

		// Попытаться использовать итератор. Позже.
		// users.iterator().next().getName();
		for (User user : users) {
			if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
				user.setToken(userEJB.updateToken());
				em.merge(user);
				return user;
			}
		}
		return null;
	}
}
