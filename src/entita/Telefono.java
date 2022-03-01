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

/**
 *
 * @author win
 */
@Entity
public class Telefono implements Serializable{

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idTelefono;
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
        final Telefono other = (Telefono) obj;
        return this.idTelefono == other.idTelefono;
    }

    @Override
    public String toString() {
        return "Telefono{" + "idTelefono=" + idTelefono + ", numeroTelefono=" + numeroTelefono + ", utente=" + utente + '}';
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_telefono")
    private int idTelefono;
    @Column(name="numero_telefono")
    private String numeroTelefono;
   
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Utente.class, fetch=FetchType.LAZY)
    @JoinColumn(name="fk_utente")
    private Utente utente;

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = Objects.requireNonNull(numeroTelefono);
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = Objects.requireNonNull(utente);
    }
    public Telefono() {}
}
