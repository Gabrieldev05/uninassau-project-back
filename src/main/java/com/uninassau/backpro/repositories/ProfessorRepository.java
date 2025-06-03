package com.uninassau.backpro.repositories;

import com.uninassau.backpro.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
