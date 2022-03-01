/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoPrenotazione;
import entita.Prenotazione;
import java.util.List;
import org.hibernate.Session;
import dto.PrenotazioneDto;
import dto.PrenotazioneJoinUtenteDto;
import java.util.Optional;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class PrenotazioneService {
    private DbConfiguration configuration;
    private Session session ;
    private Transaction transaction;
    private DaoPrenotazione dao;
    public PrenotazioneService() {
        configuration=new DbConfiguration();
        dao = new DaoPrenotazione();
        session = configuration.getSession();
        dao.setSession(session);
        transaction=session.getTransaction();
    }
    public void aggiungiPrenotazione(Prenotazione p) {
       try{
           transaction.begin();
           dao.aggiungiPrenotazione(p);
           transaction.commit();
      }  
      catch(Exception ex){
         transaction.rollback();
      }
    }
    public List<PrenotazioneDto> getPrenotazioni() {
      return dao.getPrenotazioni();
    }
    public void aggiornaPrenotazion(Prenotazione p) {
        transaction.begin();
        dao.aggiornaPrenotazione(p);
        
        transaction.commit();
    }
    
    public List<PrenotazioneJoinUtenteDto> getPrenotazioniUtente() {
       return dao.getPrenotazioniUtente();
        
    }
    public void cancellaPrenotazione(Prenotazione p) {
        transaction.begin();
        dao.cancellaPrenotazione(p);
        transaction.commit();
    }

    public Optional<Prenotazione> trovaPrenotazioneConId(int idPrenotazione) {
       return dao.trovaPrenotazioneConId(idPrenotazione); //To change body of generated methods, choose Tools | Templates.
    }
}
