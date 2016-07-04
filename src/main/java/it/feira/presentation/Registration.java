package it.feira.presentation;

import it.feira.business.boundary.UtenteFacade;
import it.feira.business.entity.Utente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named(value = "registration")
@ViewScoped
public class Registration implements Serializable {

    private Utente utente;

    @Inject
    private UtenteFacade utenteSrv;

    @PostConstruct
    public void init() {
        utente = new Utente();
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String onRegistation() {
        try {
            utenteSrv.create(utente);
            return "/index.tss?faces-redirect=true";
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage("nick", new FacesMessage("Errore nel salvataggio dei dati"));
            return null;
        }
    }
}
