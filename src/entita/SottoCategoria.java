/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entita;

import java.io.Serializable;
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

/**
 *
 * @author win
 */
@Entity
public class SottoCategoria implements Serializable{

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idSottoCategoria;
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
        final SottoCategoria other = (SottoCategoria) obj;
        if (this.idSottoCategoria != other.idSottoCategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SottoCategoria{" + "idSottoCategoria=" + idSottoCategoria + ", nomeSottoCategoria=" + nomeSottoCategoria + ", categoria=" + categoria + ", attivita=" + attivita + '}';
    }
    @Column(name="id_sottocategoria")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idSottoCategoria;
    @Column(name="nome_sotto_categoria")
    private String nomeSottoCategoria;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Categoria.class, fetch=FetchType.LAZY)
    @JoinColumn(name="fk_categoria")
   
  
    
    private Categoria categoria;
    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = Attivita.class, fetch=FetchType.LAZY)
    
    @JoinColumn(name="fk_attivita")
    
    private Attivita attivita;

    public int getIdSottoCategoria() {
        return idSottoCategoria;
    }

   public void setIdSottoCategoria(int idSottoCategoria) {
        this.idSottoCategoria = idSottoCategoria;
    }

    public String getNomeSottoCategoria() {
        return nomeSottoCategoria;
    }

    public void setNomeSottoCategoria(String nomeSottoCategoria) {
        this.nomeSottoCategoria = Objects.requireNonNull(nomeSottoCategoria);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = Objects.requireNonNull(categoria);
    }

    public Attivita getAttivita() {
        return attivita;
    }

    public void setAttivita(Attivita attivita) {
        this.attivita = Objects.requireNonNull(attivita);
    }
    public SottoCategoria() {}
    
}
