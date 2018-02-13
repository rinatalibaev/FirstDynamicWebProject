package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import entity.Token;

@LocalBean
@Stateless
public class TokenEJB {

	@Inject
	PersistenceEJB persistenceEJB;

	public List<Token> getTokens() {
		Query query = persistenceEJB.getEntityManager().createQuery("SELECT t from Token token", Token.class);
		return (List<Token>) query.getResultList();
	}

	// public Token getTokenById(int tokenId) {
	// Query query = persistenceEJB.getEntityManager().createQuery("SELECT t
	// from Token token WHERE token.id = :tokenId");
	// return (Token) query.getSingleResult();
	// }

}
