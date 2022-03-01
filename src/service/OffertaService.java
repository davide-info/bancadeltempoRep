/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoOfferta;
import dto.OffertaDto;
import entita.Offerta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class OffertaService {
    private Session session ;
    private DbConfiguration configuration;
    private Transaction transaction;
    private DaoOfferta daoOfferta;
    public OffertaService() {
        configuration=new DbConfiguration();
        session = configuration.getSession();
        daoOfferta=new DaoOfferta();
        daoOfferta.setSession(session);
        transaction=session.getTransaction();
    
    }
    public void aggiungiOfferta(Offerta offerta) {
        transaction.begin();
        daoOfferta.aggiungiOfferta(offerta);
        transaction.commit();
    }
    public List<OffertaDto> getOfferteFatteUtente() {
    return daoOfferta.getOfferteFatteUtente();
    
    }
    public void aggiornaOfferta(Offerta offerta){
        transaction.begin();
        daoOfferta.aggiornaOfferta(offerta);
        transaction.commit();
    }
    public void cancellaOfferta(Offerta offerta){
        transaction.begin();
        daoOfferta.cancellaOfferta(offerta);
        transaction.commit();
    }

    public List<OffertaDto> esisteIndrizzoEmail(String email) {
      return daoOfferta.esisteIndirizzoEmail(email); //To change body of generated methods, choose Tools | Templates.
    }
    
}
