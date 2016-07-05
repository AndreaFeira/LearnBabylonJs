package it.feira.business.boundary;

import it.feira.business.entity.Asta;
import it.feira.business.entity.Offerta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Feira
 */
@Stateless
public class OffertaFacade extends AbstractFacade<Offerta> {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OffertaFacade() {
        super(Offerta.class);
    }

    public List<Offerta> findByAsta(Asta a) {
        return em.createQuery("select e from Offerta e where e.asta= :asta", Offerta.class)
                .setParameter("asta", a)
                .getResultList();
    }

}
