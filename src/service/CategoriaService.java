/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DbConfiguration;
import db.dao.DaoCategoria;
import dto.CategoriaDto;
import entita.Categoria;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author win
 */
public class CategoriaService {
    private DbConfiguration configuration;
    private DaoCategoria daoCategoria;
    private Transaction transaction ;
    private Session session;
    public CategoriaService() {
        configuration = new DbConfiguration();
        daoCategoria=new DaoCategoria();
      session = configuration.getSession();
      daoCategoria.setSession(session);
      transaction=session.getTransaction();
    }
    public void aggiungiCategoria(Categoria c) {
        transaction.begin();
        try {
        daoCategoria.aggiungiCategoria(c);
        transaction.commit();
        }catch(Exception ex) {transaction.rollback();}
        
    }
    public List<CategoriaDto> getCategorie() {return daoCategoria.getAllCategoria();}
    public Optional<Categoria> trovaIdCategoria(int idCategoria) {
        return this.daoCategoria.trovaIdCategoria(idCategoria);
    
    }
}
