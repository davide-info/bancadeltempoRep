/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoTelefono;
import dto.TelefonoDto;
import entita.Telefono;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class TelefonoService {
    private DbConfiguration configuration;
    private Session session;
    private Transaction transaction;
    private DaoTelefono daoTelefono;
    public TelefonoService() {
        configuration=new DbConfiguration();
        session=configuration.getSession();
        daoTelefono=new DaoTelefono();
        daoTelefono.setSession(session);
        transaction=session.getTransaction();
    }
    public void aggiungiTelefono(Telefono telefono) {
        transaction.begin();
        daoTelefono.aggiungiTelefono(telefono);
        transaction.commit();
    }
    public List<TelefonoDto> getTelefoniUtente() {return daoTelefono.getTelfoniUtente();}
    public void aggiornaTelefono(Telefono telefono) {
        transaction.begin();
        daoTelefono.aggiornaTefono(telefono);
        transaction.commit();
    }
    public void cancellaTelefono(Telefono telefono) {
        transaction.begin();
        daoTelefono.cancellaTelefono(telefono);
        transaction.commit();
    }
    
    
}
