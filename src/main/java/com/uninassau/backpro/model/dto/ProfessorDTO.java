package com.uninassau.backpro.model.dto;

import com.uninassau.backpro.model.Turma;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;
    private String nome;
    private String sexo;
    private int idade;
    private String disciplina;
    private List<Turma> turmas;
    private LocalDate dataAdmissao;
    private boolean concursado;
}
