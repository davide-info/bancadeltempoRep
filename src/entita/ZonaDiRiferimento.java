
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author win
 */
@Entity(name="zonadiriferimento")
public class ZonaDiRiferimento implements Serializable {
    @Column(name="id_zona_di_riferimento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZonaDiRiferimento;
    private String citta;
    private String via;
    private String luogo;
    @OneToMany(targetEntity = Offerta.class, fetch=FetchType.LAZY, mappedBy = "zona")
   
    private Collection<Offerta> offerte;
    @OneToMany(targetEntity = Richiesta.class, fetch=FetchType.LAZY, mappedBy = "zona")
    
    private Collection<Richiesta> richieste;
    @OneToMany(targetEntity = Utente.class,fetch=FetchType.LAZY, mappedBy="zona")
   
    private Collection<Utente> utenti;

    @Override
    public String toString() {
        return "ZonaDiRiferimento{" + "idZonaDiRiferimento=" + idZonaDiRiferimento + ", citta=" + citta + ", via=" + via + ", luogo=" + luogo + ", offerte=" + offerte + ", richieste=" + richieste + ", utenti=" + utenti + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idZonaDiRiferimento;
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
        final ZonaDiRiferimento other = (ZonaDiRiferimento) obj;
        if (this.idZonaDiRiferimento != other.idZonaDiRiferimento) {
            return false;
        }
        return true;
    }

    public int getIdZonaDiRiferimento() {
        return idZonaDiRiferimento;
    }

   public void setIdZonaDiRiferimento(int idZonaDiRiferimento) {
        this.idZonaDiRiferimento = idZonaDiRiferimento;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = Objects.requireNonNull(citta);
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = Objects.requireNonNull(via);
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo =Objects.requireNonNull(luogo);
    }

    public Collection<Offerta> getOfferte() {
        return offerte;
    }

    public void setOfferte(Collection<Offerta> offerte) {
        this.offerte = Objects.requireNonNull(offerte);
    }

    public Collection<Richiesta> getRichieste() {
        return richieste;
    }

    public void setRichieste(Collection<Richiesta> richieste) {
        this.richieste = Objects.requireNonNull(richieste);
    }

    public Collection<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Collection<Utente> utenti) {
        this.utenti = Objects.requireNonNull(utenti);
    }
    
    public ZonaDiRiferimento() {
        offerte=new HashSet<>();
        richieste=new HashSet<>();
        utenti=new HashSet<>();
    }
    
}
