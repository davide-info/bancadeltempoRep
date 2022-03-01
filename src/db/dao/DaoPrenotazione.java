/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.PrenotazioneDto;
import dto.PrenotazioneJoinUtenteDto;
import dto.UtenteDto;
import entita.Prenotazione;
import entita.Utente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author win
 */
public class DaoPrenotazione {
    private Session session ;
    public DaoPrenotazione() {}
    public DaoPrenotazione(Session session) {
        setSession(session);
    }
    
    public void setSession(Session session) {this.session=Objects.requireNonNull(session);}
    
    public void aggiungiPrenotazione(Prenotazione p) {
        session.saveOrUpdate(p);
        
        
    }
    private UtenteDto convertFromUtenteToUtenteDto(Utente utente) {
        UtenteDto risultato = new UtenteDto();
        risultato.setNome(utente.getNome());
        risultato.setCognome(utente.getCognome());
        risultato.setPassword(Optional.of(utente.getPassword()));
        risultato.setEmail(utente.getIndirizzoEmail());
        risultato.setSaldoOre(utente.getSaldoIniziale());
       
        
        return risultato;
    
    }
    private static LocalDate convertFromDateToLocalDate(Date date) {
        
        return new java.sql.Date(date.getTime()).toLocalDate();
    
    }
    private static LocalTime convertFromDateToLocalDateTime(Date date) {
       return  new java.sql.Time(date.getTime()).toLocalTime();
        
    }
    
    private PrenotazioneDto convertFromPrenotazioneToPrenotazioneDto(Prenotazione prenotazione) {
    
      PrenotazioneDto prenotazioneDto=new PrenotazioneDto();
      int idPrenotazione = prenotazione.getIdPrenotazione();
      Optional<UtenteDto> optionalUtente=Optional.empty();
     Date dataPrenotazione1 =  prenotazione.getDataPrenotazione();
     Date oraPrenotazione1= prenotazione.getOraPrenotazione();
     if(dataPrenotazione1!=null && oraPrenotazione1!=null) {
        
            LocalDate dataPrenotazione2 = convertFromDateToLocalDate(dataPrenotazione1);
            LocalTime oraPrenotazione2 =convertFromDateToLocalDateTime(oraPrenotazione1);
       
            Utente utente = prenotazione.getUtente();
           // System.out.println("utente " + utente);
            if(utente!=null){
              
            UtenteDto utenteDto =convertFromUtenteToUtenteDto(utente);
           //System.out.println(utenteDto);
            if(utenteDto!=null)
                optionalUtente=Optional.of(utenteDto);
            
            }
              
               prenotazioneDto.setDataPrenotazione(dataPrenotazione2);
               prenotazioneDto.setOraPrenotazione(oraPrenotazione2);
            
            }
            
            prenotazioneDto.setIdPrenotazione(idPrenotazione);
          prenotazioneDto.setUtente(optionalUtente);
         
           return prenotazioneDto;
    
    }
    
    public List<PrenotazioneDto> getPrenotazioni() {
        List<PrenotazioneDto> prenotazioni = new ArrayList<>();
        Query<Prenotazione> query = session.createQuery("from Prenotazione as p" , Prenotazione.class);
        List<Prenotazione> queryPrenotazioni = query.list();
        for(Prenotazione prenotazione:queryPrenotazioni) {
       PrenotazioneDto prenotazioneDto = convertFromPrenotazioneToPrenotazioneDto(prenotazione);
            prenotazioni.add(prenotazioneDto);
        
        }
        
        return prenotazioni ;
    }
    public List<PrenotazioneJoinUtenteDto> getPrenotazioniUtente() {
        List<PrenotazioneJoinUtenteDto> prenotazioni = new ArrayList<>();
        Query<Tuple> query = session.createQuery("select p,u from Prenotazione as p inner join p.utente as u ",Tuple.class);
        List<Tuple> prenotazioniTuple = query.list();
        for(Tuple tuple: prenotazioniTuple) {
           Prenotazione prenotazione = tuple.get(0, Prenotazione.class);
           Utente utente = tuple.get(1, Utente.class);
           PrenotazioneJoinUtenteDto join = new PrenotazioneJoinUtenteDto(convertFromPrenotazioneToPrenotazioneDto(prenotazione),convertFromUtenteToUtenteDto(utente));
           prenotazioni.add(join);
            
        }
        
        return prenotazioni;
        
    
    }

    public void aggiornaPrenotazione(Prenotazione p) {
       session.merge(p);
    }
    public void cancellaPrenotazione(Prenotazione p) {
    session.delete(p);
    }

    public Optional<Prenotazione> trovaPrenotazioneConId(int idPrenotazione) {
        Optional<Prenotazione> prenotazioneOpt = Optional.empty();
       final String hql = "select p from Prenotazione as p where p.idPrenotazione=:id";
       //To change body of generated methods, choose Tools | Templates.
       Query<Prenotazione> queryPrenotazione = session.createQuery(hql, Prenotazione.class);
       queryPrenotazione.setParameter("id",idPrenotazione);
       List<Prenotazione> listaPrenotazioni = queryPrenotazione.list();
       if(listaPrenotazioni.size() == 1) {
           prenotazioneOpt=Optional.of(queryPrenotazione.getSingleResult());
       }
       
       return prenotazioneOpt;
    }
}
