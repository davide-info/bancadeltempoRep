
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoAttivita;
import dto.AttivitaDto;
import dto.AttivitaJoinUtenteDto;
import entita.Attivita;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class AttivitaService {
    private final  DbConfiguration configuration;
    private final DaoAttivita daoAttivita;
    private Session session;
    private Transaction transaction;
    
    public AttivitaService() {
        configuration = new DbConfiguration();
        daoAttivita=new DaoAttivita();
        session = configuration.getSession();
        daoAttivita.setSession(session);
        transaction = session.getTransaction();
    
    }
    public void aggiungiAttivita(Attivita a) {
      try{
            
      transaction.begin();
          
     daoAttivita.aggiungiAttivita(a);
      transaction.commit();
         
      }catch(Exception ex) {
         transaction.rollback();
      }
       
            
            
            
            
            
            
            
        }
        
    
    public void aggiornaAttivita(Attivita a) {
        
       transaction.begin();
       try {
       daoAttivita.aggiornaAttivita(a);
        
        transaction.commit();
       }catch(Exception ex) {transaction.rollback();}
    }
    public List<AttivitaDto> getAttivita() {
       return  daoAttivita.getAttivitaHQL();
               
               
    }
    public void cancellaAttivita(Attivita a) {
      transaction.begin();
      daoAttivita.cancellaAttivita(a);
      
      transaction.commit();
    
    }

   
    
    public boolean esisteAttivita(String nomeAttivita) {
      return daoAttivita.esisteAttivita(nomeAttivita);
    }
   

    public List<AttivitaJoinUtenteDto> getAttivitaUtente() {
       // System.out.println("ENTRATO QUA ");
     return daoAttivita.getAttivitaUtente();
    }

    public Optional<Attivita> trovaNomeAttivita(String nomeAttivita) {
       return daoAttivita.trovaNomeAttivita(nomeAttivita);
    }
    public Optional<Attivita> trovaIdAttivita(int idAttivita){
        return daoAttivita.trovaIdAttivita(idAttivita);
    }
}
