/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author win
 */
public class UtenteDto {
    private String nome ;
    private String cognome ;
    private Optional<String> password ;
    private int saldoOre;
  
    private String email ;

    @Override
    public String toString() {
        return "UtenteDto{" + "nome=" + nome + ", cognome=" + cognome + ", password=" + password + ", "+ "email ="+email+" saldoOre="+saldoOre+"}";
    }
    public void setSaldoOre(int saldoOre) {
        this.saldoOre=saldoOre;
    }
    public int getSaldoOre() {return saldoOre;}
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.email);
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
        final UtenteDto other = (UtenteDto) obj;
        return other.email.equals(email);
    }
    public UtenteDto() {
        password = Optional.empty();
    }
    public UtenteDto(String nome, String cognome, String email, Optional<String> password, int saldoOre) {
      
        setNome(nome);
        setCognome(cognome);
        setEmail(email);
        setPassword(password);
        setSaldoOre(saldoOre);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome ;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setPassword(Optional<String> password) {
        this.password = Objects.requireNonNull(password);
    }

   
  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }
}
