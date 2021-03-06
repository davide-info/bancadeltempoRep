/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.AttivitaDto;
import dto.UtenteDto;
import entita.Attivita;
import entita.Richiesta;
import entita.Utente;
import gui.modelloGrafico.ModelloRichestaDto;
import java.util.Date;
import java.util.Optional;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import service.AttivitaService;
import service.RichiestaService;
import service.UtenteService;

/**
 *
 * @author win
 */
public class InserisciRichiesta extends javax.swing.JFrame {
    private RichiestaService richiestaService ;
    private UtenteService utenteService;
    private AttivitaService attivitaService;
    

    /**
     * Creates new form InserisciRichiesta
     */
    public InserisciRichiesta() {
        richiestaService=new RichiestaService();
        attivitaService=new AttivitaService();
        utenteService=new UtenteService();
      JOptionPane.showMessageDialog(rootPane,"RICHIESTE ATTIVITA " + richiestaService.getRichiesteUtenti());
      
        
        
        initComponents();
        initComboxes();
        rimuoviRigheEColonneTabella();
    }
    
     private void rimuoviRigheEColonneTabella() {
          DefaultTableModel model =(DefaultTableModel) tabella.getModel();
            for(int i = model.getRowCount()-1; i>=0; i--)
           model.removeRow(i);
       TableColumnModel tableModel = tabella.getColumnModel();
     for(int i = tableModel.getColumnCount()-1; i>=0; i--) {
         TableColumn tcol = tableModel.getColumn(i);
         tabella.removeColumn(tcol);
    }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selezioneData = new com.toedter.calendar.JDateChooser();
        inserisciRichiestaBtn = new javax.swing.JButton();
        selezioneAttivita = new javax.swing.JComboBox<>();
        selezioneUtente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inserisciRichiestaBtn.setText("INSERISCI RICHIESTA");
        inserisciRichiestaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisciRichiestaBtnActionPerformed(evt);
            }
        });

        selezioneAttivita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        selezioneUtente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Inserisci la data della richiesta");

        jLabel2.setText("Inserisci l'attivita");

        jLabel3.setText("Inserisci l'indirizzo email dell'utente che ha richiesto l'attivit??");

        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabella);

        jButton1.setText("MOSTRA TABELLA RICHIESTE UTENTI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(inserisciRichiestaBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(selezioneData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142)
                        .addComponent(selezioneAttivita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(selezioneUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selezioneData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selezioneAttivita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selezioneUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(inserisciRichiestaBtn)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserisciRichiestaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserisciRichiestaBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("QUA");
        Date data = this.selezioneData.getDate();
       String messaggio = controllaParametro(data);
   
       
        if(messaggio.equals("OK")) {
            Richiesta richiesta = new Richiesta();
            richiesta.setDataRichiesta(data);
            String attivitaScelta = (String) this.selezioneAttivita.getSelectedItem();
            String indirizzoEmail =(String) selezioneUtente.getSelectedItem();
      
           Optional<Attivita> attivitaOpt=attivitaService.trovaNomeAttivita(attivitaScelta);
        
            Optional<Utente> utenteOPt = utenteService.trovaEmailUtente(indirizzoEmail);
           
          if(attivitaOpt.isPresent()) {
           // System.out.println("ATTIVITA PRESENTE");
          
              richiesta.setAttivita(attivitaOpt.get());
             // System.out.println("ATTIVITA RICHIESTA " + richiesta.getAttivita());
          
          
          }
          if(utenteOPt.isPresent()) {
          
              richiesta.setUtente(utenteOPt.get());
             
          }
          richiestaService.aggiungiRichiesta(richiesta);
          JOptionPane.showMessageDialog(null, "la richiesta ?? stata aggiunta correttamente");
        
             
        }
        else {
            JOptionPane.showMessageDialog(null, " messaggio errore " + messaggio);
           
        }
  
        
    }//GEN-LAST:event_inserisciRichiestaBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       ModelloRichestaDto modello = new ModelloRichestaDto();
       modello.setLista(richiestaService.getRichiesteUtenti());
       tabella.setModel(modello);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InserisciRichiesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserisciRichiesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserisciRichiesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserisciRichiesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InserisciRichiesta ir = new InserisciRichiesta();
              ir.setVisible(true);
              ir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inserisciRichiestaBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selezioneAttivita;
    private com.toedter.calendar.JDateChooser selezioneData;
    private javax.swing.JComboBox<String> selezioneUtente;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

    private void initComboxes() {
        selezioneAttivita.removeAllItems();
        selezioneUtente.removeAllItems();
        for(UtenteDto utente: utenteService.getUtenti()) {
            selezioneUtente.addItem(utente.getEmail());
        }
        for(AttivitaDto attivita: attivitaService.getAttivita()) {
            selezioneAttivita.addItem(attivita.getNomeAttivita());
        }
    }

    private String controllaParametro(Date data) {
        String messaggio="OK";
        if(data==null) messaggio=" data prenotazione ?? nulla";
        return messaggio;
    }
}
