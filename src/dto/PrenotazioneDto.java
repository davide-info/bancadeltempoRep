/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

/**
 *
 * @author win
 */
public class PrenotazioneDto {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idPrenotazione;
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
        final PrenotazioneDto other = (PrenotazioneDto) obj;
        if (this.idPrenotazione != other.idPrenotazione) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrenotazioneDto{" + "idPrenotazione=" + idPrenotazione + ", dataPrenotazione=" + dataPrenotazione + ", oraPrenotazione=" + oraPrenotazione + ", utente=" + utente + '}';
    }
    private int idPrenotazione ;
    private LocalDate dataPrenotazione ;
    private LocalTime oraPrenotazione ;
   private Optional<UtenteDto> utente; 
  public PrenotazioneDto() {}
  
  public PrenotazioneDto(int idPrenotazione, LocalDate dataPrenotazione, LocalTime oraPrenotazione, Optional<UtenteDto> utente) {
      setIdPrenotazione(idPrenotazione);
      setDataPrenotazione(dataPrenotazione);
      setOraPrenotazione(oraPrenotazione);
      setUtente(utente);
  }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public LocalTime getOraPrenotazione() {
        return oraPrenotazione;
    }

    public void setOraPrenotazione(LocalTime oraPrenotazione) {
        this.oraPrenotazione = oraPrenotazione;
    }

    public Optional<UtenteDto> getUtente() {
        return utente;
    }

    public void setUtente(Optional<UtenteDto> utente) {
        this.utente = utente;
    }
    
}
