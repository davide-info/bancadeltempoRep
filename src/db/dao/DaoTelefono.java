/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.TelefonoDto;
import dto.UtenteDto;
import entita.Telefono;
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
public class DaoTelefono {
    private Session session;
    public void setSession(Session session) {
        this.session = Objects.requireNonNull(session);
    }
    public DaoTelefono() {}
    public DaoTelefono(Session session) {
        setSession(session);
    }
    public void aggiungiTelefono(Telefono telefono) {
        session.saveOrUpdate(telefono);
    }
    public List<TelefonoDto> getTelfoniUtente() {
        List<TelefonoDto> telefoni = new ArrayList<>();
        Query<Tuple> queryTuple = session.createQuery("select t,u from Telefono as t inner join t.utente as u",Tuple.class);
        for(Tuple tuple: queryTuple.list()) {
             Telefono telefono = tuple.get(0, Telefono.class);
           TelefonoDto telefonoDto= convertFromTelefonoToTkefonoDto(telefono);
           Utente utente = tuple.get(1, Utente.class);
           Optional<UtenteDto> utenteDtoPtional=Optional.empty();
           if(utente!=null) {
           UtenteDto utenteDto = convertFromUtenteToUtenteDto(utente);
           utenteDtoPtional=Optional.of(utenteDto);
           
        }
           telefonoDto.setUtente(utenteDtoPtional);
           telefoni.add(telefonoDto);
        }
        return telefoni;
    }
    
    
    private TelefonoDto convertFromTelefonoToTkefonoDto(Telefono telefono) {
     TelefonoDto telefonoDto = new TelefonoDto();
     telefonoDto.setIdTelefono(telefono.getIdTelefono());
     telefonoDto.setNumeroDiTelefono(telefono.getNumeroTelefono());
     
     return telefonoDto;
    }

    private UtenteDto convertFromUtenteToUtenteDto(Utente utente) {
      UtenteDto utenteDto=new UtenteDto();
      Optional<String> optionalPassword = Optional.empty();
      if(utente.getPassword()!=null) {
          optionalPassword=Optional.of(utente.getPassword());
      }
      
      utenteDto.setNome(utente.getNome());
      utenteDto.setPassword(optionalPassword);
      utenteDto.setEmail(utente.getIndirizzoEmail());
      utenteDto.setSaldoOre(utente.getSaldoIniziale());
      return utenteDto;
    }
    public void aggiornaTefono(Telefono telefono) {
        session.merge(telefono);
    }

    public void cancellaTelefono(Telefono telefono) {
       session.delete(telefono);
    }
    public Optional<Telefono> trovaTelefonoConIdTelefono(int idTelefono) {
        Optional<Telefono> telefonoOpt = Optional.empty();
        final String hql = "from Telefono as t where t.idTelefono=:id";
        Query<Telefono> queryTelefono = session.createQuery(hql, Telefono.class);
        queryTelefono.setParameter("id",idTelefono);
        List<Telefono> listaTelefoni = queryTelefono.list();
        if(listaTelefoni.size() == 1) {
            telefonoOpt=Optional.of(queryTelefono.getSingleResult());
        }
        
        return telefonoOpt;
    }
}
