/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import dto.AttivitaJoinUtenteDto;

/**
 *
 * @author win
 */
public class ModelloAttivitaDto extends MioModelloTabella<AttivitaJoinUtenteDto> {
    private final String [] colonne ;
    public ModelloAttivitaDto() {
        colonne=new String[]{"id_attivita", "nome_attività","nome_utente","cognome_utente","indirizzo_email"};
    }
    @Override
    public Object getValueAt(AttivitaJoinUtenteDto t, int colonna) {
       switch(colonna){
           case 0: return t.getIdAttivita();
           case 1: return t.getNomeAttivita();
           case 2: return t.getNome();
           case 3:return t.getIndirizzoEmail();
           case 4: return t.getIndirizzoEmail();
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
