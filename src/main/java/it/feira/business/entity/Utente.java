package it.feira.business.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Feira
 */
@NamedQueries({
    @NamedQuery(name = "Utente.findByUsrPwd",
            query = "select e from Utente e where e.nome= :nome and e.password= :password"),
    @NamedQuery(name = "Utente.findByName",
            query = "select e from Utente e where e.nome like :nome"),
    @NamedQuery(name = "Utente.findByEmail",
            query = "select e from Utente e where e.email like :email"),
    @NamedQuery(name = "Utente.findByEmailPwd",
            query = "select e from Utente e where e.email like :email and e.password= :password")
}
)
@Entity
@XmlRootElement
public class Utente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cognome;
    private String nome;
    private String email;
    private String password;

    //Relations
    @OneToMany
    private List<Articolo> articoli;
    @OneToMany
    private List<Asta> aste;
    @OneToMany
    private List<Offerta> offerte;

    public Utente() {
    }

    public Utente(String cognome, String nome, String email, String password, List<Articolo> articoli, List<Asta> aste, List<Offerta> offerte) {
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.articoli = articoli;
        this.aste = aste;
        this.offerte = offerte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(List<Articolo> articoli) {
        this.articoli = articoli;
    }

    @XmlTransient
    public List<Asta> getAste() {
        return aste;
    }

    public void setAste(List<Asta> aste) {
        this.aste = aste;
    }

    @XmlTransient
    public List<Offerta> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<Offerta> offerte) {
        this.offerte = offerte;
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
