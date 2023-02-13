package com.example.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String zip;
    private String city;


    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


    /*  @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "address_id")*/
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Citizen> citizens = new ArrayList<>();

    public void addCitizen(Citizen citizen) {
        if (citizens == null) {
            citizens = new ArrayList<>();
        }
        citizens.add(citizen);
        citizen.setAddress(this);

    }


}
