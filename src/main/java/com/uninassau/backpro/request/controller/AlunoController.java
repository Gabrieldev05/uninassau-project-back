package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.exceptions.MensagemErrorException;
import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.model.dto.AlunoDTO;
import com.uninassau.backpro.model.mapper.AlunoMapper;
import com.uninassau.backpro.request.api.AlunoApi;
import com.uninassau.backpro.request.response.ResponseApiAluno;
import com.uninassau.backpro.services.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AlunoController implements AlunoApi {

    private final AlunoService service;
    private final AlunoMapper mapper;

    @Override
    public ResponseEntity<ResponseApiAluno> buscarAluno() {
        log.info("Iniciando busca por alunos");
        try {
            List<Aluno> alunos = service.buscarAlunos();
            if (alunos.isEmpty()) {
                log.info("Nenhum aluno encontrado!");
                return ResponseEntity.ok().body(new ResponseApiAluno(null, "Nenhum aluno encontrado!"));
            }

            log.info("Alunos encontrados com sucesso! Retornando lista de alunos");
            return ResponseEntity.ok().body(new ResponseApiAluno(
                    alunos.stream().map(
                            mapper::toDTO
                    ).toList(),
                    "Alunos encontrados com sucesso!"));
        } catch (RuntimeException e) {
            log.error("Erro ao buscar alunos: {}", e.getMessage());
            throw new MensagemErrorException("Erro ao buscar alunos", e);
        }
    }

    @Override
    public ResponseEntity<ResponseApiAluno> salvarAluno(AlunoDTO aluno) {
        log.info("Iniciando salvamento de aluno: {}", aluno.getNome());
        try {
            aluno.setId(null); // Garantir que o ID seja nulo para criação
            Aluno alunoEntity = mapper.toEntity(aluno);
            log.info("Convertendo AlunoDTO para Aluno Entity: {}", alunoEntity.getNome());
            service.salvarAluno(alunoEntity);
            log.info("Aluno salvo com sucesso: {}", aluno.getNome());
            return ResponseEntity.ok().body(new ResponseApiAluno(null, "Aluno salvo com sucesso!"));

        } catch (RuntimeException e) {
            log.error("Erro ao salvar aluno: {}", e.getMessage());
            throw new MensagemErrorException("Erro ao salvar aluno", e);
        }
    }
}
