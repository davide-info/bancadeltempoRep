/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author win
 */
@Entity
public class Prenotazione implements Serializable{

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idPrenotazione;
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
        final Prenotazione other = (Prenotazione) obj;
        if (this.idPrenotazione != other.idPrenotazione) {
            return false;
        }
        return true;
    }
    @Id
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_prenotazione")
    private int idPrenotazione;
    @Column(name="durata_prenotazione")
    private int durataPrenotazione;
 
    
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Utente.class, fetch=FetchType.LAZY)
   
    @JoinColumn(name="fk_utente")
    private Utente utente;  
    @OneToOne
    @JoinColumn(name="fk_prestazione")
   
    private Prestazione prestazione;
    @Column(name="data_prenotazione")
    @Temporal(TemporalType.DATE)
    private Date dataPrenotazione;
    @Column(name="ora_prenotazione")
    @Temporal(TemporalType.TIME)
    private Date oraPrenotazione;

    @Override
    public String toString() {
        return "Prenotazione{" + "idPrenotazione=" + idPrenotazione + ", durataPrenotazione=" + durataPrenotazione + " utente=" + utente + ", prestazione=" + prestazione + ", dataPrenotazione=" + dataPrenotazione + ", oraPrenotazione=" + oraPrenotazione + '}';
    }
    public int getIdPrenotazione() {
        return idPrenotazione;
    }

   public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public int getDurataPrenotazione() {
        return durataPrenotazione;
    }

    public void setDurataPrenotazione(int durataPrenotazione) {
        this.durataPrenotazione = durataPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Prestazione getPrestazione() {
        return prestazione;
    }

    public void setPrestazione(Prestazione prestazione) {
        this.prestazione = Objects.requireNonNull(prestazione);
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = Objects.requireNonNull(dataPrenotazione);
    }

    public Date getOraPrenotazione() {
        return oraPrenotazione;
    }

    public void setOraPrenotazione(Date oraPrenotazione) {
        this.oraPrenotazione = Objects.requireNonNull(oraPrenotazione);
    }
    public Prenotazione() {

    }
    
    
}
  