package it.feira.business.boundary;

import it.feira.business.entity.Utente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Feira
 */
@Stateless
public class UtenteFacade extends AbstractFacade<Utente> {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtenteFacade() {
        super(Utente.class);
    }

    public Utente findByUsrPwd(String nome, String pwd) {
        return em.createNamedQuery("Utente.findByUsrPwd", Utente.class)
                .setParameter("nome", nome)
                .setParameter("password", pwd)
                .getSingleResult();
    }
    
    public Utente findByEmailPwd(String email, String pwd) {
        return em.createNamedQuery("Utente.findByEmailPwd", Utente.class)
                .setParameter("email", email)
                .setParameter("password", pwd)
                .getSingleResult();
    }

    public Utente findByName(String nome) {
        return em.createNamedQuery("Utente.findByName", Utente.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
    
    public Utente findByEmail(String email) {
        return em.createNamedQuery("Utente.findByEmail", Utente.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
