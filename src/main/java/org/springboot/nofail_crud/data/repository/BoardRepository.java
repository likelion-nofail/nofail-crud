package org.springboot.nofail_crud.data.repository;


import org.springboot.nofail_crud.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findById(String id);

}
