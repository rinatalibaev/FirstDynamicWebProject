package ejb;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.MailOrder;

@LocalBean
@Stateless
public class MailOrdersEJB {

	@PreDestroy
	public void destruct() {
		em.close();
	}

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	EntityManager em;

	public void saveMailOrder(MailOrder mailOrder) {
		em.merge(mailOrder);
	}

	public void deleteMailOrder(MailOrder mailOrder) {
		em.remove(mailOrder);
	}

	public List<MailOrder> getAll() {
		Query query = em.createQuery("SELECT mailOrder FROM MailOrder mailOrder", MailOrder.class);
		List<MailOrder> mailOrders = (List<MailOrder>) query.getResultList();
		return mailOrders;
	}

}
