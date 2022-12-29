package com.davi.shop.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2)
    private String code;
    private String name;
    @OneToMany(mappedBy = "country")
    private Set<State> states = new HashSet<State>();

    public Country() {
    }

    public Country(Long id, String code, String name, Set<State> states) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.states = states;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<State> getStates() {
        return states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }
}
