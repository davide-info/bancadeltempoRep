/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.SottoCategoriaDto;
import entita.SottoCategoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author win
 */
public class DaoSottoCategoria {
    private Session session ;
   
    public void setSession(Session session) {
        this.session =Objects.requireNonNull(session);
    }
    public DaoSottoCategoria() {
      
        
        
    }
        public DaoSottoCategoria(Session session) {
            setSession(session);
    }
        public void aggiungiSottoCategoria(SottoCategoria s) {
            session.saveOrUpdate(s);
        }
    public void aggiornaSottoCategoria(SottoCategoria s) {
        session.merge(s);
    }
    public List<SottoCategoriaDto> getSottoCategorie() {
        List<SottoCategoriaDto> sottocategorie = new ArrayList<>();
        Query<SottoCategoria> query = session.createQuery("from SottoCategoria as s", SottoCategoria.class);
      for(SottoCategoria sottocategoria:query.list()) {
        
          SottoCategoriaDto sottoDto = new SottoCategoriaDto(sottocategoria.getIdSottoCategoria(), sottocategoria.getNomeSottoCategoria());
          sottocategorie.add(sottoDto);
      }  
        return sottocategorie;
    }

    public void rimuoviSottoCategoria(SottoCategoria s) {
     session.delete(s);
    }
    public Optional<SottoCategoria> trovaSottoCategoriaconIdSottoCategoria(int idSottoCategoria) {
        Optional<SottoCategoria> sottoCategoriaOpt = Optional.empty();
        final String hql = "from SottoCategoria as s Where s.idSottoCaegoria=:id";
        Query<SottoCategoria> querySottoCategoria=session.createQuery(hql, SottoCategoria.class);
        querySottoCategoria.setParameter("id", idSottoCategoria);
        List<SottoCategoria> listaSottoCategorie = querySottoCategoria.list();
        if(listaSottoCategorie.size() == 1) {
            sottoCategoriaOpt=Optional.of(querySottoCategoria.getSingleResult());
        }
        return sottoCategoriaOpt;
    }
}
