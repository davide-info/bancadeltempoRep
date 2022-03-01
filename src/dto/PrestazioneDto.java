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
public class PrestazioneDto {

    @Override
    public String toString() {
        return "PrestazioneDto{" + "idPrestazione=" + idPrestazione + ", attivita=" + attivita + ", votoPrestazione=" + votoPrestazione + ", feedback=" + feedback + ", dataPrestazione=" + dataPrestazione + '}';
    }
    private int idPrestazione ;
    private Optional<AttivitaDto> attivita;
    private int votoPrestazione ;
    private Optional<String> feedback;
    private LocalDate dataPrestazione;

    public int getIdPrestazione() {
        return idPrestazione;
    }

    public void setIdPrestazione(int idPrestazione) {
        this.idPrestazione = idPrestazione;
    }

    public Optional<AttivitaDto> getAttivita() {
        return attivita;
    }

    public void setAttivita(Optional<AttivitaDto> attivita) {
        this.attivita = attivita;
    }

    public int getVotoPrestazione() {
        return votoPrestazione;
    }

    public void setVotoPrestazione(int votoPrestazione) {
        this.votoPrestazione = votoPrestazione;
    }

    public Optional<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(Optional<String> feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDataPrestazione() {
        return dataPrestazione;
    }

    public void setDataPrestazione(LocalDate dataPrestazione) {
        this.dataPrestazione = dataPrestazione;
    }
    
}
