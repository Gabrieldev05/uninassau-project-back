package com.uninassau.backpro.repositories;

import com.uninassau.backpro.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
