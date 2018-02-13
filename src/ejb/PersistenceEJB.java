package ejb;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class PersistenceEJB {

	@PreDestroy
	public void destruct() {
		em.close();
	}

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}
}
