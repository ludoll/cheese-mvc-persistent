package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=35, message = "Name is a required field")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;


    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Cheese() {  }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() { return this.category; }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cheese)) return false;

        Cheese cheese = (Cheese) o;

        if (id != cheese.id) return false;
        if (name != null ? !name.equals(cheese.name) : cheese.name != null) return false;
        if (description != null ? !description.equals(cheese.description) : cheese.description != null) return false;
        if (category != null ? !category.equals(cheese.category) : cheese.category != null) return false;
        return menus != null ? menus.equals(cheese.menus) : cheese.menus == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (menus != null ? menus.hashCode() : 0);
        return result;
    }
}
