package it.feira.business.boundary;

import it.feira.business.entity.Asta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Feira
 */
@Stateless
public class AstaFacade extends AbstractFacade<Asta> {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AstaFacade() {
        super(Asta.class);
    }

    public List<Asta> auctionInProgress() {
        return em.createNamedQuery("Asta.auctionInProgress", Asta.class).getResultList();
    }

}
