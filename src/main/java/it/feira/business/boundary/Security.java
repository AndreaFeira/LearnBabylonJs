package it.feira.business.boundary;

import it.feira.business.entity.Utente;
import it.feira.presentation.SessionData;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;

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

    public boolean login(String usr, String pwd) {
        try {
            Utente u = utenteSrv.findByUsrPwd(usr, pwd);
            usersCache.addUser(u);
            return true;
        } catch (EJBException ex) {
            return false;
        }

    }

    public void logout() {
        logout(utenteSrv.findByName(sessionData.getLoggedUser()));
    }

    public void logout(Utente u) {
        usersCache.removeUser(u);
    }
}
