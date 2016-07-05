package it.feira.presentation;

import it.feira.business.boundary.AstaFacade;
import it.feira.business.entity.Asta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named(value = "index")
@RequestScoped
public class Index {

    private List<Asta> asteInCorso;

    @Inject
    AstaFacade astaSrv;

    public List<Asta> getAsteInCorso() {
        return asteInCorso;
    }

    public void setAsteInCorso(List<Asta> asteInCorso) {
        this.asteInCorso = asteInCorso;
    }

    @PostConstruct
    public void initAste() {
        asteInCorso = astaSrv.auctionInProgress();
    }

}
