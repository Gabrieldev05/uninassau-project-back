package com.uninassau.backpro.services;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.RlcTurmaProfessor;
import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.repositories.ProfessorRepository;
import com.uninassau.backpro.repositories.RlcTurmaProfessorRepository;
import com.uninassau.backpro.repositories.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;
    private final RlcTurmaProfessorRepository rlcTurmaProfessorRepository;
    private final TurmaRepository turmaRepository;

    public List<Professor> bucarProfessores(){
        return repository.findAll();
    }

    public void salvarProfessor(Professor professor) {
        repository.save(professor);
    }

    public void voincularTurmasAoProfessor(List<Long> guidTurmas, Long professorId) {
        try {
            if (guidTurmas == null || guidTurmas.isEmpty()) {
                // Teoricamente o campo ja deve ser obrigatório, mas vamos garantir que não seja nulo ou vazio
                throw new IllegalArgumentException("A lista de turmas não pode ser nula ou vazia.");
            }

            Professor professor = repository.findById(professorId)
                    .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + professorId));

            guidTurmas.forEach(guidTurma -> {
                Turma turma = turmaRepository.findById(guidTurma)
                        .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + guidTurma));
                rlcTurmaProfessorRepository.save(new RlcTurmaProfessor(turma, professor));
            });

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
