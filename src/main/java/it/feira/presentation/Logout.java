package it.feira.presentation;

import it.feira.business.boundary.Security;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named(value = "logout")
@RequestScoped
public class Logout implements Serializable {

    @Inject
    Security security;

    public String onLogout() {
        security.logout();
        return "/index.tss?faces-redirect=true";
    }

}
