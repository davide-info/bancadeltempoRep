/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author win
 */
public class CollectionDto {

    @Override
    public String toString() {
        return "CollectionDto{" + "collection=" + collection + '}';
    }
    private Collection<AttivitaDto> collection;
    public CollectionDto() {}
    public CollectionDto(Collection<AttivitaDto> collection) {
        setCollection(collection);
        
    }
    

    public Collection<AttivitaDto> getCollection() {
        return collection;
    }

    public void setCollection(Collection<AttivitaDto> collection) {
       this.collection = Objects.requireNonNull(collection);
    }
    
}
