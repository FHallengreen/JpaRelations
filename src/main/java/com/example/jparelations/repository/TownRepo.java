package com.example.jparelations.repository;

import com.example.jparelations.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepo extends JpaRepository<Town, Integer> {
}
