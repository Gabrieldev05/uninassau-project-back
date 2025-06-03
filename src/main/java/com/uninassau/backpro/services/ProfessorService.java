package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;

    public List<Professor> bucarProfessores(){
        return repository.findAll();
    }

    public void salvarProfessor(Professor professor) {
        repository.save(professor);
    }
}
