package ejb;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Document;

@DeclareRoles({ "TutorialUser", "AnotherUser" })
@LocalBean
@Stateless
public class DocumentsEJB {

	@Resource
	SessionContext ctx;

	@PreDestroy
	public void destruct() {
		em.close();
	}

	@PersistenceContext(unitName = "ForthDynamicWebProject")
	EntityManager em;

	@RolesAllowed("AnotherUser")
	public void saveDocument(Document document) {
		em.merge(document);
	}

	// @RolesAllowed("TutorialUser")
	@DenyAll
	public void deleteDocument(Document document) {
		if (ctx.isCallerInRole("TutorialUser")) {
			System.out.println("Caller in role");
			em.remove(document);
		} else {
			System.out.println("Caller not in role");
		}
		;

	}

	public List<Document> getAll() {
		Query query = em.createQuery("SELECT doc FROM Document doc", Document.class);
		List<Document> docs = (List<Document>) query.getResultList();
		return docs;
	}

}
