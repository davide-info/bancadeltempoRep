/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.UtenteDto;
import dto.ZonaDiRiferimentoDto;
import entita.Utente;
import entita.ZonaDiRiferimento;
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
public class DaoZonaDiRiferimento {
    private Session session;
    public void setSession(Session session){
        this.session=Objects.requireNonNull(session);
    }
    public void aggiungiZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento) {
        session.saveOrUpdate(zonaDiRiferimento);
    }
    public List<ZonaDiRiferimentoDto> getZonaDiRiferimentiUtente() {
        final String jpql="select u,z from Utente as u join u.zonaDiRiferimento as z";
        List<ZonaDiRiferimentoDto> zone=new ArrayList<>();
        Query<Tuple> query=session.createQuery(jpql, Tuple.class);
       
        for(Tuple tuple: query.list()) {
            Utente utente = tuple.get(0, Utente.class);
              ZonaDiRiferimento zonaDiRiferimento=tuple.get(1, ZonaDiRiferimento.class);
              ZonaDiRiferimentoDto zonaDiRiferimentoDto = convertFromZonaDiRiferimentoToZonaDiRiferimentoDto(zonaDiRiferimento);
           
             Optional<UtenteDto> optionalutenteDto=Optional.empty();
            if(utente!=null) {
               UtenteDto  utenteDto=convertFromUtenteToUtenteDto(utente);
               optionalutenteDto=Optional.of(utenteDto);
            }
            zonaDiRiferimentoDto.setUtente(optionalutenteDto);
           
           
        }
        
        return zone;
    }

    private UtenteDto convertFromUtenteToUtenteDto(Utente utente) {
      UtenteDto utenteDto = new UtenteDto();
      Optional<String> optionalPassword = Optional.empty();
      if(utente.getPassword()!=null) {
          optionalPassword=Optional.of(utente.getPassword());
      }
      utenteDto.setCognome(utente.getCognome());
      utenteDto.setNome(utente.getNome());
      utenteDto.setEmail(utente.getIndirizzoEmail());
      utenteDto.setSaldoOre(utente.getSaldoIniziale());
      return utenteDto;
    }

    private ZonaDiRiferimentoDto convertFromZonaDiRiferimentoToZonaDiRiferimentoDto(ZonaDiRiferimento zonaDiRiferimento) {
        ZonaDiRiferimentoDto zonaDiRiferimentoDto = new ZonaDiRiferimentoDto();
        zonaDiRiferimentoDto.setIdZonaRiferimento(zonaDiRiferimento.getIdZonaDiRiferimento());
        zonaDiRiferimento.setLuogo(zonaDiRiferimento.getLuogo());
        zonaDiRiferimento.setVia(zonaDiRiferimento.getCitta());
        
       
        return zonaDiRiferimentoDto;
    }
    public void aggiornaZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento) {
        session.merge(zonaDiRiferimento);
    }
    public void cancellaZonaDiRiferimento(ZonaDiRiferimento zonaDiRiferimento){
        session.delete(zonaDiRiferimento);
    }
    public Optional<ZonaDiRiferimento> trovaZonaDiRiferimentoConIdZonaDiRiferimento(int idZonaDiRiferimento) {
        Optional<ZonaDiRiferimento> zonaOpt = Optional.empty();
        final String hql = "from ZonaDiRiferimento as z where z.idZonaDiRiferimento=: id";
        Query<ZonaDiRiferimento> queryZona = session.createQuery(hql, ZonaDiRiferimento.class);
        queryZona.setParameter("id", idZonaDiRiferimento);
        List<ZonaDiRiferimento> listaZoneDiRiferimento = queryZona.list();
        if(listaZoneDiRiferimento.size() == 1) {
                zonaOpt=Optional.of(queryZona.getSingleResult());
            }
        
        return zonaOpt;
    }
}
