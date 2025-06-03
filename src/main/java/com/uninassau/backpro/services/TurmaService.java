package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.repositories.TurmaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public List<Turma> buscarTurmas() {
        return turmaRepository.findAll();
    }

    @Transactional
    public void salvarTurma(Turma turma) {
        turmaRepository.save(turma);
    }
}
