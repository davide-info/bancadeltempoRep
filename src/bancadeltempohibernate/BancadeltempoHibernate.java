/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancadeltempohibernate;

import db.DbConfiguration;
import dto.AttivitaDto;
import dto.AttivitaJoinUtenteDto;
import dto.CollectionDto;
import dto.PrenotazioneDto;
import dto.UtenteDto;
import dto.UtenteGroupByDto;
//import dto.AttivitaJoinUtenteDto;
import entita.Attivita;
import entita.Categoria;
import entita.Offerta;
import entita.Prenotazione;
import entita.Prestazione;
import entita.Richiesta;
import entita.SottoCategoria;
import entita.Telefono;
import entita.Utente;
import entita.ZonaDiRiferimento;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.System.Logger.Level;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
//import java.io.IOException;
//import java.nio.file.Files;
////import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
//mport java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import javax.persistence.SqlResultSetMapping;
/*import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.management.modelmbean.XMLParseException;*/
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/*import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;*/
//import javax.persistence.TupleElement;
//import org.hibernate.Criteria;
//import org.hibernate.ScrollMode;
//import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
//import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;
/*import org.w3c.dom.Document;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;*/


import service.AttivitaService;
import service.CategoriaService;
import service.OffertaService;
import service.PrenotazioneService;
import service.PrestazioneService;
import service.RichiestaService;
import service.SottoCategoriaService;
import service.TelefonoService;
import service.UtenteService;
import service.ZonaDiRiferimentoService;




/**
 *
 * @author win
 */


public class BancadeltempoHibernate {
   private static final Session session =createSession();
    
    private static Session createSession() {
        try {
      
        return new DbConfiguration().getSession();
        }catch(Exception ex) {
          // stampaEccezione(ex);
           ex.printStackTrace();
           System.exit(1);
            return null;
        }
       // session.createQ
    }
    
    
  

    /**
     * @param args the command line arguments
     */
    
