package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunos(){
        return alunoRepository.findAll();
    }

    public void salvarAluno(Aluno aluno) {
        log.info("Salvando aluno: {}", aluno.getNome());
        alunoRepository.save(aluno);
    }
 }
