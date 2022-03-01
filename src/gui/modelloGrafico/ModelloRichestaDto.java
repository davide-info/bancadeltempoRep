/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import dto.RichiestaDto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 *
 * @author win
 */
public class ModelloRichestaDto extends MioModelloTabella<RichiestaDto> {
private final String colonne[];

public ModelloRichestaDto() {
    colonne=new String[]{"id_richiesta","data_richiesta","nome_utente","cognome_utente","saldo_ore","attivita_richiesta"};

}
    @Override
    public Object getValueAt(RichiestaDto t, int colonna) {
       switch(colonna) {
           case 0: return t.getIdRichiesta();
           case 1: Date dataRichiesta = java.sql.Date.valueOf(t.getDataRichiesta());
                    DateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
                    return formatter.format(dataRichiesta);
           case 2: 
               if(t.getUtente().isPresent()) return t.getUtente().get().getNome();
           else return "";
           case 3: if(t.getUtente().isPresent()) {
               return t.getUtente().get().getCognome();
           }
               else 
               return "";
           
       
       case 4: 
       if(t.getUtente().isPresent()) {
           return t.getUtente().get().getSaldoOre();
    }
       else return "";
       case 5:
    if(t.getAttivita().isPresent()) {
        return t.getAttivita().get().getNomeAttivita();
    }
    else return "";
          
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
