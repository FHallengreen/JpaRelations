package com.example.jparelations.repository;

import com.example.jparelations.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

    public List<Citizen> findByTownId(int id);

    public List<Citizen> findByTownName(String name);
}
