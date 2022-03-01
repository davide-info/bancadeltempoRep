/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.UtenteDto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import service.UtenteService;

/**
 *
 * @author win
 */
public class ProvaGUI extends JFrame{
   private JTable tabella;
   private JScrollPane scrollPane;
   private JTextField campoTesto;
   public ProvaGUI() {
       inizializzaComponenti();
      
    
       
      
     pack();
  
   }
  
  
  
   
    private void inizializzaComponenti() {
        setLayout(new FlowLayout());
        tabella = new JTable();
         campoTesto=new JTextField();
  
   tabella.setModel(creaModello());
    campoTesto.setAutoscrolls(true);
        
       campoTesto.setEditable(true);
       campoTesto.setColumns(10);
        
       
        
        
        
       scrollPane = new JScrollPane(tabella);
        add(scrollPane);
        campoTesto.addKeyListener(new MiaTastiera());
        add(this.campoTesto);
        
        
        pack();
       //To change body of generated methods, choose Tools | Templates.
    }
    
     private static abstract class MioModello<T> extends AbstractTableModel {
         private List<T> lista ;

        public List<T> getLista() {
            return lista;
        }
        

        public void setLista(List<T> lista) {
            this.lista = lista;
        }
         public MioModello() {
             lista = new ArrayList<>();
         }
         @Override
         public int getRowCount() {
             return lista.size();
         }
         public abstract Object getValueAt(T t, int colonna);
         @Override
         public Object getValueAt(int riga, int colonna){
             T t = lista.get(riga);
             return getValueAt(t, colonna);
         }
         @Override
         public abstract String getColumnName(int colonna);
         
   }
     
  private static class MioModelloUtente extends MioModello<UtenteDto> {
   
        @Override
        public Object getValueAt(UtenteDto t, int colonna) {
            switch(colonna) {
                case  0: return t.getNome();
                case 1 : return t.getCognome();
                case 2: return t.getEmail();
                case 3: return t.getSaldoOre();
            }
            return null;
            
        }

        @Override
        public String getColumnName(int colonna) {
           switch(colonna){
               case 0: return "nome";
               case 1: return "cognome";
               case 2: return "email";
               case 3: return "saldo ore";
           }
           return null;//To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getColumnCount() {
           return 4;//To change body of generated methods, choose Tools | Templates.
        }
    }   
    

    private TableModel creaModello() {
        MioModelloUtente model = new MioModelloUtente();
        UtenteService us = new UtenteService();
        model.setLista(us.getUtenti());
        return model;
    }
  
  
   public static void main(String[] args) {
       ProvaGUI pg = new ProvaGUI();
       pg.setVisible(true);
       pg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   private static class MiaTastiera implements KeyListener {

        @Override
        public void keyTyped(KeyEvent arg0) {
          System.out.println("CARATTERE "+arg0.getKeyChar()); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent arg0) {
          System.out.println("CARATTERE PREMUTO " + arg0.getKeyChar()); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
              System.out.println("CARATTERE RILASCIATO  " + arg0.getKeyChar());
        }
   
   }
   private static class MioEvento implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
   }
    
}
