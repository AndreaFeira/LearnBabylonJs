package it.feira.business.boundary;

import it.feira.business.entity.Articolo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Feira
 */
@Stateless
public class ArticoloFacade extends AbstractFacade<Articolo> {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticoloFacade() {
        super(Articolo.class);
    }

}
