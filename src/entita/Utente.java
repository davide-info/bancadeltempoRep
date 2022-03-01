
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;


/**
 *
 * @author win
 */
@Entity
public class Utente implements Serializable {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome);
        
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = Objects.requireNonNull(cognome);
    }

    /**
     * @return the indirizzoEmail
     */
    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    /**
     * @param indirizzoEmail the indirizzoEmail to set
     */
    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = Objects.requireNonNull(indirizzoEmail);
    }

    /**
     * @return the saldoIniziale
     */
    public int getSaldoIniziale() {
        return saldoIniziale;
    }

    /**
     * @param saldoIniziale the saldoIniziale to set
     */
    public void setSaldoIniziale(int saldoIniziale) {
        this.saldoIniziale = saldoIniziale;
    }

    /**
     * @return the telefoni
     */

    public Collection<Telefono> getTelefoni() {
        return telefoni;
    }

    /**
     * @param telefoni the telefoni to set
     */
    public void setTelefoni(Collection<Telefono> telefoni) {
        this.telefoni = Objects.requireNonNull(telefoni);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.indirizzoEmail);
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
        final Utente other = (Utente) obj;
        if (!this.indirizzoEmail.equals(other.indirizzoEmail)) {
            return false;
        }
        return true;
    }

   

    /**
     * @return the richieste
     */
 
    public Collection<Richiesta> getRichieste() {
        return richieste;
    }

    /**
     * @param richieste the richieste to set
     */
    public void setRichieste(Collection<Richiesta> richieste) {
        this.richieste = Objects.requireNonNull(richieste);
    }

    /**
     * @return the offerte
     */

    public Collection<Offerta> getOfferte() {
        return offerte;
    }

    /**
     * @param offerte the offerte to set
     */
    public void setOfferte(Collection<Offerta> offerte) {
        this.offerte = Objects.requireNonNull(offerte);
    }

    /**
     * @return the attivita
     */

    public Collection<Attivita> getAttivita() {
        return attivita;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", indirizzoEmail=" + indirizzoEmail + ", saldoIniziale=" + saldoIniziale +  ", zona=" + zona + '}';
    }
    private static String toStringCollection(Collection<Richiesta> richieste) {
        StringBuilder sb = new StringBuilder();
        for(Richiesta r:richieste) {
            sb.append(r.getIdRichiesta());
        }
        
        return sb.toString();
    }
    

    /**
     * @param attivita the attivita to set
     */
    public void setAttivita(Collection<Attivita> attivita) {
        this.attivita = Objects.requireNonNull(attivita);
    }
    /**
     * @return the prenotazioni
     */

    public Collection<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    /**
     * @param prenotazioni the prenotazioni to set
     */
    public void setPrenotazioni(Collection<Prenotazione> prenotazioni) {
        this.prenotazioni = Objects.requireNonNull(prenotazioni);
    }

    /**
     * @return the prestazioni
     */

    public Collection<Prestazione> getPrestazioni() {
        return prestazioni;
    }

    /**
     * @param prestazioni the prestazioni to set
     */
    public void setPrestazioni(Collection<Prestazione> prestazioni) {
        this.prestazioni = Objects.requireNonNull(prestazioni);
    }

    /**
     * @return the zona
     */
    public ZonaDiRiferimento getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(ZonaDiRiferimento zona) {
        this.zona = Objects.requireNonNull(zona);
    }
    private String nome ;
    private String cognome ;
    
    private String password;
    
   
    
    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password);
    }
    public String getPassword() {return password;}
    
    @Id
    @Column(name="indirizzo_email")
    private String indirizzoEmail;
    @Column(name="saldo_iniziale")
    private int saldoIniziale ;
    @OneToMany(targetEntity = Telefono.class, fetch=FetchType.LAZY, mappedBy = "utente")
     
    private Collection<Telefono> telefoni ;
    @OneToMany(targetEntity = Richiesta.class, fetch=FetchType.LAZY, mappedBy = "utente")
     
    private Collection<Richiesta> richieste ;
    @OneToMany(targetEntity = Offerta.class, fetch=FetchType.LAZY, mappedBy = "utente")
     
    private Collection<Offerta> offerte ;
    @OneToMany(targetEntity = Attivita.class,mappedBy = "utente", fetch=FetchType.LAZY)
     @Fetch(org.hibernate.annotations.FetchMode.SELECT)
    
    private Collection<Attivita> attivita ;
   
    @OneToMany(targetEntity = Prenotazione.class, mappedBy="utente", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
   
    private Collection<Prenotazione> prenotazioni;
    @OneToMany(targetEntity = Prestazione.class, mappedBy = "utente", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    
    private Collection<Prestazione> prestazioni ;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = ZonaDiRiferimento.class, fetch = FetchType.LAZY)
    @JoinColumn(name="fk_zona")
    
    private ZonaDiRiferimento zona ;
    public Utente() {
        telefoni = new HashSet<>();
        richieste = new HashSet<>();
        offerte = new HashSet<>();
        attivita = new HashSet<>();
        prenotazioni = new HashSet<>();
        prestazioni = new HashSet<>();
        
    }
    public boolean aggiungiAttivita(Attivita attivita) {
        return this.attivita.add(attivita);
    }
    public boolean aggiungiPrestazioni(Prestazione prestazione) {
        return prestazioni.add(prestazione);
    }
    public boolean aggiungiOfferte(Offerta offerta) {
        return offerte.add(offerta);
    }
    public boolean aggiungiRichiesta(Richiesta richiesta) {
        return richieste.add(richiesta);
    }
    public boolean agggiungiPrenotazione(Prenotazione prenotazione) {
            return prenotazioni.add(prenotazione);
    }
}
