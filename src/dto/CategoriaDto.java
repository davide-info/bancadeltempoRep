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
public class CategoriaDto {

    @Override
    public String toString() {
        return "CategoriaDto{" + "idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + '}';
    }
    private int idCategoria;
    private String nomeCategoria ;
    public CategoriaDto() {}
public CategoriaDto(int idCategoria,String nomeCategoria) {
    setIdCategoria(idCategoria);
    setNomeCategoria(nomeCategoria);

}

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
    
}
