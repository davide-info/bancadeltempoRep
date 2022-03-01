/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import dto.UtenteDto;

/**
 *
 * @author win
 */
public class ModelloUtenteDto extends MioModelloTabella<UtenteDto>{
    private String [] colonne ;
    public ModelloUtenteDto() {
        colonne = new String[]{"nome","cognome","indirizzo email","saldo ore"};
    }
    
    
    @Override
    public Object getValueAt(UtenteDto t, int colonna) {
        //System.out.println("Colonna " + colonna);
       switch(colonna) {
           
           case 0: return t.getNome();
           case 1: return t.getCognome();
           case 2: return t.getEmail();
           case 3: return t.getSaldoOre();
       }
           
       return null;
    }

    @Override
    public String getColumnName(int colonna) {
     
      return colonne[colonna];
    }

    @Override
    public int getColumnCount() {
       return colonne.length; //To change body of generated methods, choose Tools | Templates.
    }
    
}
