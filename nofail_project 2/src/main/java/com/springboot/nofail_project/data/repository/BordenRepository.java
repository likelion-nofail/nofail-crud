package com.springboot.nofail_project.data.repository;

import com.springboot.nofail_project.data.entity.Borden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BordenRepository extends JpaRepository<Borden, Long> {
    Optional<Borden> findByName(String name);
}
