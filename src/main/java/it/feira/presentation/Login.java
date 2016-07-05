package it.feira.presentation;

import it.feira.business.boundary.Security;
import it.feira.business.entity.Utente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable {

    @Inject
    Security security;

    @Inject
    SessionData sessionData;

    private Utente usr;

    @PostConstruct
    public void init() {
        usr = new Utente();
    }

    public Utente getUsr() {
        return usr;
    }

    public void setUsr(Utente usr) {
        this.usr = usr;
    }

    public String onRegistration() {

        boolean login = security.login(usr.getEmail(), usr.getPassword());

        if (login) {
            sessionData.setLoggedUser(usr.getEmail());
            return "/index.tss?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage("Login errata", new FacesMessage("Login errata"));
            return "";
        }
    }
    
//    public String onLogout(){
//        
//    }

}
