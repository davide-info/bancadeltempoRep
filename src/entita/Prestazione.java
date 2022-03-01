/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;


import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author win
 */
@Entity
public class Prestazione implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idPrestazione;
        return hash;
    }

    @Override
    public String toString() {
        return "Prestazione{" + "idPrestazione=" + idPrestazione + ", dataPrestazione=" + dataPrestazione + ", votoPrestazione=" + votoPrestazione + ", feedback=" + feedback + ", utente=" + utente + ", attivita=" + attivita + " prenotazione = "+ prenotazione+'}';
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
        final Prestazione other = (Prestazione) obj;
        if (this.idPrestazione != other.idPrestazione) {
            return false;
        }
        return true;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPrestazione ;
    @Column(name="data_prestazione")
    @Temporal(TemporalType.DATE)
    private Date dataPrestazione;
    @Column(name="voto_prestazione")
    private int votoPrestazione ;
    private String feedback;
  @OneToOne( mappedBy = "prestazione")
    
   
   
    private Prenotazione prenotazione;
    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione =prenotazione;
    }

    public  Prenotazione getPrenotazione() {
        return prenotazione; 
    }
    
    
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Utente.class, fetch=FetchType.LAZY)
   
    
    @JoinColumn(name="fk_utente")
    private Utente utente;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Attivita.class, fetch=FetchType.EAGER)
    @JoinColumn(name="fk_attivita")
   
    private Attivita attivita;

    public int getIdPrestazione() {
        return idPrestazione;
    }

  /*  public void setIdPrestazione(int idPrestazione) {
        this.idPrestazione = idPrestazione;
    }*/

    public Date getDataPrestazione() {
        return dataPrestazione;
    }

    public void setDataPrestazione(Date dataPrestazione) {
        this.dataPrestazione = Objects.requireNonNull(dataPrestazione);
    }

    public int getVotoPrestazione() {
        return votoPrestazione;
    }

    public void setVotoPrestazione(int votoPrestazione) {
        this.votoPrestazione = votoPrestazione;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = Objects.requireNonNull(utente);
    }

    public Attivita getAttivita() {
        return attivita;
    }

    public void setAttivita(Attivita attivita) {
        this.attivita = Objects.requireNonNull(attivita);
    }
    public Prestazione() {}
    
}

