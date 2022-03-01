/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;
import dto.AttivitaDto;
import dto.AttivitaJoinUtenteDto;
import entita.Attivita;
import entita.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author win
 */
public class DaoAttivita {
    private  Session session ;
    public DaoAttivita() {
       
       
    }
    public DaoAttivita(Session session) {
        this.session = session ;
    }
    public void aggiungiAttivita(Attivita attivita) {
       
      session.saveOrUpdate(attivita);
        
    }
        public void aggiornaAttivita(Attivita a) {
            session.merge(a);
        }
        public void rimuoviAttivita(Attivita attivita) {
            session.delete(attivita);
        }
       
        
      
    public List<AttivitaDto> getAttivitaHQL() {
       Query query = session.createQuery("FROM Attivita as a", Attivita.class);
       List<Attivita> risultatiQuery = query.list();
       List<AttivitaDto> risultati = new ArrayList<>();
       for(Attivita attivita: risultatiQuery) {
           risultati.add(convertFromAttivitaToAttivitaDto(attivita));
       }
       
       return risultati;
       
    }
    public List<AttivitaJoinUtenteDto> getAttivitaNomeAttivitaHQL() {
     Query<Tuple> query = session.createQuery("SELECT u.nome,u.cognome,u.indirizzoEmail,a.idAttivita,a.nomeAttivita FROM Attivita  as a INNER JOIN attivita.utente as u", Tuple.class);
     
     
     return getRisultati(query);
    }
    private List<AttivitaJoinUtenteDto> getRisultati(Query<Tuple> query) {
        List<AttivitaJoinUtenteDto> risultati = new ArrayList<>();
     List<Tuple>  tupleQuery =query.list();
        for(Tuple tuple: tupleQuery) {
            AttivitaJoinUtenteDto dto = new AttivitaJoinUtenteDto(tuple.get(0, String.class), tuple.get(1, String.class), tuple.get(2,String.class ),tuple.get(3, Integer.class), tuple.get(4, String.class));
            risultati.add(dto);
     }
        return risultati;
    }
    
    
     public List<AttivitaJoinUtenteDto> getAttivitaNomeAttivitaSQL() {
     Query<Tuple> query = session.createNativeQuery("SELECT u.nome,u.cognome,u.indirizzo_Email,a.id_attivita,a.nome_attivita FROM Attivita  as a INNER JOIN Utente as u on a.fk_utente=indirizzo_email", Tuple.class);
     return getRisultati(query);
    }
    
    
  public void setSession(Session session) {this.session = Objects.requireNonNull(session);}

    public void cancellaAttivita(Attivita a) {
      session.remove(a);
    }

    public boolean esisteAttivita(String nomeAttivita) {
        final String jpql = "from Attivita as a where a.nomeAttivita=:x";
        Query<Attivita> attivitaQuery = session.createQuery(jpql, Attivita.class);
        attivitaQuery.setParameter("x", nomeAttivita);
        return attivitaQuery.list().size()>=1;
                
          
        
    }

    public List<AttivitaJoinUtenteDto> getAttivitaUtente() {
      //  System.out.println("ENTRATO QUA "+ getClass().getEnclosingMethod());
        
       final String jpql = "select a, u from Attivita as a join a.utente as u";
      Query<Tuple> query = session.createQuery(jpql, Tuple.class);
        List<AttivitaJoinUtenteDto> attivitaUtenti = new ArrayList<>();
       for(Tuple tuple : query.list()) {
           AttivitaJoinUtenteDto join = new AttivitaJoinUtenteDto();
           Attivita attivita = tuple.get(0, Attivita.class);
           Utente utente = tuple.get(1, Utente.class);
           join.setCognome(utente.getCognome());
           join.setNome(utente.getNome());
           
           
           join.setIdAttivita(join.getIdAttivita());
           join.setNomeAttivita(attivita.getNomeAttivita());
           join.setIndirizzoEmail(utente.getIndirizzoEmail());
           join.setIdAttivita(attivita.getIdAttivita());
           attivitaUtenti.add(join);
           
       
       }
        
       
        return attivitaUtenti;
        
    }

    public Optional<Attivita> trovaNomeAttivita(String nomeAttivita) {
        Optional<Attivita>  attivitaOpt = Optional.empty();
      final String queryJql = "select a from Attivita as a where a.nomeAttivita=:x";
      Query<Attivita> queryAttivita = session.createQuery(queryJql,Attivita.class);
      queryAttivita.setParameter("x", nomeAttivita);
      List<Attivita> listaAttivita = queryAttivita.list();
      if(listaAttivita.size() ==1) {
        attivitaOpt=Optional.of(queryAttivita.getSingleResult());
      }
      
      return attivitaOpt;
      
    }

    
    private AttivitaDto convertFromAttivitaToAttivitaDto(Attivita attivita) {
      AttivitaDto attivitaDto= new AttivitaDto();
      attivitaDto.setNomeAttivita(attivita.getNomeAttivita());
      attivitaDto.setIdAttivita(attivita.getIdAttivita());
      
      return attivitaDto;
    }

    public Optional<Attivita> trovaIdAttivita(int idAttivita) {
     Optional<Attivita> optionalAtt = Optional.empty();
     final String jpql ="select a from Attivita as a where a.idAttivita=: x" ;
     
     Query<Attivita> queryAttivita = session.createQuery(jpql,  Attivita.class);
     queryAttivita.setParameter("x",idAttivita);
     
     List<Attivita> listaAttivita = queryAttivita.list();
     if(listaAttivita.size()==1) {
         optionalAtt = Optional.of(queryAttivita.getSingleResult());
     }
     
     
    return optionalAtt;
    }

   


}