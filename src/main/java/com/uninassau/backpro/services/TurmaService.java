package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.model.RlcTurmaAluno;
import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.repositories.AlunoRepository;
import com.uninassau.backpro.repositories.RlcAlunoTurmaRepository;
import com.uninassau.backpro.repositories.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final RlcAlunoTurmaRepository rlcAlunoTurmaRepository;
    private final AlunoRepository alunoRepository;

    public List<Turma> buscarTurmas() {
        return turmaRepository.findAll();
    }

    public void salvarTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    public void vincularAlunosAturma(List<Long> guidAlunos, Long turma) {
        try {
            if (guidAlunos == null || guidAlunos.isEmpty()) {
                // Teoricamente o campo ja deve ser obrigatório, mas vamos garantir que não seja nulo ou vazio
                throw new IllegalArgumentException("A lista de alunos não pode ser nula ou vazia.");
            }

            Turma turmaEntity = turmaRepository.findById(turma)
                    .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + turma));

            guidAlunos.forEach(guidAluno -> {
                Aluno aluno = alunoRepository.findById(guidAluno)
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + guidAluno));
                rlcAlunoTurmaRepository.save(new RlcTurmaAluno(aluno, turmaEntity));
            });

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
