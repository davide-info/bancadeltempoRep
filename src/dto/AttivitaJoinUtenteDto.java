/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Objects;

/**
 *
 * @author win
 */
public class AttivitaJoinUtenteDto {
  private String nome ;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("( "+getClass().getSimpleName());
        sb.append(" nome = ").append(nome);
        sb.append(" cognome = ").append(cognome);
        sb.append(" indirizzoEmail = ").append(indirizzoEmail);
        sb.append(" idAttivita = ").append(idAttivita);
        sb.append(" nomeAttivita = ").append(nomeAttivita);
        
        sb.append(" )\n");
        return sb.toString();
    }
    
  private String cognome ;
  private String indirizzoEmail;
  private String nomeAttivita;
  private int idAttivita;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public int getIdAttivita() {
        return idAttivita;
    }
  public AttivitaJoinUtenteDto() {}
  public AttivitaJoinUtenteDto(String nome, String cognome, String indirizzoEmail, int idAttivita, String nomeAttivita) {
      setNome(nome);
      setCognome(cognome);
      setNomeAttivita(nomeAttivita);
      setIdAttivita(idAttivita);
      setIndirizzoEmail(indirizzoEmail);
  
  }
  public void setNome(String nome) {this.nome=nome;}
  public void setCognome(String cognome) {this.cognome=cognome;}

   public  void setNomeAttivita(String nomeAttivita) {
     this.nomeAttivita=nomeAttivita;
    }

   public void setIdAttivita(int idAttivita) {
      this.idAttivita=idAttivita;
    }

    public void setIndirizzoEmail(String indirizzoEmail) {
      this.indirizzoEmail = indirizzoEmail;
    }
 
    public Object [] toArrayRows() {
        Object[] results = new Object[]{this.nome,this.cognome,this.indirizzoEmail,this.idAttivita,this.nomeAttivita};
        return results;
    }
}
