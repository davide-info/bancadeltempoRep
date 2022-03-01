/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author win
 */
public class PrenotazioneJoinUtenteDto {

    @Override
    public String toString() {
        return "PrenotazioneJoinUtenteDto{" + "prenotazione=" + prenotazione + ", utente=" + utente + '}';
    }
  
    private PrenotazioneDto prenotazione ;
    private UtenteDto utente;

    public PrenotazioneDto getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(PrenotazioneDto prenotazione) {
        this.prenotazione = prenotazione;
    }

    public UtenteDto getUtente() {
        return utente;
    }

    public void setUtente(UtenteDto utente) {
        this.utente = utente;
    }
    public PrenotazioneJoinUtenteDto() {}
     public PrenotazioneJoinUtenteDto(PrenotazioneDto prenotazione, UtenteDto utente) {
         setPrenotazione(prenotazione);
         setUtente(utente);
     }
}

