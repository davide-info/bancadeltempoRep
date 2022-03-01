/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoUtente;
import dto.UtenteDto;
import entita.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author win
 */
public class UtenteService {
    private DbConfiguration configuration ;
    private DaoUtente dao;
  private Session session ;
private Transaction transaction;
    
    public UtenteService() {
        configuration=new DbConfiguration();
        dao = new DaoUtente();
        session = configuration.getSession();
       dao.setSession(session);
       transaction = session.getTransaction();
    }
    public void aggiungiUtente(Utente u) {
       
     
       transaction.begin();
       try {
        dao.aggiungiUtente(u);
        transaction.commit();
       }catch(Exception ex) {
           transaction.rollback();
       }
     
    }
    public Optional<Utente> trovaUtentePassword(String password) {
        return dao.trovaPasswordUtente(password);
    }
    public List<UtenteDto> getUtenti() {
       List<UtenteDto> utenti = new ArrayList<>();
       
      utenti = dao.getUtentiHQL();
       return utenti;
        
    }
    
    public Optional<Utente> trovaEmailUtente(String email) {
        return dao.trovaEmail(email);
    }

    public boolean esisteEmail(String email) {
      return dao.esisteEmail(email); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean esistePassword(String password) {
        return dao.esistePassword(password);
    }

    public void aggiornaUtente(Utente utente) {
        transaction.begin();
        dao.aggiornaUtente(utente);
        transaction.commit();
    }
    public void rimuoviUtente(Utente utente) {
        transaction.begin();
        dao.rimuoviUtente(utente);
        transaction.commit();
    }
}
