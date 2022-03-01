/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Optional;

/**
 *
 * @author win
 */
public class TelefonoDto {
    private int idTelefono;
    private String numeroDiTelefono ;
    private Optional<UtenteDto> utente ;

    @Override
    public String toString() {
        return "TelefonoDto{" + "idTelefono=" + idTelefono + ", numeroDiTelefono=" + numeroDiTelefono + ", utente=" + utente + '}';
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public Optional<UtenteDto> getUtente() {
        return utente;
    }

    public void setUtente(Optional<UtenteDto> utente) {
        this.utente = utente;
    }
    
    
}
