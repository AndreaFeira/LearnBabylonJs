package it.feira.business.boundary;

import it.feira.business.entity.Utente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named()
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class UsersCache {

    private Map<String, Utente> users = new ConcurrentHashMap<>();

    public void addUser(Utente u) {
        users.put(u.getNome(), u);
    }

    public void removeUser(Utente u) {
        users.remove(u.getNome());
    }

    public Collection<Utente> loggedUsers() {
        return users.values();
    }

    public ArrayList<Utente> loggedUserArrayList() {
        return new ArrayList<>(users.values());
    }

}
