package com.example.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String zipCode;
    private String mayour;
    private String schools;

    public Town(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", mayour='" + mayour + '\'' +
                ", schools='" + schools + '\'' +
                '}';
    }
}
