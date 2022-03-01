/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoSottoCategoria;
import dto.SottoCategoriaDto;
import entita.SottoCategoria;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class SottoCategoriaService {
    private DbConfiguration configuration ;
    private Session session;
    private Transaction transaction ;
    private DaoSottoCategoria daoSottoCategoria;
    public SottoCategoriaService() {
        configuration=new DbConfiguration();
        daoSottoCategoria=new DaoSottoCategoria();
        session = configuration.getSession();
        daoSottoCategoria.setSession(session);
        transaction=session.getTransaction();
    }
    public void aggiungiSottoCategoria(SottoCategoria s){
        transaction.begin();
        daoSottoCategoria.aggiungiSottoCategoria(s);
        transaction.commit();
    }
    public List<SottoCategoriaDto> getSottoCategorie() {
      return daoSottoCategoria.getSottoCategorie();
      
    }
    public void aggiornaSottoCategoria(SottoCategoria s) {
    transaction.begin();
    daoSottoCategoria.aggiornaSottoCategoria(s);
    transaction.commit();
    }
    public void rimuoviSottoCategoria(SottoCategoria s) {
        transaction.begin();
        daoSottoCategoria.rimuoviSottoCategoria(s);
    }
 }
