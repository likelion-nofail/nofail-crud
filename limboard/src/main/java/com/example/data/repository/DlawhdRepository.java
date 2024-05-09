package com.example.data.repository;

import com.example.data.entity.Dlawhd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DlawhdRepository extends JpaRepository<Dlawhd, Long> {
    Optional<Dlawhd> findByEmail(String email);
}
