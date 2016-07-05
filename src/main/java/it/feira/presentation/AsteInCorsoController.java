package it.feira.presentation;

import it.feira.business.boundary.OffertaFacade;
import it.feira.business.entity.Asta;
import it.feira.business.entity.Offerta;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrea Feira
 */
@Named(value = "astInProgress")
@RequestScoped
public class AsteInCorsoController {

    private Offerta bestOfferta;

    @Inject
    OffertaFacade bidSrv;

    @PostConstruct
    public void initBestOfferta() {
        bestOfferta = new Offerta();
    }

    public Offerta getBestOfferta() {
        return bestOfferta;
    }

    public void setBestOfferta(Offerta bestOfferta) {
        this.bestOfferta = bestOfferta;
    }

    public void getBestBid(Asta a) {

        List<Offerta> offerte = bidSrv.findByAsta(a);
        Collections.sort(offerte, new Comparator<Offerta>() {
            @Override
            public int compare(Offerta o1, Offerta o2) {
                return o1.getCifra().compareTo(o2.getCifra());
            }
        });

        if (offerte.size() > 0) {
            bestOfferta = offerte.get(0);
        }
    }
}
