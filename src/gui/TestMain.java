/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.DbConfiguration;
import dto.AttivitaJoinUtenteDto;
import entita.Attivita;
import entita.Prenotazione;
import entita.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.AttivitaService;
import service.OffertaService;
import service.PrenotazioneService;
import service.PrestazioneService;
import service.RichiestaService;
import service.UtenteService;



/**
 *
 * @author win
 */
public class TestMain {
    public static void main(String[] args) {
    RichiestaService richiestaService=new RichiestaService();
    OffertaService offertaService = new OffertaService();
    UtenteService utenteService = new UtenteService();
    AttivitaService attivitaService = new AttivitaService();
    PrestazioneService prestazioneService = new PrestazioneService();
    PrenotazioneService prenotazioneService = new PrenotazioneService();
    
    
    
  System.out.println("RICHIESTA UTENTI "+richiestaService.getRichiesteUtenti());
  final String email ="davideinfo4@gmail.com";
  System.out.println("ESISTE RICHIESTA UTENTE " + richiestaService.esisteIndirizzoEmail(email));
  System.out.println("ESISTE OFFERTA UTENTE " + offertaService.esisteIndrizzoEmail(email));
  System.out.println("ATTIVITA "+ attivitaService.getAttivita());
  System.out.println("ATTIVITA UTENTI "+ attivitaService.getAttivitaUtente());
  System.out.println("PRENOTAZIONI " + prenotazioneService.getPrenotazioni());
  
  final int idPrenotazione = 1;
 Optional<Prenotazione> prenotazioneOpt= prenotazioneService.trovaPrenotazioneConId(idPrenotazione);
  System.out.println("prenotazoione " + prenotazioneOpt);
  
 // provaPrestazione();
    }
    
    private static void testAttivitaQuery() {   
       Session session = new DbConfiguration().getSession();
        final String jpql = "select a, u from Attivita as a join a.utente as u";
        List<AttivitaJoinUtenteDto> attivitaUtenti = new ArrayList<>();
        Query<Tuple> queryAttivitaUtente = session.createQuery(jpql, Tuple.class);
        List<Tuple> lista = queryAttivitaUtente.list();
       for(Tuple tuple: lista) {
           System.out.println(tuple.get(0, Attivita.class));
       }
       
    }
    private static void provaPrestazione() 
    {
        PrestazioneService prestazioneService = new PrestazioneService(); 
        PrenotazioneService prenotazioneService = new PrenotazioneService();
        
        
        
    }
    
}
