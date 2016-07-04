package it.feira.business.boundary;

import it.feira.business.entity.Offerta;
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

}
