package com.uninassau.backpro.controllers;

import com.uninassau.backpro.controllers.api.ProfessorApi;
import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ProfessorController implements ProfessorApi {

    private final ProfessorService service;

    @Override
    public ResponseEntity<List<Professor>> buscarProfessor() {
        List<Professor> professores = service.bucarProfessores();
        return ResponseEntity.ok().body(professores);
    }

    @Override
    public ResponseEntity salvarProfessor(Professor professor) {
        service.salvarProfessor(professor);
        return ResponseEntity.ok().build();
    }
}
