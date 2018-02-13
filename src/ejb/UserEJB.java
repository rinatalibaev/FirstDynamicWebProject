package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Token;
import entity.User;

@Stateless
public class UserEJB {

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	EntityManager em;

	@Inject
	Token token;

	public UserEJB() {

	}

	public List<User> getUsers() {
		Query query = em.createQuery("from User");
		return (List<User>) query.getResultList();
	}

	public Token updateToken() {
		em.persist(token);
		return token;
	}
}
