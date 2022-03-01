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
public class RichiestaDto {
    private int idRichiesta ;
    private LocalDate dataRichiesta ;
    private Optional<UtenteDto> utente;
   
    private Optional<String> descrizione;

    public Optional<AttivitaDto> getAttivita() {
        return attivita;
    }

    public void setAttivita(Optional<AttivitaDto> attivita) {
        this.attivita = attivita;
    }
    private Optional<AttivitaDto> attivita;

    @Override
    public String toString() {
        return "RichiestaDto{" + "idRichiesta= " + idRichiesta + ", dataRichiesta= " + dataRichiesta + ", utente= " + utente +  ", descrizione= " + descrizione + " attivita = "+ attivita+'}';
    }
    public RichiestaDto() {}

    public int getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public Optional<UtenteDto> getUtente() {
        return utente;
    }

    public void setUtente(Optional<UtenteDto> utente) {
        this.utente = utente;
    }

  
    public Optional<String> getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(Optional<String> descrizione) {
        this.descrizione = descrizione;
    }
    
    
}