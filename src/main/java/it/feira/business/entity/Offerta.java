package it.feira.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andrea Feira
 */
@Entity
public class Offerta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double cifra;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOfferta;
    
    //Relations
    @ManyToOne
    private Utente offerente;
    @ManyToOne
    private Asta asta;

    public Offerta() {
    }

    public Offerta(Double cifra, Date dataOfferta) {
        this.cifra = cifra;
        this.dataOfferta = dataOfferta;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCifra() {
        return cifra;
    }

    public void setCifra(Double cifra) {
        this.cifra = cifra;
    }

    public Date getDataOfferta() {
        return dataOfferta;
    }

    public void setDataOfferta(Date dataOfferta) {
        this.dataOfferta = dataOfferta;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Offerta other = (Offerta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.feira.business.entity.Offerta[ id=" + id + " ]";
    }

}
