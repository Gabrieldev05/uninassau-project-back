package com.uninassau.backpro.repositories;

import com.uninassau.backpro.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
