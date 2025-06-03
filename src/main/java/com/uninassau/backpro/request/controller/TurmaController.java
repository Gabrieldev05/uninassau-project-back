package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.model.dto.TurmaDTO;
import com.uninassau.backpro.model.mapper.TurmaMapper;
import com.uninassau.backpro.request.api.TurmaApi;
import com.uninassau.backpro.request.response.ResponseApiTurma;
import com.uninassau.backpro.services.TurmaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class TurmaController implements TurmaApi {

    private final TurmaService service;
    private final TurmaMapper mapper;

    @Override
    public ResponseEntity<ResponseApiTurma> buscarTurmas() {
        log.info("Iniciando busca por turmas");
        try {
            List<Turma> turmas = service.buscarTurmas();
            if (turmas.isEmpty()){
                log.info("Nenhuma turma encontrada!");
                return ResponseEntity.ok().body(new ResponseApiTurma(null, "Nenhuma turma encontrada!"));
            }

            log.info("Turmas encontradas com sucesso! Retornando lista de turmas");
            return ResponseEntity.ok().body(new ResponseApiTurma(turmas.stream().map(
                    mapper::toDTO
            ).toList(), "Turmas encontradas com Sucesso!"));

        } catch (RuntimeException e) {
            log.error("Erro ao buscar turmas: {}", e.getMessage());
            throw new RuntimeException("Erro ao buscar turmas", e);
        }
    }

    @Override
    public ResponseEntity<ResponseApiTurma> salvarTurma(TurmaDTO turma) {
        log.info("Iniciando salvamento de turma: {}", turma.getNome());
        try {
            turma.setId(null);
            service.salvarTurma(mapper.toEntity(turma));
            log.info("Turma salva com sucesso: {}", turma.getNome());
            return ResponseEntity.ok().body(new ResponseApiTurma(null, "Turma salva com sucesso!"));
        } catch (RuntimeException e) {
            log.error("Erro ao salvar turma: {}", e.getMessage());
            throw new RuntimeException("Erro ao salvar turma", e);
        }
    }

    @Override
    public ResponseEntity<ResponseApiTurma> vincularAlunoATurma(List<Long> guid_alunos, Long turma) {
        log.info("Iniciando vinculação de alunos à turma: {}", turma);
        service.vincularAlunosAturma(guid_alunos, turma);
        return ResponseEntity.ok().body(new ResponseApiTurma(null, "Alunos vinculados com sucesso!"));
    }
}
