package org.springboot.nofail_crud.data.repository;

import org.springboot.nofail_crud.data.entity.Borden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BordenRepository extends JpaRepository<Borden, Long> {
    Optional<Borden> findByName(String name);
}
