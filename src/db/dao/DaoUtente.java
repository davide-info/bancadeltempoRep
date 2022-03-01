/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.UtenteDto;
import entita.Attivita;
import entita.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


/**
 *
 * @author win
 */
public class DaoUtente {
    private  Session session ;
    
    
    
    public DaoUtente() {
       
    }
    public DaoUtente(Session session) {
            this.session = session;
    }
    
    public void aggiungiUtente(Utente utente) {
            session.saveOrUpdate(utente);
                  
        
    }
   
    private static UtenteDto fromUtenteToUtenteDto(Utente utente) {
        Optional<String> passwordOptional = Optional.empty();
        if(utente.getPassword()!=null) { 
            passwordOptional=Optional.of(utente.getPassword());
        }
        
        UtenteDto risultato = new UtenteDto(utente.getNome(), utente.getCognome(), utente.getIndirizzoEmail(),passwordOptional,utente.getSaldoIniziale());
        return risultato;
    }
    public List<UtenteDto> getUtentiHQL() {
        List<UtenteDto> utenti = new ArrayList<>();
       
       Query<Utente> query = session.createQuery("select u from Utente as u",Utente.class);
       for(Utente utente: query.list()) {
           UtenteDto utenteDto =fromUtenteToUtenteDto(utente);
           utenti.add(utenteDto);
       }
       return utenti;
    }
    public List<Utente> getUtentiSQL() {
        return session.createNativeQuery("SELECT * FROM utente", Utente.class).list();
    }
    
    
   public void setSession(Session session) {
       this.session = Objects.requireNonNull(session) ;
   }

    public boolean esisteEmail(String email) {
      Optional< Utente> utente= trovaEmail(email);
        return utente.isPresent();
    }
    

    public Optional<Utente> trovaEmail(String email) {
       Optional<Utente> utente = Optional.empty();
       final  String jpql="from Utente as u Where u.indirizzoEmail=:email";
          Query<Utente> queryUtente = session.createQuery(jpql,Utente.class);
          queryUtente.setParameter("email", email);
          List<Utente> utenti = queryUtente.list();
          if(utenti.size()==1) {
              utente = Optional.of(queryUtente.getSingleResult());
          }
      
               
   
    //  printQuery();
       return utente;
     
      
    }
    public Optional<Utente> trovaPasswordUtente(String password) {
        Optional<Utente> utentePassword = Optional.empty();
        final String jpql = "SELECT u FROM Utente as u where u.password=:password";
        Query<Utente> queryUtente = session.createQuery(jpql, Utente.class);
        queryUtente.setParameter("password", password);
        List<Utente> utenti = queryUtente.list();
        if(utenti.size() == 1) {
            utentePassword=Optional.of(queryUtente.getSingleResult());
        }
        
        return utentePassword;
    }
    public boolean esistePassword(String password) {
      Optional<Utente> utentePassword = trovaPasswordUtente(password);
      return utentePassword.isPresent();
    }

    public void aggiornaUtente(Utente utente) {
     session.merge(utente);
    }
    public void rimuoviUtente(Utente utente) {
        session.delete(utente);
    }
}
