package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

@Entity
@Indexed
public class Animal extends PanacheEntity {

    @FullTextField
    @KeywordField(name = "type_sort", sortable = Sortable.YES)
    private String type;

    private Integer poids;

    @FullTextField
    private String bruit;

    public Animal() {
        this.type = null;
        this.poids = 0;
        this.bruit = null;
    }

    public Animal(String type, Integer poids, String bruit) {
        this.type = type;
        this.poids = poids;
        this.bruit = bruit;
    }

//    public Animal(Integer id, String type, Integer poids, String bruit) {
//        this.id = id;
//        this.type = type;
//        this.poids = poids;
//        this.bruit = bruit;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public String getBruit() {
        return bruit;
    }

    public void setBruit(String bruit) {
        this.bruit = bruit;
    }
}
