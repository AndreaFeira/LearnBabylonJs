package it.feira.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Feira
 */
@NamedQueries({
    @NamedQuery(name = "Asta.auctionInProgress",
            query = "select e from Asta e where e.dataScadenza > CURRENT_TIMESTAMP")
}
)
@Entity
@XmlRootElement
public class Asta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreazione;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataScadenza;

    //Relations
    @ManyToOne
    private Utente owner;
    @OneToOne(cascade = CascadeType.ALL)
    private Articolo art;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Offerta> offerte;

    public Asta() {
        this.dataCreazione = new Date();
    }

    public Asta(Date dataCreazione, Date dataScadenza, Utente owner, Articolo art, List<Offerta> offerte) {
        this.dataCreazione = new Date();
        this.dataScadenza = dataScadenza;
        this.owner = owner;
        this.art = art;
        this.offerte = offerte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getOwner() {
        return owner;
    }

    public void setOwner(Utente owner) {
        this.owner = owner;
    }

    public Articolo getArt() {
        return art;
    }

    public void setArt(Articolo art) {
        this.art = art;
    }

    @XmlTransient
    public List<Offerta> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<Offerta> offerte) {
        this.offerte = offerte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asta other = (Asta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articolo in asta: " + art.getNome();
    }

}
