/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.CategoriaDto;
import entita.Categoria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author win
 */
public class DaoCategoria {
    private Session session ;
    public void setSession(Session session) {this.session = Objects.requireNonNull(session);}
    public DaoCategoria(Session session){setSession(session);}
    public DaoCategoria() {}
    public void aggiungiCategoria(Categoria c) {
        session.saveOrUpdate(c);
    }
    public List<CategoriaDto> getAllCategoria() {
       Query<Categoria> queryCategoria= session.createQuery("select c from Categoria as c", Categoria.class);
       List<CategoriaDto> risultati = new ArrayList<>();
       for(Categoria categoria: queryCategoria.list()) {
           CategoriaDto categoriaDto = new CategoriaDto(categoria.getIdCategoria(), categoria.getNomeCategoria());
           risultati.add(categoriaDto);
       }
       
       return risultati;
        
    }
    public void aggiungiCollezioneCategorie(Collection<Categoria> collCategorie) {
            for(Categoria categoria:collCategorie) {
                aggiungiCategoria(categoria);
            }
    }
    
    public void aggiornaCategoria(Categoria c) {
        session.merge(c);
    }
    public void cancellaCategoria(Categoria c) {
        session.delete(c);
    }

    public Optional<Categoria> trovaIdCategoria(int idCategoria) {
      Optional<Categoria> catOpt = Optional.empty();
      final String jql = "from Categoria as c where c.idCategoria=:x" ;
      Query<Categoria> queryCategoria = session.createNativeQuery(jql,Categoria.class);
      List<Categoria> listaCategorie = queryCategoria.list();
      if(listaCategorie.size() ==1) {
          catOpt = Optional.of(queryCategoria.getSingleResult());
      }
      
      return catOpt;
    }
    
    
}
