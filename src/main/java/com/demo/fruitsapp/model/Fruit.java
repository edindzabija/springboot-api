package com.demo.fruitsapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fruit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private String secret;

    public Fruit() {
    }

    public Fruit(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Fruit(String name, String description, String secret) {
        this.name = name;
        this.description = description;
        this.secret = secret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Fruit{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}
