/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import dto.AttivitaDto;
import dto.PrestazioneDto;
import entita.Attivita;
import entita.Prestazione;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class DaoPrestazione {
    private Session session;
    public void setSession(Session session){
           this.session= Objects.requireNonNull(session);
    }
    public DaoPrestazione() {}
    public void aggiungiPrestazone(Prestazione prestazione) {
        session.saveOrUpdate(prestazione);
    }
    public List<PrestazioneDto> getPrestazoniAttivita() {
        List<PrestazioneDto> prestazioni = new ArrayList<>();
        Query<Tuple> query= session.createQuery("select p,a from Prestazione as p inner join p.attivita as a",Tuple.class);
        for(Tuple tuple: query.list()) {
            Prestazione prestazione = tuple.get(0, Prestazione.class);
            PrestazioneDto prestazioneDto = convertFromPrestazioneToPrestazioneDto(prestazione);
            Attivita attivita = prestazione.getAttivita();
            Optional<AttivitaDto> optionalAttivitaDto=Optional.empty();
            
            if(attivita!=null) {
                AttivitaDto attivitaDto = convertFromAttivitaToAttivitaDto(attivita);
                optionalAttivitaDto=Optional.of(attivitaDto);
            }
            prestazioneDto.setAttivita(optionalAttivitaDto);
            prestazioni.add(prestazioneDto);
        }
        
        return prestazioni;
    }

    private PrestazioneDto convertFromPrestazioneToPrestazioneDto(Prestazione prestazione) {
        PrestazioneDto prestazioneDto = new PrestazioneDto();
        Date dataPrestazione1 = prestazione.getDataPrestazione();
         Optional<String> optionalFeedBack = Optional.empty();
        
        if(dataPrestazione1!=null){
           java.sql.Date dataSql = new java.sql.Date(dataPrestazione1.getTime());
        LocalDate dataPrestazione =dataSql.toLocalDate();
        prestazioneDto.setDataPrestazione(dataPrestazione);
        prestazioneDto.setIdPrestazione(prestazione.getIdPrestazione());
        if(prestazione.getFeedback()!=null) {
            optionalFeedBack=Optional.of(prestazione.getFeedback());
        }
        }
       
        prestazioneDto.setFeedback(optionalFeedBack);
        prestazioneDto.setVotoPrestazione(prestazione.getVotoPrestazione());
        return prestazioneDto;
    }

    private AttivitaDto convertFromAttivitaToAttivitaDto(Attivita attivita) {
     AttivitaDto attivitaDto=new AttivitaDto();
     attivitaDto.setIdAttivita(attivita.getIdAttivita());
     attivitaDto.setNomeAttivita(attivita.getNomeAttivita());
     
     return attivitaDto;
    }
    public void aggiornaPrestazione(Prestazione prestazione){
        session.merge(prestazione);
    }
    public void cancellaPrestazione(Prestazione prestazione) {
        session.delete(prestazione);
    }
    public Optional<Prestazione> trovaPrestazioneConIdPrestazione(int idPrestazione) {
        Optional<Prestazione> prestazioneOpt = Optional.empty();
        final String hql = "from Prestazione as p where p.idPrestazione=:id";
        Query<Prestazione> queryPrestazione = session.createQuery(hql, Prestazione.class);
        List<Prestazione> listaPrestazioni = queryPrestazione.list();
        if(listaPrestazioni.size() == 1) {
            prestazioneOpt=Optional.of(queryPrestazione.getSingleResult());
        }
        return prestazioneOpt;
    }
}
