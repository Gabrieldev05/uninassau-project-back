package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunos(){
        return alunoRepository.findAll();
    }

 }
