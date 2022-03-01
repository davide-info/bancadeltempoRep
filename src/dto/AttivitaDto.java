/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;



/**
 *
 * @author win
 */
public class AttivitaDto {
    private Integer idAttivita ;

    @Override
    public String toString() {
        return "AttivitaDto(" + "idAttivita=" + idAttivita + ", nomeAttivita=" + nomeAttivita + ')';
    }
    private String nomeAttivita ;
   public AttivitaDto() {
   }
   public AttivitaDto(int idAttivita, String nomeAttivita) {
       setNomeAttivita(nomeAttivita);
       setIdAttivita(idAttivita);
   }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AttivitaDto other = (AttivitaDto) obj;
        if (this.idAttivita != other.idAttivita) {
            return false;
        }
        return true;
    }
   
   public void setNomeAttivita(String nomeAttivita) {
       this.nomeAttivita= nomeAttivita;
   }
   public Integer getIdAttivita() {
        return idAttivita;
   }
   public String getNomeAttivita() {return nomeAttivita;}

    public void setIdAttivita(int idAttivita) {
       this.idAttivita=idAttivita;
    }
   
   
   
    
}