    private static void testList() {
           List l = new ArrayList<Object[]>();
        l.add(new Object[]{"Giovanni","Luccetto","Giovanin"});
        for(Object obj: l) {
            if(obj.getClass().isArray()) {
                Object objs[] =(Object[]) obj;
               String msg = Arrays.deepToString(objs) + " ";
               System.out.println(msg);
            }
        }
       
    }
    private static void testReflection() {
      
         final  String fullName="db.DbConfiguration";
       Class<?> classAtt;
           try {
               classAtt = Class.forName(fullName);
               for(Constructor constructor: classAtt.getDeclaredConstructors()) {
                   System.out.println(constructor);
                   System.out.println(Arrays.toString(constructor.getTypeParameters()));
                  System.out.println(Arrays.deepToString(constructor.getParameters()));
               }
               
              for(Class myC: classAtt.getDeclaredClasses()) {
                  System.out.println(Arrays.deepToString(myC.getEnumConstants()));
              }
               System.out.println(Arrays.deepToString(classAtt.getDeclaredFields()));
               
             
              
               for(Field field: classAtt.getDeclaredFields()) {
                  System.out.println(field.getName());
                  System.out.println(Arrays.deepToString(field.getAnnotations()));
               }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(BancadeltempoHibernate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
   
    
           
           
           
  
    
    
    }  
    
    public static void main(String[] args) {
//testReflection();
    
    
        
        
        try {
          testHibernateWithOutSession();
          
            
          }catch(Exception e) {
          e.printStackTrace();
        }
       
    }
    
    private static void stampaLista(List l) {
        l.forEach(obj -> {
            if(obj.getClass().isArray()) {
                Object [] objs = (Object[]) obj ;
                String msg = Arrays.deepToString(objs)+ " ";
                System.out.print(msg);
            }
            else{
                System.out.print(obj.getClass()+ " " +obj.toString());
            }
       });
        System.out.println("\n");
    }
    
    private static UtenteDto fromUtenteToUtenteDto(Utente utente) {
        UtenteDto result = new UtenteDto(utente.getNome(), utente.getCognome(), utente.getIndirizzoEmail(), Optional.of(utente.getPassword()),utente.getSaldoIniziale());
        return result;
    }
    private static AttivitaDto fromAttivitaToAttivitaDto(Attivita attivita) {
        AttivitaDto result = new AttivitaDto(attivita.getIdAttivita(), attivita.getNomeAttivita());
        return result;
    }
    private static Utente fromUtenteDtoToUtente(UtenteDto utente) {
        Utente result = new Utente();
        if(utente.getPassword().isPresent()) {
            result.setNome(utente.getNome());
            result.setCognome(utente.getCognome());
            result.setPassword(utente.getPassword().get());
        }
        
        return result;
    }
private static List<UtenteDto> getUtentiDto() {
    final String jpql = "from Utente as u" ;
    Query<Utente> query = session.createQuery(jpql,Utente.class);
    List<UtenteDto> results = new ArrayList<>();
    for(Utente utente: query.list()) {
        UtenteDto utenteDto = fromUtenteToUtenteDto(utente);
        results.add(utenteDto);
    }
    return results;
}
    private static List<AttivitaDto> getAttivitaDto() {
        final String jpql = " from Attivita as a" ;
        Query<Attivita> query = session.createQuery(jpql, Attivita.class);
        List<AttivitaDto> results = new ArrayList<>();
        for(Attivita attivita: query.list()) {
            AttivitaDto attDto = fromAttivitaToAttivitaDto(attivita);
            results.add(attDto);
        }
        return results;
    }
    private static void testFindGetLoad() {
        Utente utente = (Utente) session.find(Utente.class, "davideinfo4@gmail.com");
        Attivita attivita = (Attivita) session.find(Attivita.class,3);
        if(utente!=null) {
           Utente myUserGet =session.get(Utente.class,utente.getIndirizzoEmail());
           Utente myUserLoad = session.load(Utente.class,utente.getIndirizzoEmail());
           
            System.out.println("get utente " + myUserGet);
            System.out.println("load utente "+ myUserLoad);
        }
        if(attivita!=null) {
            Attivita myActGet = (Attivita) session.get(Attivita.class,attivita.getIdAttivita());
            Attivita myActLoad = (Attivita) session.load(Attivita.class,attivita.getIdAttivita());
              System.out.println("get attivita " + myActGet.getNomeAttivita());
              System.out.println("load attivita " + myActLoad.getNomeAttivita());
            
        }
    }
    

    private static List<Attivita> getAllAttivita() {
        var jpql="from Attivita as a";
        var query=session.createQuery(jpql, Attivita.class);
        return query.list();
    }
    
   private static void testHibernate() {
          
        
          List<Attivita> listaAttivita = creaListaAttivita();
            
            
         
              listaAttivita.forEach(attivita -> {
                inserisciAttivita(attivita);
            });
            
            
        List<Utente> listaUtenti = creaListaUtenti();
            listaUtenti.forEach(utente->{
                if(!esisteUtente(utente.getIndirizzoEmail())) {
                utente.getAttivita().addAll(getAttivita());
                inserisciUtente(utente);
                }
            });
       
            testQuery();
            testFindGetLoad();
        }
     
        
   
    private static Attivita creaAttivita(String nomeAttivita) {
        Attivita attivita = new Attivita();
        attivita.setNomeAttivita(nomeAttivita);
        
        return attivita;
    
    }
    private static List<Attivita> creaListaAttivita() {
        
List<Utente> utenti = creaListaUtenti();
        
         List<Attivita> listaAttivita =Arrays.asList(creaAttivita("calcio", creaUtente("davide", "acquarone", "davideinfo4@gmail.com", "davideinformatica")), creaAttivita("pallavolo",utenti.get(1)), creaAttivita("Dentista"));
         return listaAttivita;
    }
    private static boolean esisteUtente(String indirizzoEmail){
       Utente utente= session.find(Utente.class,indirizzoEmail);
       return utente!=null;
                
    
    }
   private static void testHibernateWithOutSession() {
          Random random = new Random(System.currentTimeMillis());
       List<Attivita> listaAttivita = creaListaAttivita();
       List<Utente> listaUtenti = creaListaUtenti();
       List<Utente> utenti = getUtenti2();
       List<ZonaDiRiferimento> zoneDiRiferimento=getZoneDiRiferimento();
       
       List<Prenotazione> listaPrenotazioni = creaListaPrenotazioni();
       List<Categoria> listaCategorie = getListaCategorie();
    List<SottoCategoria> listaSottoCategorie=getSottoCategorie();
      List<Richiesta> listaRichieste= getListaRichieste();
      List<Offerta> listaOfferte = getListaOfferte();
      List<Prestazione> listaPrestazioni =getListaPrestazioni();
      List<Telefono> listaTelefoni = getListaTelefoni();
      List<ZonaDiRiferimento> listaZoneDiRiferimento=creaListaZonaRiferimento();
      
      List<Attivita> attivita= getAllAttivita();
      
       
       AttivitaService attvitaService=new AttivitaService();
       UtenteService utenteService = new UtenteService();
       PrenotazioneService prenotazioneService = new PrenotazioneService();
       SottoCategoriaService sottocategoriaService = new SottoCategoriaService();
       CategoriaService categoriaService = new CategoriaService();
       RichiestaService richiestaService = new RichiestaService();
       OffertaService offertaService = new OffertaService();
       PrestazioneService prestazioneService = new PrestazioneService();
       TelefonoService telefonoService = new TelefonoService();
       ZonaDiRiferimentoService zonaDiRiferimentoService = new ZonaDiRiferimentoService();
      
     for(Utente utente:listaUtenti) {
          utenteService.aggiungiUtente(utente);
     }
     for(Telefono telefono:listaTelefoni) {
         if(!utenti.isEmpty()) {
             int randIndex = random.nextInt(utenti.size());
             Utente randUtente = utenti.get(randIndex);
             telefono.setUtente(randUtente);
             
             
         }
         telefonoService.aggiungiTelefono(telefono);
         
     }
     System.out.println("TELEFONI UTENTE " + telefonoService.getTelefoniUtente());
     
     
     System.out.println("UTENTI " + utenteService.getUtenti());
     System.out.println("UTENTI 2 " + utenti);
   
    
     
      for(Prenotazione p:listaPrenotazioni) {
       if(!utenti.isEmpty()) {
           int randomIndex = random.nextInt(utenti.size());
           p.setUtente(utenti.get(randomIndex));
       }
          prenotazioneService.aggiungiPrenotazione(p);
       for(ZonaDiRiferimento zonaDiRiferimento:listaZoneDiRiferimento) {
        
           zonaDiRiferimento.setUtenti(utenti);
           zonaDiRiferimentoService.aggiungiZonaDiRiferimento(zonaDiRiferimento);
       }
        
          
      
          
      
     
     
     for(Categoria categoria : listaCategorie) {
         categoriaService.aggiungiCategoria(categoria);
   }
     for(Richiesta r:listaRichieste) {
         if(!utenti.isEmpty()) {
             int randIndex = random.nextInt(utenti.size());
             Utente randUtente = utenti.get(randIndex);
             r.setUtente(randUtente);
             
         }
         richiestaService.aggiungiRichiesta(r);
         
     }
     
     
     System.out.println("RICHIESTE FATTE UTENTI " + richiestaService.getRichiesteUtenti());
     
    
     
     
     for(Offerta offerta:listaOfferte){
         if(!utenti.isEmpty()){
             int randIndex = random.nextInt(utenti.size());
             Utente randUtente = utenti.get(randIndex);
             offerta.setUtente(randUtente);
             
         }
         offertaService.aggiungiOfferta(offerta);
     
     }
     System.out.println("OFFERTE FATTE UTENTI " + offertaService.getOfferteFatteUtente());
       System.out.println("CATEGORIE " + categoriaService.getCategorie());
     List<Categoria> categorie = getCategorie();
   
     for(SottoCategoria sottoCategoria:listaSottoCategorie) {
         if(!categorie.isEmpty()) {
         int randIndex = random.nextInt(categorie.size());
         Categoria randomCat = categorie.get(randIndex);
         sottoCategoria.setCategoria(randomCat);
         }
         sottocategoriaService.aggiungiSottoCategoria(sottoCategoria);
     }
     for(Prestazione prestazione:listaPrestazioni) {
         if(!attivita.isEmpty()) {
         int randIndex = random.nextInt(attivita.size());
         Attivita randAttivita = attivita.get(randIndex);
         prestazione.setAttivita(randAttivita);
         }
         prestazioneService.aggiungiPrestazione(prestazione);
         
     }
     System.out.println("PRESTAZIONI ATTIVITA " + prestazioneService.getPrestazioniAttivita());
     
 
      System.out.println("SOTTOCATEGORIE " + sottocategoriaService.getSottoCategorie());
    // System.out.println("UTENTI " + utenteService.getUtenti());
      
     
       System.out.println("PRENOTAZIONI "+prenotazioneService.getPrenotazioni());
       System.out.println("PRENOTAZIONI UTENTE " + prenotazioneService.getPrenotazioniUtente());
       
       
       listaAttivita.forEach(a-> {
         attvitaService.aggiungiAttivita(a);
       
       });
      // listaCategorie.
       
       
       listaUtenti.forEach(u->{
          
           u.setAttivita(attivita);
           utenteService.aggiungiUtente(u);
       });
//     System.out.println(utenteService.getUtenti());
       
      // List<AttivitaDto> risultatiAttivita = serviceAttivita.getAttivita();
      // System.out.println(risultatiAttivita);
       
// System.out.println(utenteService.getUtenti());
        
    }
   }
   private static List<Attivita> getAttivita() {
  return session.createNativeQuery("SELECT * FROM Attivita",Attivita.class).list();
       
   }
   
   private static Telefono creaTelefono(String numeroTelefono) {
       Telefono telefono=new Telefono();
       telefono.setNumeroTelefono(numeroTelefono);
       return telefono;
   }
   private static List<Telefono> getListaTelefoni() {
       Telefono   arrayTelefoni[]={creaTelefono("0183-650612"),creaTelefono("339-2335561")};
       return Arrays.asList(arrayTelefoni);
   }
   
   private static void singleTableQuery() {
    //   session.merge(arg0, session)
              final String sql1 = "SELECT * FROM utente";
       final String jpql1 = "from Utente as u" ;
       final String sql2 = "SELECT * from utente where nome='Davide'";
       final String jpql2 = "from Utente as u where u.nome=:x";
       final String sql3 = "SELECT Count(*) as cnt from utente";
       final String jpql3 = "SELECT COUNT(u) as cnt from Utente as u";
       final String sql4 = "SELECT COUNT(*) as cnt, indirizzo_email FROM utente GROUP BY indirizzo_email";
       final String jpql4 = "SELECT COUNT(u) as cnt, u.indirizzoEmail FROM Utente as u group by u.indirizzoEmail";
       
       var query1sql1 = session.createNativeQuery(sql1, Utente.class);
       System.out.println(query1sql1.list());
   }
private static Offerta creaOfferta(LocalDate dataOfferta) {
    Offerta offerta =  new Offerta();
    offerta.setDataOfferta(convertFromLocalDateToDate(dataOfferta));
    return offerta;
} 
private static List<Offerta> getListaOfferte(){
    Offerta[] arrayOfferte= {creaOfferta(LocalDate.of(2020, Month.NOVEMBER, 10))} ;
    return Arrays.asList(arrayOfferte);
}       
  private static Prestazione creaPrestazione(LocalDate dataPrestazione, int votoPrestazione){
       Prestazione prestazione = new Prestazione();
       prestazione.setVotoPrestazione(votoPrestazione);
       prestazione.setDataPrestazione(convertFromLocalDateToDate(dataPrestazione));
       return prestazione;
   }
   private static List<Prestazione> getListaPrestazioni() {
       Prestazione [] prestazioniArray = {creaPrestazione(LocalDate.of(2020, Month.NOVEMBER,20), 5), creaPrestazione(LocalDate.of(2020,Month.NOVEMBER, 10),4)};
       return Arrays.asList(prestazioniArray);
   } 
    
  private static void testQuery() {
     
       testQuerySingleTable();
       testJoinTables();
       testSubqueries();
   }

    private static void testQuerySingleTable() {
        final String sql1 = "SELECT * FROM Utente";
        final String jpql1 = "FRom Utente as u";
        final String sql2="SELECT * FROM Utente where nome='Davide'";
        final String jpql2 = "from Utente as u where u.nome=:x";
       final String sql3 = "SELECT Count(*) as cnt from utente";
       final String jpql3 = "SELECT cOUNT(u) as cnt from Utente as u";
              final String sql4 = "SELECT COUNT(*) as cnt, indirizzo_email FROM utente GROUP BY indirizzo_email";
       final String jpql4 = "SELECT COUNT(u) as cnt, u.indirizzoEmail FROM Utente as u group by u.indirizzoEmail";
        var querySql1 = session.createNativeQuery(sql1, Utente.class);
        List<UtenteDto> utentiDto = new ArrayList<>();
      // System.out.println(querySql1.list());
        for(Utente utente: querySql1.list()) {
            UtenteDto dto = new UtenteDto();
            dto.setEmail(utente.getIndirizzoEmail());
            dto.setCognome(utente.getCognome());
            dto.setNome(utente.getNome());
            dto.setPassword(Optional.of(utente.getPassword()));
            utentiDto.add(dto);
           
        }
      System.out.println(utentiDto);
      utentiDto.clear();
      
        var queryjpql1 = session.createQuery(jpql1, Utente.class);
       
        System.out.println(queryjpql1.list());
         for(Utente utente: queryjpql1.list()) {
            UtenteDto dto = new UtenteDto();
            dto.setEmail(utente.getIndirizzoEmail());
            dto.setCognome(utente.getCognome());
            dto.setNome(utente.getNome());
            dto.setPassword(Optional.of(utente.getPassword()));
            utentiDto.add(dto);
           
        }
      System.out.println(utentiDto);
      utentiDto.clear();
        
        
        var querysql2 = session.createNativeQuery(sql2, Utente.class);
       // System.out.println(querysql2.list());
        for(Utente utente: querysql2.list()) {
            UtenteDto dto = new UtenteDto();
            dto.setEmail(utente.getIndirizzoEmail());
            dto.setCognome(utente.getCognome());
            dto.setNome(utente.getNome());
            dto.setPassword(Optional.of(utente.getPassword()));
            utentiDto.add(dto);
           
        }
      System.out.println(utentiDto);
      utentiDto.clear();
       
        var queryjpql2 = session.createQuery(jpql2, Utente.class);
        
        queryjpql2.setParameter("x", "Davide");
      //  System.out.println(queryjpql2.list());
        var querysql3=session.createNativeQuery(sql3);
         for(Utente utente: queryjpql2.list()) {
            UtenteDto dto = new UtenteDto();
            dto.setEmail(utente.getIndirizzoEmail());
            dto.setCognome(utente.getCognome());
            dto.setNome(utente.getNome());
            dto.setPassword(Optional.of(utente.getPassword()));
            utentiDto.add(dto);
           
        }
      System.out.println(utentiDto);
      utentiDto.clear();
        
        //System.out.println(querysql3.getSingleResult());
        var queryjpql3 = session.createQuery(jpql3);
      //  System.out.println(querysql3.getSingleResult());
        var querysql4 = session.createNativeQuery(sql4, Tuple.class);
        List<UtenteGroupByDto> utentiGroupDto = new ArrayList<>();
        
         for(Tuple tuple: querysql4.list()) {
            UtenteGroupByDto dto = new UtenteGroupByDto();
            dto.setCount(tuple.get(0,BigInteger.class));
            dto.setIndirizzoEmail(tuple.get(1,String.class));
            
            utentiGroupDto.add(dto);
           
        }
      System.out.println(utentiGroupDto);
      utentiGroupDto.clear();
        
        //printListTuple(querysql4.list());
         for(Tuple tuple: querysql4.list()) {
            UtenteGroupByDto dto = new UtenteGroupByDto();
            dto.setCount(tuple.get(0, BigInteger.class));
            dto.setIndirizzoEmail(tuple.get(1,String.class));
            
            utentiGroupDto.add(dto);
           
        }
      System.out.println(utentiGroupDto);
      utentiGroupDto.clear();
        
        
        var queryjpql4 = session.createQuery(jpql4,Tuple.class);
       for(Tuple tuple: queryjpql4.list()) {
            UtenteGroupByDto dto = new UtenteGroupByDto();
            dto.setLongValue(tuple.get(0,Long.class));
            dto.setIndirizzoEmail(tuple.get(1,String.class));
            
            utentiGroupDto.add(dto);
           
         }
      System.out.println(utentiGroupDto);
      utentiGroupDto.clear();
    }
    private static void testJoinTables() {
           final String sql1 = "SELECT DISTINCT nome,cognome, id_attivita,nome_attivita FROM utente INNER JOIN attivita ON fk_utente =indirizzo_email";
       final String jpql1 = "SELECT DISTINCT u.nome, u.cognome,a.idAttivita, a.nomeAttivita from Attivita as a inner join a.utente as u";
       final String collectionQuery = "SELECT  a FROM Utente as u join u.attivita as a";
       final String sql2 = "SELECT DISTINCT nome,cognome,id_attivita,nome_attivita FROM utente LEFT OUTER JOIN attivita ON fk_utente =indirizzo_email";
       final String jpql2="SELECT  DISTINCT u.nome, u.cognome, a.idAttivita, a.nomeAttivita from Attivita as a left outer join a.utente as u";
       final String sql3 = "SELECT DISTINCT nome,cognome,id_attivita,nome_attivita FROM utente RIGHT OUTER JOIN attivita ON indirizzo_email=fk_utente";
       final String jpql3 = "SELECT DISTINCT u.nome,u.cognome,a.idAttivita,a.nomeAttivita FROM Attivita as a right outer join a.utente as u ";
       final String sql4 = "SELECT DISTINCT nome,cognome,id_attivita,nome_attivita FROM utente FULL OUTER JOIN attivita ON fk_utente=indirizzo_email";
       final String sql5 = "SELECT DISTINCT nome,cognome,id_attivita,nome_attivita FROM utente,attivita";
       final String jpql4 = "SELECT DISTINCT u.nome, u.cognome, a.idAttivita,a.nomeAttivita FROM Utente u, Attivita a";
       final String sql6 = "SELECT DISTINCT nome,cognome,id_attivita, nome_attivita FROM Utente,Attivita WHERE fk_utente=indirizzo_email";
     //  final String jpql5 = "SELECT DISTINCT  a.utente.nome, a.utente.nome, a.utente.cognome, a.idAttivita, a.nomeAttivita FROM Attivita as a";
       List<AttivitaJoinUtenteDto> joins = new ArrayList<>();
       var querysql1=session.createNativeQuery(sql1, Tuple.class);
      // printListTuple(querysql1.list());
      for(Tuple tuple: querysql1.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita=tuple.get(2, Integer.class);
          if(idAttivita!=null)
          dto.setIdAttivita(idAttivita);
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
      System.out.println(joins);
      joins.clear();
      
       var queryjpql1 = session.createQuery(jpql1, Tuple.class);
       // printListTuple(queryjpql1.list());
       queryjpql1.list().stream().map(tuple -> {
           var dto = new AttivitaJoinUtenteDto();
           dto.setNome(tuple.get(0, String.class));
           dto.setCognome(tuple.get(1, String.class));
           Integer idAttivita=tuple.get(2, Integer.class);
           if(idAttivita!=null)
               dto.setIdAttivita(idAttivita);
           dto.setNomeAttivita(tuple.get(3, String.class));
           return dto;
       }).forEachOrdered(dto -> {
           joins.add(dto);
       });
      System.out.println(joins);
      joins.clear();
       
       
      var queryCollection = session.createQuery(collectionQuery);
      List<CollectionDto> collections = new ArrayList<>();
      
       // stampaLista(queryCollection.list());
       //System.out.println("DIMENSIONE COLLECTION "+queryCollection.list().size());
       
         for(Object obj: queryCollection.list()) {
            //System.out.println("DENTRO FOR");
          var dto = new CollectionDto();
          List<CollectionDto> listColl = new ArrayList<>();
          
         // System.out.println(obj.getClass());
          if(!obj.getClass().isArray()) {
              if(obj instanceof Attivita){
                  Attivita att = (Attivita) obj;
                  AttivitaDto attDto = new AttivitaDto();
                  attDto.setNomeAttivita(att.getNomeAttivita());
                  if(attDto.getIdAttivita()!=null)
                    attDto.setIdAttivita(attDto.getIdAttivita());
                  dto.setCollection(Arrays.asList(attDto));
                  listColl.add(dto);
                  
              }
            }
          System.out.println(listColl);
         
                 
             }
             
         
          
          
      
       
         
       
       var querysql2 = session.createNativeQuery(sql2, Tuple.class);
      // printListTuple(querysql2.list());
        for(Tuple tuple: querysql2.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null)
            dto.setIdAttivita(idAttivita);
Integer id = tuple.get(2, Integer.class);
if(id!=null)
    dto.setIdAttivita(id);
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
        System.out.println(joins);
      joins.clear();
      
       var queryjpql2 = session.createQuery(jpql2, Tuple.class);
       //printListTuple(new HashSet<>(queryjpql2.list()));
        for(Tuple tuple: querysql2.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null)
            dto.setIdAttivita(idAttivita);
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
        System.out.println(joins);
       joins.clear();
       
       var querysql3=session.createNativeQuery(sql3,Tuple.class);
      // printListTuple(querysql3.list());
       for(Tuple tuple: querysql3.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null){
              dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
       System.out.println(joins);
      joins.clear();
       var queryjpql3=session.createQuery(jpql3, Tuple.class);
     // printListTuple(new HashSet<>(queryjpql3.list()));
      for(Tuple tuple: queryjpql3.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita=tuple.get(2, Integer.class);
          if(idAttivita!=null) {
              dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
      System.out.println(joins);
     joins.clear();
       var querysql4 = session.createNativeQuery(sql4, Tuple.class);
     //  printListTuple(querysql4.list());
      for(Tuple tuple: querysql4.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita=tuple.get(2, Integer.class);
          if(idAttivita!=null) {
              dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3, String.class));
          
          joins.add(dto);
      
      }
      System.out.println(joins);
      joins.clear();
     
      var querysql5 = session.createNativeQuery(sql5, Tuple.class);
   //   printListTuple(querysql5.list());
        for(var tuple: querysql5.list()) {
            var dto = new AttivitaJoinUtenteDto();
            dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null)
            dto.setIdAttivita(idAttivita);
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
      System.out.println(joins);
     joins.clear();
   
      var queryjpql4 = session.createQuery(jpql4, Tuple.class);
     // printListTuple(new HashSet<>(queryjpql4.list())); 
          for(Tuple tuple: queryjpql4.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null) {
          dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
      System.out.println(joins);
     joins.clear();
     
      var querysql6 = session.createNativeQuery(sql6, Tuple.class);
     //printListTuple(querysql6.list());
          for(Tuple tuple: querysql6.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita=tuple.get(2,Integer.class);
          if(idAttivita!=null) {
          dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3, String.class));
          joins.add(dto);
      }
      System.out.println(joins);
     joins.clear();
      var queryjpql5 = session.createQuery(jpql4, Tuple.class);
      //printListTuple(new HashSet<>(queryjpql5.list()));
           for(Tuple tuple: queryjpql5.list()) {
          var dto = new AttivitaJoinUtenteDto();
          dto.setNome(tuple.get(0, String.class));
          dto.setCognome(tuple.get(1, String.class));
          Integer idAttivita = tuple.get(2, Integer.class);
          if(idAttivita!=null) {
              dto.setIdAttivita(idAttivita);
          }
          dto.setNomeAttivita(tuple.get(3,String.class));
          joins.add(dto);
      }
      System.out.println(joins);
     joins.clear();
    } 
   
private static void printListTuple(Collection<Tuple> listTuple) {
    if(listTuple.isEmpty())  {
        System.out.println("LISTA TUPLE VUOTA");
        return;
    }
    
    listTuple.stream().map(tuple -> Arrays.deepToString(tuple.toArray())).forEachOrdered(msg -> {
        System.out.print(msg + " ");
        
        
       });
    
    
    System.out.println();
}

    private static List<Prenotazione> creaListaPrenotazioni() {
        LocalDate localDate1 = LocalDate.of(2020, Month.NOVEMBER, 11);
        LocalDate localDate2=LocalDate.of(2020, Month.DECEMBER,12);
        Prenotazione p1 = creaPrenotazione(convertFromLocalDateToDate(localDate1), new  Date(2020,11,20,14,30));
        Prenotazione p2 = creaPrenotazione(convertFromLocalDateToDate(localDate2), new Date(2020,12,11,18,50));
        
       return Arrays.asList(p1,p2);
    }
    private static Date convertFromLocalDateToDate(LocalDate localDate) {
    Date date =Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    return date;

}
    
    
private static Prenotazione creaPrenotazione(Date dataPrenotazione, Date oraPrenotazione) {
    Prenotazione prenotazione = new Prenotazione();
    prenotazione.setDataPrenotazione(dataPrenotazione);
    prenotazione.setOraPrenotazione(oraPrenotazione);
    return prenotazione;
}
private static Prenotazione creaPrenotazione(Date dataPrenotazione, Date oraPrenotazione, Utente utente) {
    Prenotazione prenotazione = new Prenotazione();
    prenotazione.setDataPrenotazione(dataPrenotazione);
    prenotazione.setOraPrenotazione(oraPrenotazione);
    prenotazione.setUtente(utente);
    return prenotazione;
}

    private static List<Categoria> getListaCategorie() {
      Categoria arrayCategorie[]={creaCategoria("lavori domestici")};
      List<Categoria> categorie=Arrays.asList(arrayCategorie);
      return categorie;
    }
    private static List<SottoCategoria> getSottoCategorie() {
       SottoCategoria sottocategorieArray[] ={ creaSottoCategoria("cucina"), creaSottoCategoria("inglese"),creaSottoCategoria("francese")};
       List<SottoCategoria> sottoCategorie=Arrays.asList(sottocategorieArray);
       return sottoCategorie;
        
    }
    private static List<Richiesta> getListaRichieste() {
        Richiesta [] arrayRichieste = {creaRichiesta(LocalDate.of(2020,Month.DECEMBER,11), "pulizia")};
        return Arrays.asList(arrayRichieste);
    
    }
    
    
    private static SottoCategoria creaSottoCategoria(String nomeSottoCategoria) {
        SottoCategoria s1 = new SottoCategoria();
        s1.setNomeSottoCategoria(nomeSottoCategoria);
        return s1;
        }
private static Categoria creaCategoria(String nomeCategoria) {
    Categoria c = new Categoria(nomeCategoria);
    return c;
}

    private static List<Categoria> getCategorie() {
      return session.createQuery("from Categoria as c ",Categoria.class).list();
      
      
      
    }

    private static Richiesta creaRichiesta(LocalDate dataRichiesta, String descr) {
        Richiesta r = new Richiesta();
        r.setDataRichiesta(convertFromLocalDateToDate(dataRichiesta));
        r.setDescrizione(descr);
        
        return r;
      
    }

    private static List<ZonaDiRiferimento> getZoneDiRiferimento() {
        final String jpql="SELECT * FROM zonadiriferimento";
        Query<ZonaDiRiferimento> query=session.createNativeQuery (jpql,ZonaDiRiferimento.class);
        return query.list();
    }

  
    
private static class Prova1 {
    private int x , y ;
    private List<Prova2> prova2;
    public Prova1() { 
        x = 5 ; y = 3;
        prova2 = new ArrayList<Prova2>();
        prova2.add(new Prova2());
}
}
private static class Prova2{
    private String x ;
  
    public Prova2() {
       
        x = "Mario ";
    }
}



private static void testSubqueries() {
    final String sql1="select nome, cognome, indirizzo_email FROM Utente WHERE indirizzo_email IN (SELECT fk_utente FROM Attivita)";
   final String jpql1 = " select u.nome, u.cognome,u.indirizzoEmail FROM Utente  as u  where u.indirizzoEmail IN (SELECT a.utente.indirizzoEmail FROM Attivita as a )";
    var querysql1 = session.createNativeQuery(sql1, Tuple.class);
    final String sql2 = "select nome, cognome, indirizzo_email FROM Utente WHERE indirizzo_email NOT IN (SELECT fk_utente FROM Attivita)";
    var querysql2 = session.createNativeQuery(sql2, Tuple.class);
   //printListTuple(querysql2.list());
    var queryjql1 = session.createQuery(jpql1, Tuple.class);
  //  printListTuple(queryjql2.list());
  List<UtenteDto> utenti = new ArrayList<>();
  for(Tuple tuple: querysql1.list()) {
      UtenteDto dto = new UtenteDto();
      dto.setNome(tuple.get(0,String.class));
      dto.setCognome(tuple.get(1, String.class));
      dto.setEmail(tuple.get(2, String.class));
      utenti.add(dto);
  }
  System.out.println(utenti);
    utenti.clear();
 for(Tuple tuple: queryjql1.list()) {
      UtenteDto dto = new UtenteDto();
      dto.setNome(tuple.get(0,String.class));
      dto.setCognome(tuple.get(1, String.class));
      dto.setEmail(tuple.get(2, String.class));
      utenti.add(dto);
  }
  System.out.println(utenti);
    utenti.clear();
     for(Tuple tuple: querysql2.list()) {
      UtenteDto dto = new UtenteDto();
      dto.setNome(tuple.get(0,String.class));
      dto.setCognome(tuple.get(1, String.class));
      dto.setEmail(tuple.get(2, String.class));
      utenti.add(dto);
  }
  System.out.println(utenti);
    utenti.clear();
   
  }
 












       
       
       
       
       
       
       
       
       private static void printXmlFile() {
            try {
           DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
           
           DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
           Document document =documentBuilder.parse(new File("src/db/hibernate.cfg.xml"));
           Transformer transformer =TransformerFactory.newInstance().newTransformer();
           transformer.setOutputProperty(OutputKeys.INDENT,"yes");
           StreamResult result = new StreamResult(new StringWriter());
           DOMSource source = new DOMSource(document);
           transformer.transform(source, result);
           String xmlString = result.getWriter().toString();
           System.out.println(xmlString);
           
       } catch (IOException | ParserConfigurationException | TransformerConfigurationException | SAXException ex) {
           Logger.getLogger(BancadeltempoHibernate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (TransformerException ex) {
           Logger.getLogger(BancadeltempoHibernate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       }
       
      
   
   
   
    private static void testXMLFile() {
      // printXmlFile();
       try {
          final String fileName1="src/db/Attivita.hbm.xml";
          File file = new File(fileName1);
          final String fileName2="src\\db\\hibernate.cfg.xml";
          
           DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
           
           DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
           try {
               Document document =documentBuilder.parse(file);
               NodeList nodeList=document.getElementsByTagName("*");
           for(int i = 0; i<nodeList.getLength(); i++) {
               Element element = (Element) nodeList.item(i);
               System.out.println("valore tag " + String.valueOf(i+1)+" "+element.getTagName());
               System.out.println("valore contenuto elemento " + String.valueOf(i+1)+ " "+ element.getTextContent());
              
             NamedNodeMap map = element.getAttributes();
             for(int j = 0; j< map.getLength();j++ ) {
                    System.out.println("Nome atributo "+ String.valueOf(j+1)+ " "+map.item(j).getNodeName());
                 System.out.println("Valore contenuto "+ String.valueOf(j+1)+ " "+map.item(j).getTextContent());
                
             }
             
           }
               
           } catch (SAXException | IOException ex) {
               Logger.getLogger(BancadeltempoHibernate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
           }
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(BancadeltempoHibernate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
      
      
    }
    

   
    
    private static void inserisciAttivita(Attivita a) {
     
        
            session.getTransaction().begin();
            try {
               
               session.saveOrUpdate(a);
                session.getTransaction().commit();
                
                
            }catch(Exception ex) {
                if(session!=null) {
                    Transaction transaction=session.getTransaction();
                    if(transaction!=null) {transaction.rollback();}
                }
            }
    }  
   
    
    
    private static List<Attivita> getAttivitaFatteUtente(String indirizzoEmail) {
        final String jpql = " FROM Attivita as a INNER JOIN a.utente as u where u.indirizzoEmail=:x";
        
        var query = session.createQuery(jpql,Tuple.class);
        query.setParameter("x", indirizzoEmail);
        var tupleList = query.list();
        System.out.println("DEBUG  METODO getAttivitaFatteUtente 1");
        printListTuple(tupleList);
        final String jpql2="FROM Attivita as a INNER JOIN a.utente as u";
        var query2 = session.createQuery(jpql2, Tuple.class);
             System.out.println("DEBUG  METODO getAttivitaFatteUtente 2");
        printListTuple(query2.list());
        
       List<Attivita> result = new ArrayList<>();
        
        
        return result;
    }

    private static List<Utente> creaListaUtenti() {
   
    
        Utente utente1 = creaUtente("Davide","Acquarone","davideinfo4@gmail.com","davideinformatica");
        Utente utente2 = creaUtente("Giovanni","Rossi","giovannirossi@hotmail.it","giovannirossi123");
        Utente utente3= creaUtente("Roberta", "Romagoli", "robertaromagnoli@libero.it","robertaromagnoli56");
       // System.out.println("INDIRIZZO EMAIL "+utente1.getIndirizzoEmail());
       // var lista1=getAttivitaFatteUtente(utente1.getIndirizzoEmail());
       //System.out.println("DEBUG LISTA 1 "+lista1);
        //utente1.setAttivita(lista1);
        
   //  utente1.setAttivita(tutteAttivita);
        
       
        
        return Arrays.asList(utente1,utente2,utente3);
        
         //To change body of generated methods, choose Tools | Templates.
    
    }
    private static List<Utente> creaListaUtentiSenzaAttivita() {
        List<Utente> utenti;
          Utente utente1 = creaUtente("Davide","Acquarone","davideinfo4@gmail.com","davideinformatica");
        Utente utente2 = creaUtente("Giovanni","Rossi","giovannirossi@hotmail.it","giovannirossi123");
        utenti = Arrays.asList(utente1, utente2);
        return utenti;
        
    }
    
    
    private static Utente creaUtente(String nome, String cognome, String email, String password) {
        Utente utente = new Utente();
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setIndirizzoEmail(email);
        utente.setPassword(password);
        return utente;
    
    }

   private static List<ZonaDiRiferimento> creaListaZonaRiferimento() {
     List<ZonaDiRiferimento> listaZona = Arrays.asList(creaZonaDiRiferimento("Imperia"));
     return listaZona;
    }

           

   private static ZonaDiRiferimento creaZonaDiRiferimento(String citta) {
    ZonaDiRiferimento zona = new ZonaDiRiferimento();
    zona.setCitta(citta);
        
        return zona;
}         
   private static Utente creaUtente(String nome, String cognome, String email, String password, ZonaDiRiferimento zona, Attivita...attivita) {
       Utente utente = new Utente();
       utente.setNome(nome);
       utente.setCognome(cognome);
       utente.setPassword(password);
       utente.setZona(zona);
       if(attivita.length>0)
        utente.setAttivita(Arrays.asList(attivita));
       
       return utente;
   
   } 
   
   
   
   private static Attivita creaAttivita(String nome, Utente utente) {
       Attivita attivita= new Attivita();
       attivita.setNomeAttivita(nome);
       attivita.setUtente(utente);
     
       return attivita;
   }
    private static Attivita creaAttivita(String nome, Utente utente, SottoCategoria sottocategoria) {
       Attivita attivita= new Attivita();
       attivita.setNomeAttivita(nome);
       attivita.setUtente(utente);
       attivita.setSottoCategoria(sottocategoria);
     
       return attivita;
   }

    private static void inserisciUtente(Utente utente) {
        session.getTransaction().begin();
        session.saveOrUpdate(utente);
        session.getTransaction().commit();
       
    }
    private static Attivita aggiungiAttivita(String nomeAttivita) {
        Attivita attivita = creaAttivita(nomeAttivita);
        inserisciAttivita(attivita);
        return attivita;
    }

    private static void aggiornaUtente(Utente utente) {
        
        session.getTransaction().begin();
        session.merge(utente);
        session.getTransaction().commit();
       
      
    }
    private static void aggiungiPrenotazione(Prenotazione p) {
        session.getTransaction().begin();
        session.save(p);
        session.getTransaction().commit();
    }

    private static void stampaEccezione(Exception ex) {
        String msg = "Eccezione della classe del tipo catturata " + ex.getClass()+ " Messaggio eccezione : " + ex.getMessage();
       
     Throwable t = ex.getCause();
     if(t!=null) {
         msg+= "Eccezione incapsulata del tipo "+ t.getClass().toString() + " messaggio eccezione icapsulata  "+ t.getMessage();
         System.err.println(msg);
     }
    }

    private static List<Utente> getUtenti2() {
    final String myQuery = "from Utente as u" ;
    Query<Utente> query=session.createQuery(myQuery, Utente.class);
    List<Utente> utenti = query.list();
    //System.out.println(utenti.size());
    
    return utenti;
    
    
    }
   
}    
        
