/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigInteger;

/**
 *
 * @author win
 */
public class UtenteGroupByDto {
    private BigInteger count ;
    private String indirizzoEmail ;
    private Long longCount;

    @Override
    public String toString() {
        return "UtenteGroupByDto{" + "count=" + count + ", indirizzoEmail=" + indirizzoEmail + '}';
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }
    public Long getLongValue() {return this.count.longValue();}
    
    
    public UtenteGroupByDto() {}
    public UtenteGroupByDto(BigInteger count, String indirizzoEmail) {
        setCount(count);
        setIndirizzoEmail(indirizzoEmail);
    }

    public void setLongValue(Long get) {
        this.longCount = get;
    }
    
}
