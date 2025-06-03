package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.request.api.ProfessorApi;
import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.dto.ProfessorDTO;
import com.uninassau.backpro.model.mapper.ProfessorMapper;
import com.uninassau.backpro.request.response.ResponseApiProfessor;
import com.uninassau.backpro.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfessorController implements ProfessorApi {

    private final ProfessorService service;
    private final ProfessorMapper mapper;

    @Override
    public ResponseEntity<ResponseApiProfessor> buscarProfessor() {
        log.info("Iniciando busca por professores");
        try {
            List<Professor> professores = service.bucarProfessores();
            if (professores.isEmpty()) {
                log.info("Nenhum professor encontrado!");
                return ResponseEntity.ok().body(new ResponseApiProfessor(null, "Nenhum professor encontrado!"));
            }

            log.info("Professores encontrados com sucesso! Retornando lista de professores");
            return ResponseEntity.ok().body(new ResponseApiProfessor(professores.stream().map(
                    mapper::toDTO
            ).toList(), "Professor encontrado com Sucesso!"));

        } catch (RuntimeException e) {
            log.error("Erro ao buscar professores: {}", e.getMessage());
            throw new RuntimeException("Erro ao buscar professores", e);
        }
    }

    @Override
    public ResponseEntity<ResponseApiProfessor> salvarProfessor(ProfessorDTO professor) {
        log.info("Iniciando salvamento de professor: {}", professor.getNome());
        try {
            professor.setId(null);
            Professor entity = mapper.toEntity(professor);
            log.info("Convertendo DTO para entidade: {}", entity.getNome());
            service.salvarProfessor(entity);
            log.info("Professor salvo com sucesso: {}", professor.getNome());
            return ResponseEntity.ok().body(new ResponseApiProfessor(null, "Professor salvo com sucesso!"));

        } catch (RuntimeException e) {
            log.error("Erro ao salvar professor: {}", e.getMessage());
            throw new RuntimeException("Erro ao salvar professor", e);
        }
    }

    @Override
    public ResponseEntity<ResponseApiProfessor> vincularTurmasAoProfessor(List<Long> guid_turmas, Long professorId) {
        log.info("Iniciando vinculação de turmas ao professor com ID: {}", professorId);
        service.voincularTurmasAoProfessor(guid_turmas, professorId);
        return ResponseEntity.ok().body(new ResponseApiProfessor(null, "Vinculo realizado com sucesso!"));
    }
}
