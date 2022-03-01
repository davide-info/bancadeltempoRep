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
public class ZonaDiRiferimentoDto {
    private int idZonaRiferimento;
    private Optional<UtenteDto> utente;
    private String citta ;
    private String via ;

    @Override
    public String toString() {
        return "ZonaDiRiferimentoDto{" + "idZonaRiferimento=" + idZonaRiferimento + ", utente=" + utente + ", citta=" + citta + ", via=" + via + '}';
    }

    public int getIdZonaRiferimento() {
        return idZonaRiferimento;
    }

    public void setIdZonaRiferimento(int idZonaRiferimento) {
        this.idZonaRiferimento = idZonaRiferimento;
    }

    public Optional<UtenteDto> getUtente() {
        return utente;
    }

    public void setUtente(Optional<UtenteDto> utente) {
        this.utente = utente;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
    
    
}
