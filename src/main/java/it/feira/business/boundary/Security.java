package it.feira.business.boundary;

import it.feira.business.entity.Utente;
import it.feira.presentation.SessionData;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andrea Feira
 */
@Stateless
public class Security {

    @Inject
    private UtenteFacade utenteSrv;

    @Inject
    UsersCache usersCache;

    @Inject
    SessionData sessionData;

    public boolean login(String email, String pwd) {
        try {
            Utente u = utenteSrv.findByEmailPwd(email, pwd);
            usersCache.addUser(u);
            return true;
        } catch (EJBException ex) {
            return false;
        }

    }

    public String logout() {
        return logout(utenteSrv.findByEmail(sessionData.getLoggedUser()));
    }

    public String logout(Utente u) {
        usersCache.removeUser(u);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.getSession().invalidate();
        return "/index.jsf?faces-redirect=true";
    }
}
