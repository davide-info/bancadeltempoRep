/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoRichiesta;
import dto.RichiestaDto;
import entita.Richiesta;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class RichiestaService {
    private DbConfiguration configuration;
    private Session session;
    private Transaction transaction;
    private DaoRichiesta daoRichiesta;
    public RichiestaService() {
        configuration=new DbConfiguration();
        daoRichiesta= new DaoRichiesta();
        session = configuration.getSession();
        
        daoRichiesta.setSession(session);
        transaction = session.getTransaction();
        
        
    }
    public void aggiungiRichiesta(Richiesta richiesta) {
        transaction.begin();
        daoRichiesta.aggiungiRichiesta(richiesta);
        transaction.commit();
    }
    public void aggiornaRichiesta(Richiesta richiesta) {
        transaction.begin();
        daoRichiesta.aggiornaRichiesta(richiesta);
        transaction.commit();
    }
    public void cancellaRichiesta(Richiesta richiesta){
        transaction.begin();
        daoRichiesta.cancellaRichiesta(richiesta);
        transaction.commit();
    }
    
    public List<RichiestaDto> getRichiesteUtenti() {
        return daoRichiesta.getRichiesteUtenti();
    }
    public List<Richiesta> trovaRichiestaUtente(String email, String nomeAttivita) {
        return daoRichiesta.trovaRichiestaUtente(email, nomeAttivita);
    }

    public List<RichiestaDto> esisteIndirizzoEmail(String email) {
      return daoRichiesta.esisteIndirizzoEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
