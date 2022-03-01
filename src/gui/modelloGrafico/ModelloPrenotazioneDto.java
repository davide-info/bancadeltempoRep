/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import dto.PrenotazioneDto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author win
 */
public class ModelloPrenotazioneDto extends MioModelloTabella<PrenotazioneDto> {
    private final String colonne[];
    public ModelloPrenotazioneDto() {
        colonne=new String[]{"id_prenotazione","data_prenotazione","nome_utente","cognome_utente","saldo_ore"};
    }

    @Override
    public Object getValueAt(PrenotazioneDto t, int colonna) {
       switch(colonna){
           case 0: return t.getIdPrenotazione();
           case 1:
               DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
               Date dataPrenotazione = java.sql.Date.valueOf(t.getDataPrenotazione());
               return format.format(dataPrenotazione);
               
           case 2: if(t.getUtente().isPresent()) {
               return t.getUtente().get().getNome();
               
               
           }
           return "";
           case 3: if(t.getUtente().isPresent()) {
               return t.getUtente().get().getCognome();
           }
           
            return "";
           case 4: 
               if(t.getUtente().isPresent()) {
                   return t.getUtente().get().getSaldoOre();
               }
               return "";
           
           
       
       }
       return null;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int colonna) {
       return colonne[colonna]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return colonne.length; //To change body of generated methods, choose Tools | Templates.
    }
    
}
