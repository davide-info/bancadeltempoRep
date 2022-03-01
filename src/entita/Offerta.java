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
public class Offerta implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idOfferta;
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
        if (this.idOfferta != other.idOfferta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Offerta{" + "idOfferta=" + idOfferta + ", dataOfferta=" + dataOfferta + ", utente=" + utente + ", zona=" + zona + '}';
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_offerta")
    
    private int idOfferta;
    @Column(name="data_offerta")
    @Temporal(TemporalType.DATE)
    private Date dataOfferta;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Utente.class)
    @JoinColumn(name = "fk_utente")
   
    private Utente utente;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = ZonaDiRiferimento.class)
    @JoinColumn(name="zona_fk")
   
    private ZonaDiRiferimento zona ;

     @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Attivita.class)
     @JoinColumn(name="fk_attivita")
    private Attivita attivita ;
    public void setAttivita(Attivita attivita) {
        this.attivita=attivita;
    }
    public Attivita getAttivita(){return attivita;}
    
    
    public int getIdOfferta() {
        return idOfferta;
    }

    public void setIdOfferta(int idOfferta) {
        this.idOfferta = idOfferta;
    }

    public Date getDataOfferta() {
        return dataOfferta;
    }

    public void setDataOfferta(Date dataOfferta) {
        this.dataOfferta = Objects.requireNonNull(dataOfferta);
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = Objects.requireNonNull(utente);
    }

    public ZonaDiRiferimento getZona() {
        return zona;
    }

    public void setZona(ZonaDiRiferimento zona) {
        this.zona = Objects.requireNonNull(zona);
    }
    public Offerta() {}
    
    
}
