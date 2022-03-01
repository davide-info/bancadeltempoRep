/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.AttivitaDto;
import dto.OffertaDto;
import dto.UtenteDto;
import entita.Attivita;
import entita.Offerta;
import entita.Utente;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class DaoOfferta {
    private Session session ;
    public void setSession(Session session){
        this.session=Objects.requireNonNull(session);
    }
    public DaoOfferta(){}
    public DaoOfferta(Session session) {
        setSession(session);
    }
    public void aggiungiOfferta(Offerta offerta){
        session.saveOrUpdate(offerta);
    }
    public List<OffertaDto> getOfferteFatteUtente() {
        final String queryJpql = "select o,u from Offerta as o join o.utente as u";
        Query<Tuple> query = session.createQuery(queryJpql,Tuple.class);
        List<OffertaDto> offerte = new ArrayList<>();
        
        for(Tuple tuple: query.list()) {
           Offerta offerta= tuple.get(0, Offerta.class);
           OffertaDto offertaDto = convertFromOffertaToOffertaDto(offerta);
           
           
           Optional<UtenteDto> optionalutenteDto = Optional.empty();
           Optional<AttivitaDto> optionalAttivitaDto = Optional.empty();
           
           if(offerta.getUtente()!=null) {
               UtenteDto utenteDto = convertFromUtenteToUtenteDto(offerta.getUtente());
               optionalutenteDto=Optional.of(utenteDto);
              
           }
           if(offerta.getAttivita()!=null) {
               Attivita attivita = offerta.getAttivita();
               AttivitaDto attivitaDto = convertFromAtivitaToAttivitaDto(attivita);
               optionalAttivitaDto=Optional.of(attivitaDto);
           }
           
             offertaDto.setUtente(optionalutenteDto);
             offertaDto.setAttivita(optionalAttivitaDto);
           offerte.add(offertaDto);
           
          
        }
        
        
        
        return offerte;
        
    }

    private OffertaDto convertFromOffertaToOffertaDto(Offerta offerta) {
       OffertaDto offertaDto = new OffertaDto();
       LocalDate dataOfferta = new java.sql.Date(offerta.getDataOfferta().getTime()).toLocalDate();
       offertaDto.setIdOfferta(offerta.getIdOfferta());
       offertaDto.setDataOfferta(dataOfferta);
       Utente utente = offerta.getUtente(); Attivita attivita = offerta.getAttivita();
       Optional<UtenteDto> utenteOpt = Optional.empty();
       Optional<AttivitaDto> attivitaOpt = Optional.empty();
       if(utente!=null) {
           UtenteDto utenteDto = convertFromUtenteToUtenteDto(utente);
           utenteOpt = Optional.of(utenteDto);
           
       }
        if(attivita!=null) {
            AttivitaDto attivitaDto=convertFromAtivitaToAttivitaDto(attivita);
            attivitaOpt = Optional.of(attivitaDto);
            
       }
       offertaDto.setUtente(utenteOpt);
       offertaDto.setAttivita(attivitaOpt);
       
               
         return offertaDto;
    }
    
    public void aggiornaOfferta(Offerta offerta){
        session.merge(offerta);
    }
    public void cancellaOfferta(Offerta offerta){
        session.delete(offerta);
    }

    private UtenteDto convertFromUtenteToUtenteDto(Utente utente) {
     UtenteDto utenteDto = new UtenteDto();
     utenteDto.setNome(utente.getNome());
     utenteDto.setCognome(utente.getCognome());
     Optional<String> optionalPassword=Optional.empty();
     if(utente.getPassword()!=null) {
         optionalPassword=Optional.of(utente.getPassword());
     }
     utenteDto.setPassword(optionalPassword);
     utenteDto.setEmail(utente.getIndirizzoEmail());
     utenteDto.setSaldoOre(utente.getSaldoIniziale());
     return utenteDto;
    }

    private AttivitaDto convertFromAtivitaToAttivitaDto(Attivita attivita) {
     AttivitaDto attivitaDto = new AttivitaDto();
     attivitaDto.setIdAttivita(attivita.getIdAttivita());
     attivitaDto.setNomeAttivita(attivita.getNomeAttivita());
     return attivitaDto;
    }

    public List<OffertaDto> esisteIndirizzoEmail(String email) {
        List<OffertaDto> offerteDto=new ArrayList<>();
        final String jql = "select o from Offerta as o join o.utente where o.utente.indirizzoEmail=:email";
        Query<Offerta> queryOfferta=session.createQuery(jql, Offerta.class);
        queryOfferta.setParameter("email", email);
        for(Offerta offerta: queryOfferta.list()) {
            OffertaDto offertaDto =convertFromOffertaToOffertaDto(offerta);
            offerteDto.add(offertaDto);
        }
        
//To change body of generated methods, choose Tools | Templates.
return offerteDto;
    }
    public Optional<Offerta> trovaOffertaConIdOfferta(int idOfferta) {
            Optional<Offerta> offertaOpt = Optional.empty();
            final String hql = "from Offerta as o where o.idOfferta=:id";
            Query<Offerta> queryOfferta = session.createQuery(hql,Offerta.class);
            queryOfferta.setParameter("id", idOfferta);
            List<Offerta> listaOfferte = queryOfferta.list();
            if(listaOfferte.size()==1) {
                    offertaOpt=Optional.of(queryOfferta.getSingleResult());
                
            }
           return offertaOpt;
    }
                    
            
          
        
}
