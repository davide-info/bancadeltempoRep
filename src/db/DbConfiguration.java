/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author win
 */
public class DbConfiguration {

  
    /*
    Configurazione file con xml Hibernate 
    TO DO bisogna creare il file di configarazione hibernate.cfg.xml
     FUNZIONA
    */
        private static SessionFactory configureXMLFile() {
              SessionFactory factory = null;
            
          File file = new File(relativePathName);
         // System.out.println("FILE "+file.toString());
       
            Configuration conf=new Configuration().configure(file);
            
         
     factory = conf.buildSessionFactory();
           
        return factory;
            
    }
   

    
    
    
    private enum ConfigurationType {XML, WITHOUTXML}
    private final ConfigurationType configurationType =ConfigurationType.XML;
    private static String name="hibernate";
    private static String directory="src/db";
    private static String sqlDialectClass;
    
    private static  String fileName = name+".cfg"+".xml";
      private   static String hostName="localhost";
       private static String relativePathName=new File(directory+"/"+fileName).getPath();
      
    private   static String jdbcURL;
    private static  String dbName = "tesi";
    private static  String dbms;
    private static String dbmsName="postgres";
    private static  String driverName;
    private static String userName="postgres";
    private static String password="davide";
    //private 
    private SessionFactory factory;
    private Session session;
    private Transaction transaction ;
   static {
      
        if(dbmsName.charAt(dbmsName.length()-1)!='s') {
            dbms = dbmsName+"sql";
        }
        else dbms=dbmsName+"ql";
        jdbcURL = "jdbc:" + dbms +"://" +hostName + ("/"+dbName);
          //  System.out.println("URL jdbc " + jdbcURL);
            
            
          
            driverName="org." + dbms+".Driver";
            String dialectName = Character.toUpperCase(dbmsName.charAt(0))+dbmsName.substring(1);
         sqlDialectClass="org.hibernate.dialect."+ dialectName+"SQL"+"Dialect";
      //  System.out.println("sqlDialectClass "+sqlDialectClass);
     
   }
    
    public DbConfiguration() {
                /* PER DISATTIVARE IL WARNING Illegal reflective access by com.sun.xml.bind.v2.runtime.reflect.opt.Injector$1 */
          System.setProperty("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize","true");
        /* PER DISATTIVARE IL LOGGING DI HIBERNATE*/
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);


        /* FUNZIONA */
        if(configurationType == ConfigurationType.WITHOUTXML){ 
        if(factory==null) {
            Configuration conf =initConfigurationProperties();
            StandardServiceRegistry serviceRegistry = createRegistryAndAnnotateClasses(conf);

            this.factory=conf.buildSessionFactory(serviceRegistry);
           
            
            
        }
        }
        else {
            if(factory==null)
            this.factory =configureXMLFile();
        }
        if(this.session == null && this.transaction==null) {
         this.session = factory.openSession();
            this.transaction = session.getTransaction();
        }
         
        
    }
   //public Transaction getTransaction() {return transaction;}
    public void beginTransaction() {transaction.begin();}
    public void commitTransaction() { transaction.commit();}
    public void rollBackTransaction() {transaction.rollback();}
    public void closeSession() {session.close();}
    public void disconnectSession() {session.disconnect();}
    
    private static void addAnnotatedClasses(Configuration conf) {
              conf.addAnnotatedClass(Attivita.class);
            conf.addAnnotatedClass(Categoria.class);
            conf.addAnnotatedClass(Offerta.class);
            conf.addAnnotatedClass(Prenotazione.class);
            conf.addAnnotatedClass(Prestazione.class);
            conf.addAnnotatedClass(Richiesta.class);
            conf.addAnnotatedClass(SottoCategoria.class);
            conf.addAnnotatedClass(Telefono.class);
            conf.addAnnotatedClass(Utente.class);
            conf.addAnnotatedClass(ZonaDiRiferimento.class);
    }
    
    private static StandardServiceRegistry createRegistryAndAnnotateClasses(Configuration conf) {
            addAnnotatedClasses(conf);
             
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            
            StandardServiceRegistry serviceRegistry = builder.applySettings(conf.getProperties()).build();
             
            return serviceRegistry;
    }
    
    
    private static Configuration initConfigurationProperties() {
             Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost/tesi");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.USER, "postgres");
     
        properties.setProperty(Environment.PASS, "davide");
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.SHOW_SQL,"false");
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
       
        
     Configuration conf1 = conf.addProperties(properties);
       
       return conf1;
    }
   
        
   
    public Session getSession() { return session;}
    public void closeFactory() {
        factory.close();
    }
    
}
