/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import dto.OffertaDto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author win
 */
public class ModelloOffertaUtenteDto extends MioModelloTabella<OffertaDto> {
    private String[] colonne = new String[]{"id_offerta", "data_offerta","nome utente", "cognome Utente","saldo ore","nome Attivita"};

    @Override
    public Object getValueAt(OffertaDto t, int colonna) {
      switch(colonna) {
          case 0: return t.getIdOfferta();
          
          case 1: DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
          Date dataOfferta = java.sql.Date.valueOf(t.getDataOfferta());
          return format.format(dataOfferta);
          
          case 2: 
              if(t.getUtente().isPresent()) 
                  return t.getUtente().get().getNome();
          else return "";
          case 3:
              if(t.getUtente().isPresent()) {
                 return t.getUtente().get().getCognome();
              }
               else return "";
              
          case 4: 
              if(t.getUtente().isPresent()) {
                  return t.getUtente().get().getSaldoOre();
              }
              else return "";
              
          case 5:
              if(t.getAttivita().isPresent()) return t.getAttivita().get().getNomeAttivita();
              else return "";
              
                      
      }
      return null;
      
    }

    @Override
    public String getColumnName(int colonna) {
        return colonne[colonna]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return colonne.length;
              //To change body of generated methods, choose Tools | Templates.
    }
    
}
