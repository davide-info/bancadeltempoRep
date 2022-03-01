/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoZonaDiRiferimento;
import dto.ZonaDiRiferimentoDto;
import entita.ZonaDiRiferimento;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class ZonaDiRiferimentoService {
    private DbConfiguration configuration;
    private Session session;
    private Transaction transaction;
    private DaoZonaDiRiferimento daoZonaDiRiferimento;
    public ZonaDiRiferimentoService() {
        configuration=new DbConfiguration();
        session = configuration.getSession();
        daoZonaDiRiferimento=new DaoZonaDiRiferimento();
        daoZonaDiRiferimento.setSession(session);
        transaction=session.getTransaction();
    }
    public void aggiungiZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento) {
        transaction.begin();
        daoZonaDiRiferimento.aggiungiZonaDiRiferimento(zonaDiRiferimento);
        transaction.commit();
    }
    public void aggiornaZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento) {
        transaction.begin();
        daoZonaDiRiferimento.aggiornaZonaDiRiferimento(zonaDiRiferimento);
        transaction.commit();
    }
    public List<ZonaDiRiferimentoDto> getZoneDiRiferimentoUtente() {
        return daoZonaDiRiferimento.getZonaDiRiferimentiUtente();
    
    }
    public void cancellaZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento) {
        transaction.begin();
        daoZonaDiRiferimento.cancellaZonaDiRiferimento(zonaDiRiferimento);
        transaction.commit();
    }
}
