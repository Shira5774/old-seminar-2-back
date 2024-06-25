package com.diversi_tech.demo.repository;

import com.diversi_tech.demo.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
}
