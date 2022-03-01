/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelloGrafico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author win
 */
public abstract class MioModelloTabella<T> extends AbstractTableModel{
    private List<T> lista ;
    protected MioModelloTabella() {
        lista = new ArrayList<>();
    }

    public List<T> getLista() {
        return lista;
    }
    @Override
    public int getRowCount() {return lista.size();}

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
   
   public abstract Object getValueAt(T t, int colonna);
   @Override
   public Object getValueAt(int riga, int colonna) {
      T t = lista.get(riga);
      return getValueAt(t, colonna);
   }
    @Override
 public abstract String getColumnName(int colonna);
    
}
