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
public class SottoCategoriaDto {
    private int idSottoCategoria;
    private String nomeSottoCategoria;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SottoCategoriaDto{idSottoCategoria=").append(idSottoCategoria);
        sb.append(", nomeSottoCategoria=").append(nomeSottoCategoria);
        sb.append('}');
        return sb.toString();
    }
    public SottoCategoriaDto() {}
    public SottoCategoriaDto(int idSottoCategoria,String nomeSottoCategoria) {
        setIdSottoCategoria(idSottoCategoria);
        setNomeSottoCategoria( nomeSottoCategoria);
    }

    public int getIdSottoCategoria() {
        return idSottoCategoria;
    }

    public void setIdSottoCategoria(int idSottoCategoria) {
        this.idSottoCategoria = idSottoCategoria;
    }

    public String getNomeSottoCategoria() {
        return nomeSottoCategoria;
    }

    public void setNomeSottoCategoria(String nomeSottoCategoria) {
        this.nomeSottoCategoria = nomeSottoCategoria;
    }
    
    
}
