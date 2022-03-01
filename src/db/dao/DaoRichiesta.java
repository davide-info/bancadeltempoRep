/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.AttivitaDto;
import dto.RichiestaDto;
import dto.UtenteDto;
import entita.Attivita;
import entita.Richiesta;
import entita.Utente;
import java.time.LocalDate;
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
public class DaoRichiesta {
    private Session session;
    public DaoRichiesta() {
    }
    public DaoRichiesta(Session session) {
            setSession(session);
    }
    public void setSession(Session session) {
        this.session=Objects.requireNonNull(session);
    }
    public void aggiungiRichiesta(Richiesta r) {
        session.saveOrUpdate(r);
    }
    public List<RichiestaDto> getRichiesteUtenti() {
        final String query = "select r,u,r.attivita from Richiesta  as r inner join r.utente as u ";
       List<RichiestaDto> richieste = new ArrayList<>(); 
       Query<Tuple> queryTuple = session.createQuery(query, Tuple.class);
       Optional<UtenteDto> optionalUtenteDto=Optional.empty();
           Optional<AttivitaDto> optionalAttivitaDto = Optional.empty();
           List<Tuple> tuples = queryTuple.list();
        //   System.out.println("DIMENSIONE TUPLES "+tuples.size());
     
       for(Tuple tuple: tuples) {
          
           Richiesta richiesta  = tuple.get(0, Richiesta.class);
           RichiestaDto richiestaDto = convertFromRchiestaToRichiestaDto(richiesta);
           if(richiesta.getUtente()!=null) {
           UtenteDto utenteDto = convertFromUtenteToUtenteDto(richiesta.getUtente());
            if(utenteDto!=null){
               optionalUtenteDto=Optional.of(utenteDto);
              
               
           }
           }
           Attivita attivita=tuple.get(2, Attivita.class);
           //System.out.println("Attivita richiesta " + attivita);
                   
           if(attivita!=null) {
           AttivitaDto attivitaDto=convertFromAttivitaToAttivitaDto(attivita);
           optionalAttivitaDto=Optional.of(attivitaDto);
           
           }
       
         
          
           
           
       
            richiestaDto.setUtente(optionalUtenteDto);
            richiestaDto.setAttivita(optionalAttivitaDto);
              
            richieste.add(richiestaDto);
       }
      
       return richieste;
    }

    private RichiestaDto convertFromRchiestaToRichiestaDto(Richiesta richiesta) {
        
     RichiestaDto richiestaDto = new RichiestaDto();
     Date dataRichiesta1 = richiesta.getDataRichiesta();
        Optional<String> descrizioneOptional= Optional.empty();
     Optional<UtenteDto> optionalUtente = Optional.empty();
     Optional<AttivitaDto> optionalAttivitaDto = Optional.empty();
     
     if(dataRichiesta1!=null) {
     LocalDate dataRichiesta = new java.sql.Date(dataRichiesta1.getTime()).toLocalDate();
     int idRichiesta = richiesta.getIdRichiesta();
     richiestaDto.setIdRichiesta(idRichiesta);
     richiestaDto.setDataRichiesta(dataRichiesta);
     Attivita attivita = richiesta.getAttivita();
  
     
     if(attivita!=null) {
        
       
         AttivitaDto attivitaDto = convertFromAttivitaToAttivitaDto(attivita);
        optionalAttivitaDto= Optional.of(attivitaDto);
     }
     
     if(richiesta.getDescrizione()!=null)
         descrizioneOptional=Optional.of(richiesta.getDescrizione());
     if(richiesta.getUtente()!=null) {
         UtenteDto utenteDto = convertFromUtenteToUtenteDto(richiesta.getUtente());
         optionalUtente=Optional.of(utenteDto);
     }
      
     
     }
    richiestaDto.setUtente(optionalUtente);
    richiestaDto.setAttivita(optionalAttivitaDto);
     
     return richiestaDto;
    }
    private UtenteDto convertFromUtenteToUtenteDto(Utente utente) {
      UtenteDto utenteDto=new UtenteDto();
      utenteDto.setCognome(utente.getCognome());
      utenteDto.setNome(utente.getNome());
      utenteDto.setPassword(Optional.of(utente.getPassword()));
       utenteDto.setEmail(utente.getIndirizzoEmail());
       utenteDto.setSaldoOre(utente.getSaldoIniziale());
      
      return utenteDto;
    }

    private AttivitaDto convertFromAttivitaToAttivitaDto(Attivita attivita) {
       AttivitaDto attivitaDto=new AttivitaDto();
       attivitaDto.setIdAttivita(attivita.getIdAttivita());
       attivitaDto.setNomeAttivita(attivita.getNomeAttivita());
       
       return attivitaDto;
    }

    public void aggiornaRichiesta(Richiesta richiesta) {
       session.merge(richiesta);
    }

    public void cancellaRichiesta(Richiesta richiesta) {
     session.delete(richiesta); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Richiesta> trovaRichiestaUtente(String email, String nomeAttivita) {
      final String jpql="select r from Richiesta as r where r.utente.indirizzoEmail=:x and r.attivita.nomeAttivita=:y";
      Query<Richiesta> queryRichiesta = session.createQuery(jpql, Richiesta.class);
      queryRichiesta.setParameter("x", email);
      queryRichiesta.setParameter("y", nomeAttivita);
  
      List<Richiesta> richieste = queryRichiesta.list();
      
      return richieste;
    }

    public List<RichiestaDto> esisteIndirizzoEmail(String email) {
        List<RichiestaDto> richiesteDto = new ArrayList<>();
        final String jql = "select r from Richiesta as r join r.utente where r.utente.indirizzoEmail=:x";
        Query<Richiesta> queryRichiesta = session.createQuery(jql, Richiesta.class);
        queryRichiesta.setParameter("x", email);
        for(Richiesta richiesta : queryRichiesta.list()) {
            RichiestaDto richiestaDto = convertFromRchiestaToRichiestaDto(richiesta);
            richiesteDto.add(richiestaDto);
        
            
            
        }
        
        
        
       return richiesteDto;
    }
    public Optional<Richiesta> trovaRichiestaConIdRichiesta(int idRichiesta) {
        final String hql = "from Richiesta as r where r.idRichiesta=:id";
        Optional<Richiesta> richiestaOpt = Optional.empty();
        Query<Richiesta> queryRichiesta = session.createQuery(hql, Richiesta.class);
        queryRichiesta.setParameter("id", idRichiesta);
        List<Richiesta> listaRichieste = queryRichiesta.list();
        if(listaRichieste.size()==1) {
            richiestaOpt=Optional.of(queryRichiesta.getSingleResult());
        }
        
        
        return richiestaOpt;
    }

}
