/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;
import java.util.Optional;

/**
 *
 * @author win
 */
public class OffertaDto {
    private int idOfferta ;
    private Optional<UtenteDto> utente ;
    private Optional<AttivitaDto> attivita;
    private LocalDate dataOfferta;

    @Override
    public String toString() {
        return "OffertaDto{" + "idOfferta=" + idOfferta + ", utente=" + utente + ", attivita=" + attivita + ", dataOfferta=" + dataOfferta + '}';
    }

    public int getIdOfferta() {
        return idOfferta;
    }

    public void setIdOfferta(int idOfferta) {
        this.idOfferta = idOfferta;
    }

    public Optional<UtenteDto> getUtente() {
        return utente;
    }

    public void setUtente(Optional<UtenteDto> utente) {
        this.utente = utente;
    }

    public Optional<AttivitaDto> getAttivita() {
        return attivita;
    }

    public void setAttivita(Optional<AttivitaDto> attivita) {
        this.attivita = attivita;
    }

    public LocalDate getDataOfferta() {
        return dataOfferta;
    }

    public void setDataOfferta(LocalDate dataOfferta) {
        this.dataOfferta = dataOfferta;
    }
    public Object [] getArrayRows() {
      Object [] results = new Object[]{};
      return results;
        }
    
}
