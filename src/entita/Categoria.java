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

/**
 *
 * @author win
 */
@Entity
public class Categoria implements Serializable{

    

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     *
     * @param nomeCategoria
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = Objects.requireNonNull(nomeCategoria);
    }
   
    public Attivita getAttivita() {
        return attivita;
    }

    public void setAttivita(Attivita attivita) {
        this.attivita = Objects.requireNonNull(attivita);
    }

    public Collection<SottoCategoria> getSottocategorie() {
        return sottocategorie;
    }

    public void setSottocategorie(Collection<SottoCategoria> sottocategorie) {
        this.sottocategorie = Objects.requireNonNull(sottocategorie);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Categoria other = (Categoria) obj;
        if (!this.idCategoria.equals(other.idCategoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + ", attivita=" + attivita + ", sottocategorie=" + sottocategorie + '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    @Column(name="nome_categoria")
    private String nomeCategoria;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Attivita.class, fetch=FetchType.LAZY )
    @JoinColumn(name="fk_attivita")
   
    private Attivita attivita;
    @OneToMany(targetEntity = SottoCategoria.class, cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy = "categoria")
  
    private Collection<SottoCategoria> sottocategorie;
    public Categoria() {
        sottocategorie=new HashSet<>();
    }
    public Integer getIdCategoria() {
        return idCategoria;
    }
    
    
    public Categoria(String nomeCategoria) {
        this();
        setNomeCategoria(nomeCategoria);
    }
    
}
