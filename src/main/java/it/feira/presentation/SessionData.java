package it.feira.presentation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named(value = "userSession")
@SessionScoped
public class SessionData implements Serializable{
    
    private String loggedUser;

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
    
}
