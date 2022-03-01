
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
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author win
 */
@Entity
public class Attivita implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_attivita")
     @Access(AccessType.PROPERTY)
     
    private Integer idAttivita ;
  
    @Column(name="nome_attivita", nullable = false, unique = true)
    private String nomeAttivita ;
    @OneToMany(targetEntity = Categoria.class, fetch=FetchType.LAZY)
  
    private Collection<Categoria> categorie;
    @OneToMany(targetEntity = Prestazione.class, fetch=FetchType.LAZY)
  
    private Collection<Prestazione> prestazioni ;
  
    @ManyToOne(cascade = CascadeType.PERSIST , targetEntity=Utente.class, fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "fk_utente")
   
    private Utente utente;
     @OneToOne(optional = true, cascade=CascadeType.PERSIST, targetEntity = SottoCategoria.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_sottocategoria")
    
    private SottoCategoria sottoCategoria;
     @OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, optional = true)
    
     private Richiesta richiesta ;
     public void setRichiesta(Richiesta richiesta) {
         this.richiesta = richiesta;
     }
     @OneToOne(cascade=CascadeType.PERSIST,optional = true, fetch=FetchType.EAGER)
     private  Offerta offerta;
     public void setOfferta(Offerta offerta) {this.offerta=offerta;}
     public Offerta getOfferta() {return offerta;}
     
     public Richiesta getRichiesta() {return richiesta;}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idAttivita;
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
        final Attivita other = (Attivita) obj;
        if (!this.idAttivita.equals(other.idAttivita))
            return false;
        
        return true;
    }

    @Override
    public String toString() {
        return "Attivita{" + "idAttivita=" + idAttivita + ", nomeAttivita=" + nomeAttivita + ", categorie=" + categorie + ", prestazioni=" + prestazioni + ", utente=" + utente + ", sottoCategoria=" + sottoCategoria + '}';
    }
 

   
    
    public boolean  aggiungiCategoria(Categoria categoria) {
     return  categorie.add(categoria);
    }
    public boolean rimuoviCategoria(Categoria categoria) {
        return categorie.remove(categoria);
    }
    public boolean aggiornaCategoria(Categoria vecchiaCategoria, Categoria nuovaCategoria) {
            if(rimuoviCategoria(vecchiaCategoria)) 
                    return aggiungiCategoria(nuovaCategoria);
           return false;
    }
    public boolean aggiungiPrestazioni(Prestazione prestazione) {
        return prestazioni.add(prestazione);
    }
    
    
    
   
   
    public Attivita() {
        categorie = new HashSet<>();
        prestazioni = new HashSet<>();
       //utenti = new HashSet<>();
    }
    public Attivita(String nomeAttivita) {
        this();
        setNomeAttivita(nomeAttivita);
    }
    
    

    public Integer getIdAttivita() {
        return idAttivita;
    }
public void setIdAttivita(Integer idAttivita) {
    this.idAttivita=idAttivita;
}
  

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = Objects.requireNonNull(nomeAttivita);
    }

    public Collection<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(Collection<Categoria> categorie) {
        this.categorie = Objects.requireNonNull(categorie);
    }

    public Collection<Prestazione> getPrestazioni() {
        return prestazioni;
    }

    public void setPrestazioni(Collection<Prestazione> prestazioni) {
        this.prestazioni = Objects.requireNonNull(prestazioni);
    }

    public Utente getUtente() {
        return utente;
    }
   

    public void setUtente(Utente utente) {
        this.utente = Objects.requireNonNull(utente);
    }

    public SottoCategoria getSottoCategoria() {
        return sottoCategoria;
    }

    public void setSottoCategoria(SottoCategoria sottoCategoria) {
        this.sottoCategoria =Objects.requireNonNull(sottoCategoria);
    }
}
