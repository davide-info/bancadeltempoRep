
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;

/**
 *
 * @author win
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity

public class Richiesta implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idRichiesta;
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
        final Richiesta other = (Richiesta) obj;
        if (this.idRichiesta != other.idRichiesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Richiesta{" + "idRichiesta=" + idRichiesta + ", dataRichiesta=" + dataRichiesta + ", descrizione=" + descrizione + ", zona=" + zona + ", utente=" + utente + '}';
    }
    @Id
    @GeneratedValue
    @Column(name="id_richiesta")
    private int idRichiesta;
    @Column(name="data_richiesta")
    @Temporal(TemporalType.DATE)
    private Date dataRichiesta;
    private String descrizione;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_attivita" )
    private Attivita attivita ;
    public void setAttivita(Attivita attivita) {
        this.attivita=attivita;
    }
    public Attivita getAttivita(){return attivita;}
    
   
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = ZonaDiRiferimento.class, fetch=FetchType.LAZY)
    @JoinColumn(name="fk_zona")
   
    private ZonaDiRiferimento zona;
  
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Utente.class, fetch=FetchType.LAZY)
    @JoinColumn(name="fk_utente")
    private Utente utente;

    public int getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = Objects.requireNonNull(dataRichiesta);
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = Objects.requireNonNull(descrizione);
    }

    public ZonaDiRiferimento getZona() {
        return zona;
    }

    public void setZona(ZonaDiRiferimento zona) {
        this.zona = Objects.requireNonNull(zona);
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = Objects.requireNonNull(utente);
    }
}
