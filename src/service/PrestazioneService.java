/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoPrestazione;
import dto.PrestazioneDto;
import entita.Prestazione;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class PrestazioneService {
    private DbConfiguration configuration;
    private Session session;
    private Transaction transaction;
    private DaoPrestazione daoPrestazione;
    public PrestazioneService() {
        configuration=new DbConfiguration();
        session = configuration.getSession();
        daoPrestazione=new DaoPrestazione();
        daoPrestazione.setSession(session);
        transaction=session.getTransaction();
        }
    public void aggiungiPrestazione(Prestazione prestazione) {
        transaction.begin();
        daoPrestazione.aggiungiPrestazone(prestazione);
        transaction.commit();
    }
    public void aggiornaPrestazione(Prestazione prestazione) {
        transaction.begin();
        daoPrestazione.aggiornaPrestazione(prestazione);
        transaction.commit();
    }
    public void cancellaPrestazione(Prestazione prestazione) {
        transaction.begin();
        daoPrestazione.cancellaPrestazione(prestazione);
        transaction.commit();
    }
    public List<PrestazioneDto> getPrestazioniAttivita() {
        return daoPrestazione.getPrestazoniAttivita();
    }
}
